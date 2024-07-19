package com.admin.controllers;


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

import com.watches.entities.Promotion;
import com.watches.entities.PromotionWatch;
import com.watches.entities.PromotionWatchForm;
import com.watches.services.dao.PromotionDAO;
import com.watches.services.dao.PromotionWatchDAO;
import com.watches.services.dao.PromotionWithExpireDAO;
import com.watches.services.dao.WatchDao;
import com.watches.services.dao.WatchSelectPromoDAO;
import com.watches.services.dao.WatchWithPromotionDAO;

@Controller
public class PromotionController {
	
	@Autowired
	PromotionDAO promotionDao;
	@Autowired
	WatchDao watchDao;
	@Autowired
	PromotionWatchDAO promoWatchDao;
	@Autowired
	WatchWithPromotionDAO watchWithPromoDAO;
	@Autowired
	PromotionWithExpireDAO promotionExpireDao;
	@Autowired
	WatchSelectPromoDAO watchSelectPromoDao;
	

	@RequestMapping(value = { "admin/promotion/add" })
	public String add(Model model) {
		model.addAttribute("nameForm", "Add");
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "promotion");
		return "admin/index";
	}
	@RequestMapping(value = { "admin/promotion/edit/{promoId}" })
	public String edit(@PathVariable("promoId") int promoId,Model model) {
		model.addAttribute("nameForm", "Edit");
		model.addAttribute("promotion",promotionDao.get(promoId));
		model.addAttribute("page","form");
		model.addAttribute("fodder","promotion");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/promotion","admin/promotion/list" })
	public String list(Model model) {
		model.addAttribute("promoList", promotionExpireDao.getAll());
//		model.addAttribute("watches", watchWithPromoDAO.getWatchsPromotionByPromoId(1));	
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "promotion");
		return "admin/index";
	}
	
	@RequestMapping(value = { "admin/promotion/show-watches/{promoId}" }, method = RequestMethod.POST)
	public String showWatches(@PathVariable int promoId, Model model) {
		model.addAttribute("watches", watchWithPromoDAO.getWatchsPromotionByPromoId(promoId));	

		return "admin/promotion/watches";

	}
	@RequestMapping(value = { "admin/promotion/{promoId}/watches/delete/{watchId}" })
	public String deleteWatch(@PathVariable("watchId") int watchId,@PathVariable("promoId") int promoId,Model model) {
		boolean bl = promoWatchDao.delete(watchId, promoId);
		model.addAttribute("promoList", promotionExpireDao.getAll());
//		model.addAttribute("watches", watchWithPromoDAO.getWatchsPromotionByPromoId(promoId));	
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "promotion");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/promotion/list/{promoId}/select-watch" })
	public String selectWatch(@PathVariable int promoId, Model model) {
		model.addAttribute("watchList", watchSelectPromoDao.getWatchesSelect(promoId));
		model.addAttribute("promoWatchForm", new PromotionWatchForm());
		model.addAttribute("page", "select_watch");
		model.addAttribute("fodder", "promotion");
		model.addAttribute("promoId", promoId);
		return "admin/index";
	}

	@RequestMapping(value = { "admin/promotion/list/{promoId}/select-watch/save" }, method = RequestMethod.POST)
	public String saveSelectWatch(@PathVariable int promoId,
			@ModelAttribute("promoWatchForm") PromotionWatchForm promoWatchForm, Model model) {
		String msgSuccess = "Insert successfully!";
		String msgFail = "Insert failed!";
		if (promoWatchForm.getWatchIdList()==null || promoWatchForm.getWatchIdList().length== 0) {
			return "redirect:/admin/promotion/list";
		}
		for (int watchId : promoWatchForm.getWatchIdList()) {
			PromotionWatch promoWatch = new PromotionWatch();
			promoWatch.setPromoId(promoId);
			promoWatch.setWatchId(watchId);
			boolean bl = promoWatchDao.insert(promoWatch);
			if (bl == false) {
				model.addAttribute("msg", msgFail);
				model.addAttribute("colorCss", "red");
				model.addAttribute("watchList", watchDao.getAll());
				model.addAttribute("promoWatch", promoWatchForm);
				model.addAttribute("page", "select_watch");
				model.addAttribute("fodder", "promotion");
				model.addAttribute("promoId", promoId);
				return "admin/index";
			}
		}
		
		model.addAttribute("msg", msgSuccess);
		model.addAttribute("colorCss", "green");
		model.addAttribute("promoList", promotionExpireDao.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "promotion");
		return "admin/index";

	}
	

	@RequestMapping(value = { "/admin/promotion/save" }, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("promotion") Promotion promo, BindingResult result,
			 Model model, HttpServletRequest req) {

		String msgSuccess = promo.getPromotionId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = promo.getPromotionId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = promo.getPromotionId() == 0 ? promotionDao.insert(promo) : promotionDao.update(promo);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("promoList", promotionExpireDao.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "promotion");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("promotion", promo);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "promotion");
			return "admin/index";
		}
	}

}
