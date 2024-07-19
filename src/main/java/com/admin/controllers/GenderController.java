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

import com.watches.entities.Gender;
import com.watches.services.dao.GenderDao;

@Controller
public class GenderController {
	@Autowired
	GenderDao genderDAO;

	@RequestMapping(value = { "admin/gender/form" })
	public String add(Model model) {
		model.addAttribute("name", "Add");
		model.addAttribute("gender", new Gender());
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "gender");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/gender/edit/{genderId}" })
	public String edit(@PathVariable("genderId") int genderId, Model model) {
		model.addAttribute("name", "Edit");
		model.addAttribute("gender", genderDAO.get(genderId));
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "gender");
		return "admin/index";
	}

	@RequestMapping(value = { "admin/gender", "admin/gender/list" })
	public String show(Model model) {
		model.addAttribute("genderList", genderDAO.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "gender");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/gender/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("gender") Gender gender, @RequestParam("file") MultipartFile file, Model model,
			HttpServletRequest req, String pictureOld) {

		String[] imageType = new String[] { "image/jpeg", "image/png", "image/jpg" };
		if (file.isEmpty() && pictureOld.equals("")) {
			model.addAttribute("err", "Picture has not been uploaded");
			model.addAttribute("gender", gender);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "gender");
			return "admin/index";
		} else if (!file.isEmpty()) {
			if (!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err", "Picture is incorrect image type");
				model.addAttribute("gender", gender);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "gender");
				return "admin/index";
			}
			if (file.getSize() >= 1024 * 1024 * 10) {
				model.addAttribute("err", "Picture can not than 10mb");
				model.addAttribute("gender", gender);
				model.addAttribute("page", "form");
				model.addAttribute("fodder", "gender");
				return "admin/index";
			}

		}

		if (file != null && !file.isEmpty()) {
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_admin/dist/img/gender");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gender.setGenderPicture(file.getOriginalFilename());
		} else {
			gender.setGenderPicture(pictureOld);
		}

		String msgSuccess = gender.getGenderId() == 0 ? "Insert successfully!" : "Update successfully!";
		String msgFail = gender.getGenderId() == 0 ? "Insert failed!" : "Update failed!";
		boolean bl = gender.getGenderId() == 0 ? genderDAO.insert(gender) : genderDAO.update(gender);
		if (bl) {
			model.addAttribute("msg", msgSuccess);
			model.addAttribute("colorCss", "green");
			model.addAttribute("genderList", genderDAO.getAll());
			model.addAttribute("page", "list");
			model.addAttribute("fodder", "gender");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("gender", gender);
			model.addAttribute("page", "form");
			model.addAttribute("fodder", "gender");
			return "admin/index";
		}
	}

	@RequestMapping(value = "admin/gender/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		boolean bl = genderDAO.delete(id);
		model.addAttribute("msg", bl ? "Delete successfully!" : "Cannot delete gender. It contains products!");
		model.addAttribute("colorCss", bl ? "green" : "red");
		model.addAttribute("gender", new Gender());
		model.addAttribute("genderList", genderDAO.getAll());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "gender");
		return "admin/index";
	}
}
