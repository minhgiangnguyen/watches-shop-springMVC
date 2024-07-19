package com.home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watches.entities.WatchSpecsWithSale;
import com.watches.services.dao.BrandDao;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.WatchDao;
import com.watches.services.dao.ColorDao;
import com.watches.services.dao.WatchSpecsDAO;
import com.watches.services.dao.WatchSpecsWithSaleDAO;

@Controller
public class ProDetailController {
	@Autowired
	BrandDao brandDao;
	@Autowired
	GenderDao genderDao;
	@Autowired
	ColorDao colorDao;
	@Autowired
	WatchDao watchDao;
	@Autowired
	WatchSpecsWithSaleDAO watchSpecsWithSaleDao;
	
	@RequestMapping("shop/{slug}")
	public String showDetail(@PathVariable String slug ,Model model) {
		System.out.println(slug);
		WatchSpecsWithSale watch = watchSpecsWithSaleDao.get(slug);
		String[] pictureList =watch.getPictureList().split(";");
		model.addAttribute("genders",genderDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("watch",watchSpecsWithSaleDao.get(slug));
		model.addAttribute("pictureList",pictureList);
		model.addAttribute("page","details");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
//	@RequestMapping("watches/detail")
//	public String show(Model model) {
//		model.addAttribute("categories",categoryDao.getAll());
//		model.addAttribute("page","details");
//		model.addAttribute("fodder","watches");
//		return "home/index";
//	}
}
