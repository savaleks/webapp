package com.savaleks.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dao.ProductDAO;
import com.savaleks.websiteback.dto.Category;
import com.savaleks.websiteback.dto.Product;

@Controller
public class PageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		
		LOGGER.info("Inside PageController INFO " );
		LOGGER.debug("Inside PageController DEBUG ");
		
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
	
	// Clicking on product view button
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView model = new ModelAndView("page");
		Product product = productDAO.get(id);
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		model.addObject("title", product.getName());
		model.addObject("product", product);
		model.addObject("userClickShowProduct", true);
		
		return model;
	}
}
