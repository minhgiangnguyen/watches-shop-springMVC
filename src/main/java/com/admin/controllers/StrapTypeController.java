package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.StrapType;
import com.watches.services.dao.StrapTypeDao;

@Controller
public class StrapTypeController {
	@Autowired
	StrapTypeDao strapTypeDAO;
	
	@RequestMapping("admin/straptype")
	public String strapType(Model model) {
		model.addAttribute("straptype", new StrapType());
		model.addAttribute("strapList", strapTypeDAO.getAll());
		model.addAttribute("page","straptype");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}
	@RequestMapping(value= "/admin/straptype/search",method = RequestMethod.POST)
	public String search(String searchname, Model model) {
		model.addAttribute("straptype", new StrapType());
		model.addAttribute("strapList",strapTypeDAO.search(searchname));
		model.addAttribute("page", "straptype");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping("admin/straptype/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("straptype", strapTypeDAO.getById(id));
		model.addAttribute("page", "straptype");
		model.addAttribute("strapList", strapTypeDAO.getAll());
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "admin/straptype/delete/{id}")
	public String delete(@PathVariable("id") int id,Model model) {
		boolean bl = strapTypeDAO.delete(id);
		model.addAttribute("msg",bl?"Delete successfully!":"Cannot delete strap type. It contains products!");
		model.addAttribute("colorCss", bl?"green":"red");
		model.addAttribute("straptype", new StrapType());
		model.addAttribute("strapList", strapTypeDAO.getAll());
		model.addAttribute("page", "straptype");
		model.addAttribute("fodder", "specs");		
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/straptype/save" }, method = RequestMethod.POST)
	public String save( @ModelAttribute("straptype") StrapType straptype, 
			Model model) {
	
		String msgSuccess=straptype.getStrapTypeId() == 0?"Insert successfully!":"Update successfully!";
		String msgFail=straptype.getStrapTypeId() == 0?"Insert failed!":"Update failed!";
		boolean bl = straptype.getStrapTypeId() == 0 ? strapTypeDAO.insert(straptype) : strapTypeDAO.update(straptype);
		if (bl) {
			model.addAttribute("msg",msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("straptype", new StrapType());
			model.addAttribute("strapList", strapTypeDAO.getAll());
			model.addAttribute("page", "straptype");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("straptype", straptype);
			model.addAttribute("strapList", strapTypeDAO.getAll());
			model.addAttribute("page", "straptype");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		}
	}
}
