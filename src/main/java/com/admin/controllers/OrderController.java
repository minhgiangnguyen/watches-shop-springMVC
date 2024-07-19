package com.admin.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.OrderWatch;
import com.watches.services.dao.OrderDao;

@Controller
public class OrderController {
	@Autowired
	OrderDao orderDao;

	@RequestMapping(value = { "admin/orders" })
	public String show(Model model) {
		model.addAttribute("orderList", orderDao.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "orders");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/orders/edit/{id}" })
	public String edit(@PathVariable("id") String id, Model model) {
		model.addAttribute("order", orderDao.get(id));
		model.addAttribute("page", "edit");
		model.addAttribute("fodder", "orders");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/orders/edit" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("order") OrderWatch orderw, Model model) {
		String msgFail = "Update failed!";
		String msgSuccess = "Update successfully!";
		orderw.setOrderDate(Date.valueOf(LocalDate.now()));
		boolean bl = orderDao.update(orderw);
		if (bl) {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("orderList", orderDao.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "orders");
			return "admin/index";
		}else {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("orderList", orderDao.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "orders");
			return "admin/index";
		}
	}
	
}
