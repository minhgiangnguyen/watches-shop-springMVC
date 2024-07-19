package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Sizes;

import com.watches.services.dao.SizeDao;

@Controller
public class SizeController {
	@Autowired
	SizeDao sizeDAO;

	@RequestMapping("admin/sizes")
	public String strapType(Model model) {
		model.addAttribute("sizes", new Sizes());
		model.addAttribute("sizeList", sizeDAO.getAll());
		model.addAttribute("page", "sizes");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "/admin/sizes/search", method = RequestMethod.POST)
	public String search(int searchvalue, Model model) {
		model.addAttribute("sizes", new Sizes());
		model.addAttribute("sizeList", sizeDAO.search(searchvalue));
		model.addAttribute("page", "sizes");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping("admin/sizes/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("sizes", sizeDAO.getById(id));
		model.addAttribute("page", "sizes");
		model.addAttribute("sizeList", sizeDAO.getAll());
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "admin/sizes/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = sizeDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete size value. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("sizes", new Sizes());
		model.addAttribute("sizeList", sizeDAO.getAll());
		model.addAttribute("page", "sizes");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/sizes/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("sizes") Sizes sizes, Model model) {

		String msgSuccess = sizes.getSizeId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = sizes.getSizeId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = sizes.getSizeId() == 0 ? sizeDAO.insert(sizes) : sizeDAO.update(sizes);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("sizes", new Sizes());
			model.addAttribute("sizeList", sizeDAO.getAll());
			model.addAttribute("page", "sizes");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("sizes", sizes);
			model.addAttribute("sizeList", sizeDAO.getAll());
			model.addAttribute("page", "sizes");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		}
	}
}
