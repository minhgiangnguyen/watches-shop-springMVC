package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.watches.entities.Watch;
import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecsWithSale;
import com.watches.services.dao.BrandDao;
import com.watches.services.dao.ColorDao;
import com.watches.services.dao.GenderDao;
import com.watches.services.dao.MaterialDao;
import com.watches.services.dao.MovementDao;
import com.watches.services.dao.SizeDao;
import com.watches.services.dao.StrapTypeDao;
import com.watches.services.dao.WatchDao;
import com.watches.services.dao.WatchSpecsWithSaleDAO;
@Controller
public class WatchController {
	@Autowired
	WatchDao watchDAO;
	@Autowired
	BrandDao brandDAO;
	@Autowired
	ColorDao colorDAO;
	@Autowired
	GenderDao genderDAO;
	@Autowired
	MaterialDao materialDAO;
	@Autowired
	MovementDao movementDAO;
	@Autowired
	SizeDao sizeDAO;
	@Autowired
	StrapTypeDao strapTypeDAO;
	@Autowired
	WatchSpecsWithSaleDAO watchSpecsWithSaleDao;
	
	private int pageSize=3;
	@RequestMapping(value = { "admin/watch" })
	public String show(Model model ,Integer pageNo) {
		pageNo = pageNo == null ? 1 : pageNo;
		WatchPage watchPage = watchSpecsWithSaleDao.getAllWithPaging(pageSize,pageNo);
		List<WatchSpecsWithSale> wList=watchPage.getWatches();
		
		model.addAttribute("wList",wList);
		model.addAttribute("totalPage",watchPage.getTotalPages());
		model.addAttribute("currentPage",watchPage.getCurrentPage());
		model.addAttribute("page", "list");
		model.addAttribute("fodder", "watch");
		return "admin/index";
	}

	// admin/watch/add
	@RequestMapping(value = { "admin/watch/add" }, method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("watch", new Watch());
		model.addAttribute("gender", genderDAO.getAll());
		model.addAttribute("brand", brandDAO.getAll());
		model.addAttribute("color", colorDAO.getAll());
		model.addAttribute("straptype", strapTypeDAO.getAll());
		model.addAttribute("size", sizeDAO.getAll());
		model.addAttribute("movement", movementDAO.getAll());
		model.addAttribute("material", materialDAO.getAll());
		model.addAttribute("page", "form");
		model.addAttribute("fodder", "watch");
		return "admin/index";
	}
	@RequestMapping(value = { "admin/watch/edit/{id}" })
	public String edit(@PathVariable("id") int id,Model model) {	
		model.addAttribute("nameForm", "Edit");
		model.addAttribute("watch", watchDAO.get(id));
		model.addAttribute("gender", genderDAO.getAll());
		model.addAttribute("brand", brandDAO.getAll());
		model.addAttribute("color", colorDAO.getAll());
		model.addAttribute("straptype", strapTypeDAO.getAll());
		model.addAttribute("size", sizeDAO.getAll());
		model.addAttribute("movement", movementDAO.getAll());
		model.addAttribute("material", materialDAO.getAll());
		model.addAttribute("page","form");
		model.addAttribute("fodder","watch");
		return "admin/index";
	}
	
	
	@RequestMapping(value = "admin/watch/delete/{id}")
	public String delete(@PathVariable("id") int id,Model model) {
		boolean bl = watchDAO.delete(id);
		model.addAttribute("msg",bl?"Delete successfully!":"Delete failed!");
		model.addAttribute("colorCss", bl?"green":"red");
		
		WatchPage watchPage = watchSpecsWithSaleDao.getAllWithPaging(pageSize,1);
		List<WatchSpecsWithSale> wList=watchPage.getWatches();	
		model.addAttribute("wList",wList);
		model.addAttribute("totalPage",watchPage.getTotalPages());
		model.addAttribute("currentPage",watchPage.getCurrentPage());
		
		model.addAttribute("page","list");
		model.addAttribute("fodder","watch");	
		return "admin/index";
	}
	@RequestMapping(value = { "admin/watch/picture-list/{id}" })
	public String editPictureList(@PathVariable("id") int id,Model model) {	
		System.out.println(watchDAO.get(id).getPictureList());
		model.addAttribute("pictureListOld", watchDAO.get(id).getPictureList());
		model.addAttribute("page","edit_picture_list");
		model.addAttribute("fodder","watch");
		return "admin/index";
	}
	@RequestMapping(value = { "admin/watch/picture-list/{id}/save" }, method = RequestMethod.POST)
	public String savePictureList(@PathVariable("id") int id
			, @RequestParam("file") MultipartFile file, Model model
			,HttpServletRequest req,String pictureListOld) {
		Watch watch = watchDAO.get(id);
		String[] imageType=new String[]{"image/jpeg","image/png","image/jpg"};
		if(file.isEmpty() && pictureListOld.equals("") ) {			
				model.addAttribute("err","Picture has not been uploaded");
				model.addAttribute("pictureListOld",pictureListOld);
				model.addAttribute("page","edit_picture_list");
				model.addAttribute("fodder","watch");
				return "admin/index";			
		}
		else if(!file.isEmpty()) {
			if(!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err","Picture is incorrect image type");
				model.addAttribute("pictureListOld",pictureListOld);
				model.addAttribute("page","edit_picture_list");
				model.addAttribute("fodder","watch");
				return "admin/index";	
			}
			 if(file.getSize()>=1024*1024*10) {
				model.addAttribute("err","Picture can not than 10mb");
				model.addAttribute("pictureListOld",pictureListOld);
				model.addAttribute("page","edit_picture_list");
				model.addAttribute("fodder","watch");
				return "admin/index";
			}
			 
		}
		
		if (file != null && !file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_home/img/product");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String picList = pictureListOld.equals("")?file.getOriginalFilename():pictureListOld+";"+file.getOriginalFilename();
			watch.setPictureList(picList);
		} else {
			watch.setPictureList(pictureListOld);
		}
		
		
		String msgSuccess="Update successfully!";
		String msgFail="Update failed!";
		boolean bl =watchDAO.update(watch);
		if (bl) {
			model.addAttribute("msg",msgSuccess);
			model.addAttribute("colorCss", "green");
			WatchPage watchPage = watchSpecsWithSaleDao.getAllWithPaging(pageSize,1);
			model.addAttribute("wList",watchPage.getWatches());
			model.addAttribute("totalPage",watchPage.getTotalPages());
			model.addAttribute("currentPage",watchPage.getCurrentPage());
			model.addAttribute("page","list");
			model.addAttribute("fodder","watch");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			
			model.addAttribute("pictureListOld",pictureListOld);
			model.addAttribute("page","edit_picture_list");
			model.addAttribute("fodder","watch");
			return "admin/index";
		}
	}
	@RequestMapping(value = { "/admin/watch/save" }, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("watch") Watch watch, BindingResult result
			, @RequestParam("file") MultipartFile file, Model model
			,HttpServletRequest req, String thumbOld,String pictureListOld) {
		
		String[] imageType=new String[]{"image/jpeg","image/png","image/jpg"};
		if(file.isEmpty() && thumbOld.equals("") ) {			
				model.addAttribute("err","Logo has not been uploaded");
				model.addAttribute("watch",watch);
				model.addAttribute("gender", genderDAO.getAll());
				model.addAttribute("brand", brandDAO.getAll());
				model.addAttribute("color", colorDAO.getAll());
				model.addAttribute("straptype", strapTypeDAO.getAll());
				model.addAttribute("size", sizeDAO.getAll());
				model.addAttribute("movement", movementDAO.getAll());
				model.addAttribute("material", materialDAO.getAll());
				model.addAttribute("page","form");
				model.addAttribute("fodder","watch");
				return "admin/index";			
		}
		else if(!file.isEmpty()) {
			if(!Arrays.asList(imageType).contains(file.getContentType())) {
				model.addAttribute("err","Logo is incorrect image type");
				model.addAttribute("watch",watch);
				model.addAttribute("gender", genderDAO.getAll());
				model.addAttribute("brand", brandDAO.getAll());
				model.addAttribute("color", colorDAO.getAll());
				model.addAttribute("straptype", strapTypeDAO.getAll());
				model.addAttribute("size", sizeDAO.getAll());
				model.addAttribute("movement", movementDAO.getAll());
				model.addAttribute("material", materialDAO.getAll());
				model.addAttribute("page","form");
				model.addAttribute("fodder","watch");
				return "admin/index";	
			}
			 if(file.getSize()>=1024*1024*10) {
				model.addAttribute("err","Logo can not than 10mb");
				model.addAttribute("watch",watch);
				model.addAttribute("gender", genderDAO.getAll());
				model.addAttribute("brand", brandDAO.getAll());
				model.addAttribute("color", colorDAO.getAll());
				model.addAttribute("straptype", strapTypeDAO.getAll());
				model.addAttribute("size", sizeDAO.getAll());
				model.addAttribute("movement", movementDAO.getAll());
				model.addAttribute("material", materialDAO.getAll());
				model.addAttribute("page","form");
				model.addAttribute("fodder","watch");
				return "admin/index";
			}
			 
		}
		
		if (file != null && !file.isEmpty()) {
			String uploadRootPath = req.getServletContext().getRealPath("resources/assets_home/img/product");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			System.out.println(destination);
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			watch.setThumbnail(file.getOriginalFilename());
		} else {
			watch.setThumbnail(thumbOld);
		}
		watch.setPictureList(watch.getWatchId() == 0?"":pictureListOld);
		String slug=watch.getWatchName().toLowerCase().trim().replace(" ","-").replace("/","-")
					+"-"+watch.getWatchCode().toLowerCase().trim().replace(" ","-");
		watch.setWatchSlug(slug);	
		
		if(watch.getWatchId()==0)
			watch.setCreate(Date.valueOf(LocalDate.now()));
		else 
			watch.setCreate(watch.getCreate());
		
		watch.setUpdate(Date.valueOf(LocalDate.now()));
		
		String msgSuccess=watch.getWatchId() == 0?"Insert successfully!":"Update successfully!";
		String msgFail=watch.getWatchId() == 0?"Insert failed!":"Update failed!";
		boolean bl = watch.getWatchId() == 0 ? watchDAO.insert(watch) : watchDAO.update(watch);
		if (bl) {
			model.addAttribute("msg",msgSuccess);
			model.addAttribute("colorCss", "green");
			WatchPage watchPage = watchSpecsWithSaleDao.getAllWithPaging(pageSize,1);
			model.addAttribute("wList",watchPage.getWatches());
			model.addAttribute("totalPage",watchPage.getTotalPages());
			model.addAttribute("currentPage",watchPage.getCurrentPage());
			model.addAttribute("page","list");
			model.addAttribute("fodder","watch");
			return "admin/index";
		} else {
			model.addAttribute("msg", msgFail);
			model.addAttribute("colorCss", "red");
			model.addAttribute("gender", genderDAO.getAll());
			model.addAttribute("brand", brandDAO.getAll());
			model.addAttribute("color", colorDAO.getAll());
			model.addAttribute("straptype", strapTypeDAO.getAll());
			model.addAttribute("size", sizeDAO.getAll());
			model.addAttribute("movement", movementDAO.getAll());
			model.addAttribute("material", materialDAO.getAll());
			model.addAttribute("watch", watch);
			model.addAttribute("page","form");
			model.addAttribute("fodder","watch");
			return "admin/index";
		}
	}
//	@RequestMapping(value = { "/admin/watch/save" }, method = RequestMethod.POST)
//	public String save(@ModelAttribute("watch") Watch watch, 
//	                   @RequestParam("file") MultipartFile file,
//	                   @RequestParam("pictureList") MultipartFile[] multipartFiles, 
//	                   Model model, 
//	                   HttpServletRequest req,
//	                   RedirectAttributes redirectAttributes) {
//
//	    String uploadRootPath = req.getServletContext().getRealPath("resources/assets_admin/dist/img/watch");
//	    String slug = watch.getWatchName().toLowerCase().trim().replace(" ", "-").replace("/", "-") + "-" 
//	                  + watch.getWatchCode().toLowerCase().trim().replace(" ", "-");
//
//	    try {
//	        // Ensure upload directory exists
//	        File uploadDir = new File(uploadRootPath);
//	        if (!uploadDir.exists()) {
//	            uploadDir.mkdirs();
//	        }
//
//	        // Save thumbnail
//	        if (file != null && !file.isEmpty()) {
//	            // Validate file type and size
//	            if (!file.getContentType().startsWith("image/") || file.getSize() > 5 * 1024 * 1024) {
//	                redirectAttributes.addFlashAttribute("msg", "Invalid file type or size!");
//	                return "redirect:/admin/addWatch";
//	            }
//	            File destination = new File(uploadRootPath, file.getOriginalFilename());
//	            file.transferTo(destination);
//	            watch.setThumbnail(file.getOriginalFilename());
//	        }
//
//	        // Save picture list
//	        if (multipartFiles != null && multipartFiles.length > 0) {
//	            List<String> pictureFileNames = new ArrayList<>();
//	            for (MultipartFile pictureFile : multipartFiles) {
//	                if (!pictureFile.isEmpty()) {
//	                    // Validate file type and size
//	                    if (!pictureFile.getContentType().startsWith("image/") || pictureFile.getSize() > 5 * 1024 * 1024) {
//	                        redirectAttributes.addFlashAttribute("msg", "Invalid file type or size in picture list!");
//	                        return "redirect:/admin/addWatch";
//	                    }
//	                    File pictureDestination = new File(uploadRootPath, pictureFile.getOriginalFilename());
//	                    pictureFile.transferTo(pictureDestination);
//	                    pictureFileNames.add(pictureFile.getOriginalFilename());
//	                }
//	            }
//
//	            String pictureListString = String.join(",", pictureFileNames);
//	            System.out.println(pictureListString);
//	            watch.setPictureList(pictureListString);
//	        }
//
//	        // Insert watch into database
//	        watch.setWatchSlug(slug);
//	        watch.setCreate(Date.valueOf(LocalDate.now()));
//	        watch.setUpdate(Date.valueOf(LocalDate.now()));
//	        watchDAO.insert(watch);
//
//	        redirectAttributes.addFlashAttribute("success", "Watch saved successfully!");
//	        return "redirect:/admin/watch/list"; // Assuming you have a list page for watches
//
//	    } catch (IOException e) {
//	        redirectAttributes.addFlashAttribute("msg", "File upload failed!");
//	        e.printStackTrace();
//	        return "redirect:/admin/addWatch";
//	    } catch (Exception e) {
//	        redirectAttributes.addFlashAttribute("msg", "Registration failed!");
//	        e.printStackTrace();
//	        return "redirect:/admin/addWatch";
//	    }
//	}
}
