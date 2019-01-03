package com.savaleks.website.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoFoundException() {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle", "Page is not created");
		model.addObject("errorDescription", "The page you looking for is not available now");
		model.addObject("title", "404 error");
		
		return model;
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public ModelAndView productNotFoundException() {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle", "Product not available");
		model.addObject("errorDescription", "The product is not available at the moment.");
		model.addObject("title", "Product not found");
		
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle", "Contact Your Admin");		
		model.addObject("errorDescription", e.toString());
		model.addObject("title", "Error");
		
		return model;
	}
}
