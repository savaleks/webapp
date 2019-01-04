package com.savaleks.website.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dao.ProductDAO;
import com.savaleks.websiteback.dto.Category;
import com.savaleks.websiteback.dto.Product;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductManagementController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("userClickManageProducts", true);
		model.addObject("title", "Manage Products");
		
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		
		model.addObject("product", newProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				model.addObject("message", "Product submitted");
			}
		}
		
		return  model;
	}
	
	// product submission 
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String productSubmission(@ModelAttribute("product") Product modProduct) {
		
		LOGGER.info(modProduct.toString());
		
		// new product record
		productDAO.add(modProduct);
		
		return "redirect:/manage/products?operation=product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){	
		return categoryDAO.list();
	}
}
