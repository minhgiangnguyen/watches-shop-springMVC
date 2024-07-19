package com.home.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.watches.entities.Account;
import com.watches.services.dao.AccountDao;
import com.watches.services.dao.impl.AccountImpl;
import com.watches.util.Cipher;


@Controller
public class AccHomeController {
	   @Autowired
	   AccountDao accountDAO;
	   @Autowired
	   AccountImpl accountService;
	   
	   //get: form login
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login(Model model) {
			model.addAttribute("page", "login");
			model.addAttribute("fodder", "account");
			return "home/index";
		}
	// POST: dang-nhap (xử lý đăng nhập)
		@RequestMapping(value = "login", method = RequestMethod.POST)
		public String loginProcess( String username, String password, Model model, HttpServletRequest req) {
			Account acc = accountService.getAccount(username);
			String passMd5 = Cipher.GenerateMD5(password);
			if (acc == null || !acc.getPassword().equals(passMd5)) {
				model.addAttribute("msg", "Wrong information login");				
				model.addAttribute("page", "login");
				model.addAttribute("fodder", "account");
				return "home/index";
			}
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(3600);
			session.setAttribute("userid", acc.getAccountId());
			session.setAttribute("avatar", acc.getAvatar());
			session.setAttribute("fullname", acc.getFullName());
			session.setAttribute("address", acc.getAddress());
			session.setAttribute("phone", acc.getPhone());
			return "redirect:/home";
		}

		// GET: thoat
		@RequestMapping(value = "logout")
		public String logout(Model model, HttpServletRequest req) {
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:/login/";
		}
		
		// GET : đến trang đăng ký
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public String register(Model model) {
			model.addAttribute("account", new Account());
			model.addAttribute("page", "register");
			model.addAttribute("fodder", "account");
			return "home/index";
		}
		// POST: Lưu thông tin đăng ký vào bảng Account
		@RequestMapping(value = { "/register/save" }, method = RequestMethod.POST)
	    public String save(@Valid @ModelAttribute("account") Account acc,BindingResult result, Model model, HttpServletRequest req, @RequestParam("file") MultipartFile file) {
	        String uploadRootPath = req.getServletContext().getRealPath("resources/assets_admin/dist/img/account");
	        String accountId = UUID.randomUUID().toString();
	        try {
	            if (file != null && !file.isEmpty()) {
	                // Validate file type and size
	                if (!file.getContentType().startsWith("image/") || file.getSize() > 5 * 1024 * 1024) { // Example: only allow images and limit size to 5MB
	                    model.addAttribute("msg", "Invalid file type or size!");
	                    return "redirect:/register/";
	                }
	                File destination = new File(uploadRootPath, file.getOriginalFilename());
	                file.transferTo(destination);
	                acc.setAvatar(file.getOriginalFilename());
	            }
	            acc.setPassword(Cipher.GenerateMD5(acc.getPassword()));
	            
	            acc.setAccountId(accountId);
	            acc.setCreateDate(Date.valueOf(LocalDate.now()));
	            accountDAO.insert(acc);	                   
	            model.addAttribute("success", "Sign Up Success!");
	            model.addAttribute("page", "register");
	            model.addAttribute("fodder", "account");
	            return "home/index";
	        } catch (IOException e) {
	            model.addAttribute("msg", "File upload failed!");
	            e.printStackTrace();
	            return "redirect:/register/";
	        } catch (Exception e) {
	            model.addAttribute("msg", "Registration failed!");
	            e.printStackTrace();
	            return "redirect:/register/";
	        }
	    }
}
