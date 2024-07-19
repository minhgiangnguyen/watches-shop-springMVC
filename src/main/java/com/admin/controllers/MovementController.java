package com.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Movements;

import com.watches.services.dao.MovementDao;

@Controller
public class MovementController {
	@Autowired
	MovementDao movementDAO;

	@RequestMapping("admin/movement")
	public String strapType(Model model) {
		model.addAttribute("movement", new Movements());
		model.addAttribute("moveList", movementDAO.getAll());
		model.addAttribute("page", "movement");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "/admin/movement/search", method = RequestMethod.POST)
	public String search(String searchname, Model model) {
		model.addAttribute("movement", new Movements());
		model.addAttribute("moveList", movementDAO.search(searchname));
		model.addAttribute("page", "movement");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping("admin/movement/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("movement", movementDAO.getById(id));
		model.addAttribute("page", "movement");
		model.addAttribute("moveList", movementDAO.getAll());
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = "admin/movement/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = movementDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete movement. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("movement", new Movements());
		model.addAttribute("moveList", movementDAO.getAll());
		model.addAttribute("page", "movement");
		model.addAttribute("fodder", "specs");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/movement/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("movement") Movements movement, Model model) {

		String msgSuccess = movement.getMovementId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = movement.getMovementId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = movement.getMovementId() == 0 ? movementDAO.insert(movement) : movementDAO.update(movement);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("movement", new Movements());
			model.addAttribute("moveList", movementDAO.getAll());
			model.addAttribute("page", "movement");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("movement", movement);
			model.addAttribute("moveList", movementDAO.getAll());
			model.addAttribute("page", "movement");
			model.addAttribute("fodder", "specs");
			return "admin/index";
		}
	}
}
