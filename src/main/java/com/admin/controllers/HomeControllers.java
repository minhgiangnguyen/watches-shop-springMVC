package com.admin.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllers {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional // Add @Transactional annotation
	@RequestMapping("admin/")
	public String index(Model model) {

		try (Session session = sessionFactory.openSession()) { // Use try-with-resources to automatically close session

			// Tổng số đơn hàng
			Query<Long> totalOrdersQuery = session.createQuery("SELECT COUNT(o) FROM OrderWatch o", Long.class);
			Long totalOrders = totalOrdersQuery.uniqueResult();

			// Số lượng tài khoản khách hàng
			Query<Long> customerAccountsQuery = session
					.createQuery("SELECT COUNT(a) FROM Account a WHERE a.role = false", Long.class);
			Long customerAccounts = customerAccountsQuery.uniqueResult();

			// Số lượng đơn được đặt
			Query<Long> ordersPlacedQuery = session.createQuery("SELECT COUNT(o) FROM OrderDetail o", Long.class);
			Long ordersPlaced = ordersPlacedQuery.uniqueResult();

			// Tổng số sản phẩm
			Query<Long> totalProductsQuery = session.createQuery("SELECT COUNT(p) FROM Watch p", Long.class);
			Long totalProducts = totalProductsQuery.uniqueResult();

			// Lấy dữ liệu doanh thu hàng tháng
			List<Object[]> monthlyRevenueData = session.createQuery(
					"SELECT MONTH(ow.orderDate), SUM(od.price * od.quantity) " + "FROM OrderWatch ow "
							+ "JOIN OrderDetail od ON ow.orderId = od.orderId " + "GROUP BY MONTH(ow.orderDate)",
					Object[].class).getResultList();

			// Tính số lượng sản phẩm đã bán và còn lại
			Long orderWatchCount = (Long) session.createQuery("SELECT COUNT(o) FROM OrderWatch o").uniqueResult();
			Long remainingProductsCount = totalProducts - orderWatchCount;

			model.addAttribute("totalOrders", totalOrders);
			model.addAttribute("customerAccounts", customerAccounts);
			model.addAttribute("ordersPlaced", ordersPlaced);
			model.addAttribute("totalProducts", totalProducts);
			model.addAttribute("monthlyRevenueData", monthlyRevenueData);
			model.addAttribute("orderWatchCount", orderWatchCount);
			model.addAttribute("remainingProductsCount", remainingProductsCount);

			model.addAttribute("page", "home");

			return "admin/index";
		}
	}
}
