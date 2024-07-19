package com.admin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Account;
import com.watches.services.dao.AccountDao;
import com.watches.services.dao.impl.AccountImpl;
import com.watches.util.Cipher;


@Controller
public class LogController {
     @Autowired
     AccountDao accountDAO;
     @Autowired
     AccountImpl accountService;
     
  // đăng nhập admin GET: admin
 	@RequestMapping(value = "admin/login", method = RequestMethod.GET)
 	public String login(Model model) {
 		return "admin/login";
 	}

 	// POST:xử lý admin login
 	@RequestMapping(value = "admin/login", method = RequestMethod.POST)
 	public String loginProcess(String userName, String password, Model model, HttpServletRequest req) {
 		Account acc = accountService.getAccount(userName);
 		String passMd5 = Cipher.GenerateMD5(password);
 		if (acc == null || !acc.getPassword().equals(passMd5) || !acc.isRole()==(Boolean.TRUE)) {
 			model.addAttribute("msg", "Wrong login information or you do not have permission!");
 			return "admin/login";
 		}
 		HttpSession session = req.getSession();
 		session.setMaxInactiveInterval(3600);
 		session.setAttribute("adminid", acc.getAccountId());
 		session.setAttribute("adminpicture", acc.getAvatar());
 		session.setAttribute("adminfullname", acc.getFullName());
 		return "redirect:/admin/";
 	}

 	// GET: admin/logout
 	@RequestMapping(value = "admin/logout")
 	public String logout(Model model, HttpServletRequest req) {
 		HttpSession session = req.getSession();
 		session.invalidate();
 		return "redirect:/admin/login";
 	}
}
