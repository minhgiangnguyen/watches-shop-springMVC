package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.watches.entities.Account;
import com.watches.services.dao.AccountDao;

@Controller
public class AccountController {
   @Autowired
   AccountDao accountDAO;
   
   
   @RequestMapping(value = { "admin/account" })
	public String show(Model model) {
		model.addAttribute("accList",accountDAO.getAll());
		model.addAttribute("page","list");
		model.addAttribute("fodder","account");
		return "admin/index";
	}
	@RequestMapping(value = { "admin/account/edit/{id}" })
	public String edit(@PathVariable("id") String id,Model model) {	
		model.addAttribute("account", accountDAO.get(id));
		model.addAttribute("page","edit");
		model.addAttribute("fodder","account");
		return "admin/index";
	}
	@RequestMapping(value = { "/admin/account/edit" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("account") Account account
			, @RequestParam("file") MultipartFile file, Model model
			,HttpServletRequest req,String pictureOld) {		
		String[] imageType=new String[]{"image/jpeg","image/png","image/jpg"};
		if (file != null && !file.isEmpty()) {
			if(!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err","Avatar is incorrect image type");
				model.addAttribute("account",account);
				model.addAttribute("page","edit");
				model.addAttribute("fodder","account");
				return "admin/index";	
			}
			 if(file.getSize()>=1024*1024*10) {
				model.addAttribute("err","Avatar can not than 10mb");
				model.addAttribute("account",account);
				model.addAttribute("page","edit");
				model.addAttribute("fodder","account");
				return "admin/index";
			}
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_admin/dist/img/account");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.setAvatar(file.getOriginalFilename());
		} else {
			account.setAvatar(pictureOld);
		}
		account.setCreateDate(Date.valueOf(LocalDate.now()));
		String msgFail="Update failed!";
		String msgSuccess="Update successfully!";
		boolean bl =accountDAO.update(account);
		if (bl) {		
			model.addAttribute("msg",msgFail );
			model.addAttribute("colorCss", "red");
			model.addAttribute("accList",accountDAO.getAll());
			model.addAttribute("page","list");
			model.addAttribute("fodder","account");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("accList",accountDAO.getAll());
			model.addAttribute("page","list");
			model.addAttribute("fodder","account");
			return "admin/index";
		}
				
	}
   
}
