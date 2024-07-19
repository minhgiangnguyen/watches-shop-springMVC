package com.home.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.watches.entities.Basket;
import com.watches.entities.OrderDetail;
import com.watches.entities.OrderWatch;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.OrderDao;
import com.watches.services.dao.WatchDao;


@Controller
public class CheckoutController {
	@Autowired
	OrderDao orderDao;
	@Autowired
	  GenderDao categoryDao;
	@Autowired
	WatchDao watchDao;
	//Get : check out 
	 @RequestMapping(value = "/checkout",  method = RequestMethod.GET)
	 public String checkout(Model model, HttpServletRequest req) {
		 model.addAttribute("categories",categoryDao.getAll());
			model.addAttribute("page", "checkout");
			model.addAttribute("fodder", "cart");
			List<Basket> baskets = new ArrayList<>();
			HttpSession session = req.getSession();
			if (session.getAttribute("basket") != null) {
				baskets = (List<Basket>) session.getAttribute("basket");
			}
			model.addAttribute("baskets", baskets);
			model.addAttribute("numberOrder", baskets.size());
			return "home/index";
	 }
	//POST: dat-hang "xử lý đặt hang"
		@RequestMapping(value = "checkout",  method = RequestMethod.POST)
		public String addOrder(String address, String phone, String note, Model model, HttpServletRequest req) {
			
			List<Basket> baskets=null;
			HttpSession session = req.getSession();
			if (session.getAttribute("userid") == null) {
				return "redirect:/login";
			}
			else if (session.getAttribute("basket") != null) {
				baskets = (List<Basket>) session.getAttribute("basket");
				String timeStamp = new SimpleDateFormat("yyMMdd-HHmmss").format(Calendar.getInstance().getTime());
				OrderWatch order=new OrderWatch();
				order.setOrderId("HD"+timeStamp);
				order.setAccountId(session.getAttribute("userid").toString());
				order.setOrderDate(Date.valueOf(LocalDate.now()));
				order.setReceiveAddress(address);
				order.setReceiveDate(null);
				order.setReceivePhone(phone);
				order.setNote(note);
				List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
				for (Basket basket : baskets) {
					orderDetails.add(new OrderDetail("HD"+timeStamp,basket.getWatchId(), basket.getQuantity(), basket.getPrice()));
				}
				boolean bt = orderDao.insertOrderDetail(order, orderDetails);
				model.addAttribute("msg","Order is Successfull");
			} else {
				model.addAttribute("msg","Basket is empty");
			}
			model.addAttribute("page","basket");
			model.addAttribute("fodder","cart");
			baskets=new ArrayList<Basket>();
			session.setAttribute("basket", null);
			model.addAttribute("baskets", baskets);
			return "home/index";
		}
}
