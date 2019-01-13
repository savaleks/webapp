package com.savaleks.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.website.util.FIleUploadUtil;
import com.savaleks.website.validator.ProductValidation;
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
			} else if(operation.equals("category")) {
				model.addObject("message", "Category submitted");
			}
		}
		
		return  model;
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditedProducts(@PathVariable int id) {
		ModelAndView model = new ModelAndView("page");
		model.addObject("userClickManageProducts", true);
		model.addObject("title", "Manage Products");
		
		Product newProduct = productDAO.get(id);
		model.addObject("product", newProduct);
		return model;
		
	}
	
	// product submission 
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String productSubmission(@Valid @ModelAttribute("product") Product modProduct, BindingResult results, Model mod,
			HttpServletRequest request) {
		
		if(modProduct.getId() == 0) {
			new ProductValidation().validate(modProduct, results);
		} else {
			if(!modProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidation().validate(modProduct, results);
			}
		}
		
		if(results.hasErrors()) {
			mod.addAttribute("userClickManageProducts", true);
			mod.addAttribute("title", "Manage Products");
			mod.addAttribute("message", "Validation not accepted");
			return "page";
		}
		
		LOGGER.info(modProduct.toString());
		
		
		if(modProduct.getId() == 0) {
			// new product record with id 0
			productDAO.add(modProduct);
		} else {
			// update product if id is not 0
			productDAO.update(modProduct);
		}
		
		if(!modProduct.getFile().getOriginalFilename().equals("")) {
			FIleUploadUtil.uploadFile(request, modProduct.getFile(), modProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String productActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productDAO.update(product);
		
		return (isActive)?"You deactivated the Product with id " + product.getId()
							:"You activated the Product with id " + product.getId();
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String categorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){	
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
