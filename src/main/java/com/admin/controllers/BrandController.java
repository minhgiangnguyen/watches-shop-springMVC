package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.watches.entities.Brand;
import com.watches.services.dao.BrandDao;

@Controller
public class BrandController {
	@Autowired
	BrandDao brandDAO;

	@RequestMapping(value = { "admin/brand/form" })
	public String add(Model model) {
		model.addAttribute("name", "Add");
		model.addAttribute("brand", new Brand());
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "brand");
		return "admin/index";

	}

	@RequestMapping(value = { "admin/brand/edit/{brandId}" })
	public String edit(@PathVariable("brandId") int brandId, Model model) {
		model.addAttribute("name", "Edit");
		model.addAttribute("brand", brandDAO.get(brandId));
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "brand");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/brand", "admin/brand/list" })
	public String show(Model model) {
		model.addAttribute("brandList", brandDAO.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "brand");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/brand/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("brand") Brand brand, @RequestParam("file") MultipartFile file, Model model,
			HttpServletRequest req, String pictureOld) {

		String[] imageType = new String[] { "image/jpeg", "image/png", "image/jpg" };
		if (file.isEmpty() && pictureOld.equals("")) {
			model.addAttribute("err", "Picture has not been uploaded");
			model.addAttribute("brand", brand);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "brand");
			return "admin/index";
		} else if (!file.isEmpty()) {
			if (!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err", "Picture is incorrect image type");
				model.addAttribute("brand", brand);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "brand");
				return "admin/index";
			}
			if (file.getSize() >= 1024 * 1024 * 10) {
				model.addAttribute("err", "Picture can not than 10mb");
				model.addAttribute("brand", brand);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "brand");
				return "admin/index";
			}

		}

		if (file != null && !file.isEmpty()) {
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_home/img/brand");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			brand.setBrandLogo(file.getOriginalFilename());
		} else {
			brand.setBrandLogo(pictureOld);
		}

		String msgSuccess = brand.getBrandId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = brand.getBrandId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = brand.getBrandId() == 0 ? brandDAO.insert(brand) : brandDAO.update(brand);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("brandList", brandDAO.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "brand");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("brand", brand);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "brand");
			return "admin/index";
		}
	}

	@RequestMapping(value = "admin/brand/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = brandDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete brand. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("brand", new Brand());
		model.addAttribute("brandList", brandDAO.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "brand");
		return "admin/index";
	}
}
