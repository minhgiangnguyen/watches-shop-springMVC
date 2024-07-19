package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Color;
import com.watches.services.dao.ColorDao;

@Controller
public class ColorController {
	@Autowired
	ColorDao colorDAO;

	@RequestMapping("admin/color")
	public String strapType(Model model) {
		model.addAttribute("color", new Color());
		model.addAttribute("colorList", colorDAO.getAll());
		model.addAttribute("page", "color");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "/admin/color/search", method = RequestMethod.POST)
	public String search(String searchname, Model model) {
		model.addAttribute("color", new Color());
		model.addAttribute("colorList", colorDAO.search(searchname));
		model.addAttribute("page", "color");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping("admin/color/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("color", colorDAO.get(id));
		model.addAttribute("page", "color");
		model.addAttribute("colorList", colorDAO.getAll());
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "admin/color/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = colorDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete color. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("color", new Color());
		model.addAttribute("colorList", colorDAO.getAll());
		model.addAttribute("page", "color");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/color/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("color") Color color, Model model) {

		String msgSuccess = color.getColorId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = color.getColorId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = color.getColorId() == 0 ? colorDAO.insert(color) : colorDAO.update(color);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("color", new Color());
			model.addAttribute("colorList", colorDAO.getAll());
			model.addAttribute("page", "color");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("color", color);
			model.addAttribute("colorList", colorDAO.getAll());
			model.addAttribute("page", "color");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		}
	}
}
