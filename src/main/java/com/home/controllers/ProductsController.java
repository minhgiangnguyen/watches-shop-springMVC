package com.home.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecsWithSale;
import com.watches.services.dao.BrandDao;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.ColorDao;
import com.watches.services.dao.WatchDao;
import com.watches.services.dao.WatchSpecsWithSaleDAO;

@Controller
public class ProductsController {
	@Autowired
	WatchDao watchDao;
	@Autowired
	BrandDao brandDao;
	@Autowired
	GenderDao categoryDao;
	@Autowired
	ColorDao colorDao;
	@Autowired
	GenderDao genderDao;
	
	@Autowired
	WatchSpecsWithSaleDAO watchSpecsWithSaleDao;
	
	private int pageSize=9;
	@RequestMapping(value={"watches","watches/all"})
	public String showAll(Integer pageNo,Model model,HttpServletRequest req) {
		model.addAttribute("nameList","All product");
		
		pageNo = pageNo == null ? 1 : pageNo;
		WatchPage watchPage = watchSpecsWithSaleDao.getAllWithPaging(pageSize,pageNo);
		model.addAttribute("isEmpty",false);
		model.addAttribute("watches",watchPage.getWatches());
		model.addAttribute("totalPage",watchPage.getTotalPages());
		model.addAttribute("currentPage",watchPage.getCurrentPage());
//		model.addAttribute("currentUrl",req.getRequestURL().toString());
		
		model.addAttribute("colors",colorDao.getAll());
		model.addAttribute("genders",genderDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	@RequestMapping("sale")
	public String showAllSale(Model model) {
		model.addAttribute("nameList","Sale");
		List<WatchSpecsWithSale> watchesSale = watchSpecsWithSaleDao.getAllSale();
		if(watchesSale.isEmpty()) {
			model.addAttribute("isEmpty",true);
		}else {
			model.addAttribute("isEmpty",false);
			model.addAttribute("watches",watchesSale);
		}
		model.addAttribute("watches",watchesSale);
		
		model.addAttribute("colors",colorDao.getAll());
		model.addAttribute("genders",genderDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	@RequestMapping("watches/shop/{gender}")
	public String showProductsByGender(@PathVariable String gender,Integer pageNo
			, Model model,HttpServletRequest req) {
		model.addAttribute("nameList",gender);
		pageNo = pageNo == null ? 1 : pageNo;
		WatchPage watchPage = watchSpecsWithSaleDao.getByGender(pageSize, pageNo, gender);
		model.addAttribute("isEmpty",false);
		model.addAttribute("watches",watchPage.getWatches());
		model.addAttribute("totalPage",watchPage.getTotalPages());
		model.addAttribute("currentPage",watchPage.getCurrentPage());
		
		model.addAttribute("colors",colorDao.getAll());
		model.addAttribute("genders",genderDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	
	
	@RequestMapping("watches/brand/{brandName}")
	public String showProductsByBrand(@PathVariable String brandName,Integer pageNo
			, Model model,HttpServletRequest req) {
		
		model.addAttribute("nameList",brandName);
		
		pageNo = pageNo == null ? 1 : pageNo;
		WatchPage watchPage = watchSpecsWithSaleDao.getByBrand(pageSize, pageNo, brandName);
		model.addAttribute("isEmpty",false);
		model.addAttribute("watches",watchPage.getWatches());
		model.addAttribute("totalPage",watchPage.getTotalPages());
		model.addAttribute("currentPage",watchPage.getCurrentPage());

		model.addAttribute("colors",colorDao.getAll());
		model.addAttribute("genders",genderDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	
	@RequestMapping(value = { "/filter-price" }, method = RequestMethod.GET)
	public String filterPrice(@RequestParam(name = "fromPrice") String fromPrice,@RequestParam(name = "toPrice") String toPrice,Model model,HttpServletRequest req) {
		float from =  fromPrice == null || fromPrice.equals("") ? 0 : Float.parseFloat(fromPrice);
		float to =  toPrice == null || toPrice.equals("") ? 0 : Float.parseFloat(toPrice);
		model.addAttribute("categories",categoryDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("colors",colorDao.getAll());
		
		model.addAttribute("watches",watchSpecsWithSaleDao.filter(from, to));
		model.addAttribute("currentUrl",req.getRequestURL().toString());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	@RequestMapping(value = { "/filter-color" }, method = RequestMethod.GET)
	public String filterColor(@RequestParam(name = "color") String color,Model model,HttpServletRequest req) {
		model.addAttribute("categories",categoryDao.getAll());
		model.addAttribute("brands",brandDao.getAll());
		model.addAttribute("colors",colorDao.getAll());
		
		model.addAttribute("watches",watchSpecsWithSaleDao.filter(color));
		model.addAttribute("currentUrl",req.getRequestURL().toString());
		model.addAttribute("page","products");
		model.addAttribute("fodder","watches");
		return "home/index";
	}
	
	
	
}
