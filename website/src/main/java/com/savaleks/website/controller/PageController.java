package com.savaleks.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		
		// list of categories
		model.addObject("allCategories", categoryDAO.list());
		
		model.addObject("userClickHome", true);
		return model;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "About Us");
		model.addObject("userClickAbout", true);
		return model;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Contact Us");
		model.addObject("userClickContact", true);
		return model;
	}
	
	// Load all products based on category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView allProducts() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "All products");
		
		// list of categories
		model.addObject("allCategories", categoryDAO.list());
		
		model.addObject("userClickAllProducts", true);
		return model;
	}
	
	// load category based on product id
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView singleProduct(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("page");
		
		// fetch single item in category
		Category category = null;
		category = categoryDAO.get(id);
		
		model.addObject("title", category.getName());
		
		// list of categories
		model.addObject("allCategories", categoryDAO.list());
		
		// passing a single category object
		model.addObject("category", category);
		
		model.addObject("userClickCategoryProducts", true);
		return model;
	}
}
