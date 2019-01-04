package com.savaleks.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dto.Category;
import com.savaleks.websiteback.dto.Product;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showProducts() {
		ModelAndView model = new ModelAndView("page");
		model.addObject("userClickManageProducts", true);
		model.addObject("title", "Manage Products");
		
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		
		model.addObject("product", newProduct);
		
		return  model;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		
		return categoryDAO.list();
	}
}
