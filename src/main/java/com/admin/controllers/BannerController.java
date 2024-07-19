package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.watches.entities.Banner;
import com.watches.services.dao.BannerDAO;
import com.watches.services.dao.BannerWithExpireDAO;

@Controller
public class BannerController {
	@Autowired
	BannerDAO bannerDao;
	@Autowired
	BannerWithExpireDAO bannerExpireDAO;

	@RequestMapping(value = { "admin/banner/add" })
	public String add(Model model) {
		model.addAttribute("nameForm", "Add");
		model.addAttribute("banner", new Banner());
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "banner");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/banner/edit/{bannerId}" })
	public String edit(@PathVariable("bannerId") int bannerId, Model model) {
		model.addAttribute("nameForm", "Edit");
		model.addAttribute("banner", bannerDao.get(bannerId));
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "banner");
		return "admin/index";
	}

	

	@RequestMapping(value = { "admin/banner", "admin/banner/list" })
	public String list(Model model) {
		model.addAttribute("bannerList", bannerExpireDAO.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "banner");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/banner/save" }, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("banner") Banner banner,BindingResult result,
			@RequestParam("file") MultipartFile file,
		 Model model, HttpServletRequest req, String pictureOld) {
		
		String[] imageType = new String[] { "image/jpeg", "image/png", "image/jpg" };
		if (file.isEmpty() && pictureOld.equals("")) {
			model.addAttribute("err", "Picture has not been uploaded");
			model.addAttribute("banner", banner);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "banner");
			return "admin/index";
		} else if (!file.isEmpty()) {
			if (!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err", "Picture is incorrect image type");
				model.addAttribute("banner", banner);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "banner");
				return "admin/index";
			}
			if (file.getSize() >= 1024 * 1024 * 10) {
				model.addAttribute("err", "Picture can not than 10mb");
				model.addAttribute("banner", banner);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "banner");
				return "admin/index";
			}

		}

		if (file != null && !file.isEmpty()) {
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_home/img/banner");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			banner.setPicture(file.getOriginalFilename());
		} else {
			banner.setPicture(pictureOld);
		}
		
		String msgSuccess = banner.getBannerId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = banner.getBannerId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = banner.getBannerId() == 0 ? bannerDao.insert(banner) : bannerDao.update(banner);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("bannerList", bannerExpireDAO.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "banner");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("banner", banner);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "banner");
			return "admin/index";
		}
	}
}
