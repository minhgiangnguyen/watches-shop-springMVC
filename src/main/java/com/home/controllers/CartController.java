package com.home.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.watches.entities.Basket;
import com.watches.entities.Watch;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.WatchDao;

@Controller
public class CartController {
   @Autowired
   WatchDao watchDao;
   @Autowired
   GenderDao categoryDao;
 //GET: countItems "trả về số lượng sách trong giỏ hàng"	
 		@RequestMapping(value = "countItems")
 		public @ResponseBody String getItems(Model model, HttpServletRequest req) {
 			List<Basket> baskets = new ArrayList<>();
 			HttpSession session = req.getSession();
 			if (session.getAttribute("basket") != null) {
 				baskets = (List<Basket>) session.getAttribute("basket");
 			}
 			System.out.println(baskets.size());
 			return String.valueOf(baskets.size());
 		}
 		//GET: addItem "thêm sách vào giỏ hàng và trả về tổng số sách trong giỏ"	
 		@RequestMapping(value = "addItem/{id}")
 		public @ResponseBody String addItem(@PathVariable("id") Integer watchId
 				, HttpServletRequest req) {
 			System.out.println(watchId);
 			List<Basket> baskets = new ArrayList<>();
 			HttpSession session = req.getSession();
 			Watch w = watchDao.get(watchId);
 			if (session.getAttribute("basket") == null) {
 				Basket basket = new Basket(w.getWatchId(),w.getWatchCode(),w.getWatchName(),
 						w.getWatchSlug(),w.getThumbnail(),w.getPrice(), 1);
 				baskets.add(basket);
 				session.setAttribute("basket", baskets);
 			} else {
 				baskets = (List<Basket>) session.getAttribute("basket");
 				boolean duplicate = false;
 				for (int i = 0; i < baskets.size(); i++) {
 					Basket bs = baskets.get(i);
 					if (bs.getWatchId()==watchId) {
 						bs.setQuantity(bs.getQuantity() + 1);
 						duplicate = true;
 						break;
 					}
 				}
 				if (duplicate)
 					session.setAttribute("basket", baskets);
 				else {
 					Basket basket = new Basket(w.getWatchId(),w.getWatchCode(),w.getWatchName(),
 							w.getWatchSlug(),w.getThumbnail(),w.getPrice(), 1);
 					baskets.add(basket);
 				}
 			}
 			session.setAttribute("basket", baskets);
 			
 			return String.valueOf(baskets.size());
 		}
 		
 		//GET: gio-hang "trả về sách trong giỏ hàng và hiển thị trên view home/basket"
 		
 		@RequestMapping(value = "cart")
 		public String showBasket(Model model, HttpServletRequest req) {
 			model.addAttribute("categories",categoryDao.getAll());
 			model.addAttribute("page", "basket");
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
 		
 		//GET: updateBasket/{id}/{value} "cập nhật lại số lượng đặt trong giỏ hang"
 		@RequestMapping(value = "updateBasket/{id}/{value}")
 		public @ResponseBody String updateBasket(@PathVariable("id") Integer watchId
 				, @PathVariable("value") Integer quantity,
 				Model model, HttpServletRequest req) {
 			List<Basket> baskets = new ArrayList<>();
 			HttpSession session = req.getSession();
 			if (session.getAttribute("basket") != null) {
 				baskets = (List<Basket>) session.getAttribute("basket");
 				for (int i = 0; i < baskets.size(); i++) {
 					Basket bs = baskets.get(i);
 					if (bs.getWatchId() == watchId) {
 						bs.setQuantity(quantity);
 						break;
 					}
 				}
 			}
 			return "";
 		}
 		
 		//GET: removeItem/{id} "xóa một sách trong giỏ hang"
 		@RequestMapping(value = "removeItem/{id}")
 		public @ResponseBody String removeItem(@PathVariable("id") Integer watchId, HttpServletRequest req) {
 			List<Basket> baskets = new ArrayList<>();
 			HttpSession session = req.getSession();
 			boolean find = false;
 			if (session.getAttribute("basket") != null) {
 				int i;
 				baskets = (List<Basket>) session.getAttribute("basket");
 				for (i = 0; i < baskets.size(); i++) {
 					Basket bs = baskets.get(i);
 					if (bs.getWatchId() == watchId) {
 						find = true;
 						break;
 					}
 				}
 				if (find) {
 					baskets.remove(i);
 				}
 				session.setAttribute("basket", baskets);
 			}

 			return "";
 		}
}
