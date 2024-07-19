package com.home.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.entities.WatchSpecsWithSale;
import com.watches.services.dao.BannerWithExpireDAO;
import com.watches.services.dao.BrandDao;
import com.watches.services.dao.ColorDao;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.WatchDao;
import com.watches.services.dao.WatchSpecsWithSaleDAO;
import com.watches.services.dao.WatchTopBuyDAO;

@Controller
public class HomeController {
	@Autowired
	WatchDao watchDao;
	@Autowired
	BrandDao brandDao;
	@Autowired
	GenderDao genderDao;
	@Autowired
	ColorDao colorDao;
	@Autowired
	WatchSpecsWithSaleDAO watchSpecsWithSaleDao;
	@Autowired
	WatchTopBuyDAO watchTopBuyDao;
	@Autowired
	BannerWithExpireDAO bannerExpireDAO;

	@RequestMapping(value = { "/", "home" })
	public String index(Model model) {
		int limitPro = 8;
		model.addAttribute("banner", bannerExpireDAO.get());

		model.addAttribute("genders", genderDao.getAll());
		model.addAttribute("brands", brandDao.getAll());
		model.addAttribute("watchs", watchSpecsWithSaleDao.getLastestWatches(limitPro));
		model.addAttribute("watchsTopBuy", watchTopBuyDao.getLimit(limitPro));

		model.addAttribute("page", "home_content");
		return "home/index";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String searchProductByGet(@RequestParam(required = false, name = "q") String q, Model model,
			HttpServletRequest req) {

		List<WatchSpecsWithSale> watches = watchSpecsWithSaleDao.search(q);

		if (watches.isEmpty()) {
			model.addAttribute("isEmpty", true);
		} else {
			model.addAttribute("isEmpty", false);
			model.addAttribute("watches", watches);
		}
		model.addAttribute("watches", watches);
//		model.addAttribute("currentUrl",req.getRequestURL().toString());

		model.addAttribute("genders", genderDao.getAll());
		model.addAttribute("brands", brandDao.getAll());
		model.addAttribute("page", "products");
		model.addAttribute("fodder", "watches");
		return "home/index";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String searchProductByPost(@RequestParam(required = false, name = "q") String q, Model model) {
		int limit = 5;
		List<WatchSpecsWithSale> watches = watchSpecsWithSaleDao.search(q, limit);

		if (watches.isEmpty()) {
			model.addAttribute("isEmpty", true);
		} else {
			model.addAttribute("isEmpty", false);
			model.addAttribute("watches", watches);
		}

		return "home/search_watches";
	}

}
