package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Material;

import com.watches.services.dao.MaterialDao;

@Controller
public class MaterialController {
	@Autowired
	MaterialDao materialDAO;

	@RequestMapping("admin/material")
	public String strapType(Model model) {
		model.addAttribute("material", new Material());
		model.addAttribute("materialList", materialDAO.getAll());
		model.addAttribute("page", "material");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "/admin/material/search", method = RequestMethod.POST)
	public String search(String searchname, Model model) {
		model.addAttribute("material", new Material());
		model.addAttribute("materialList", materialDAO.search(searchname));
		model.addAttribute("page", "material");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}
	
	@RequestMapping("admin/material/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("material", materialDAO.getById(id));
		model.addAttribute("page", "material");
		model.addAttribute("materialList", materialDAO.getAll());
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}
	
	@RequestMapping(value = "admin/material/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = materialDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete material. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("material", new Material());
		model.addAttribute("materialList", materialDAO.getAll());
		model.addAttribute("page", "material");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}
	
	@RequestMapping(value = { "/admin/material/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("material") Material material, Model model) {

		String msgSuccess = material.getMaterialId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = material.getMaterialId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = material.getMaterialId() == 0 ? materialDAO.insert(material) : materialDAO.update(material);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("material", new Material());
			model.addAttribute("materialList", materialDAO.getAll());
			model.addAttribute("page", "material");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("material", material);
			model.addAttribute("materialList", materialDAO.getAll());
			model.addAttribute("page", "material");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		}
	}

}
