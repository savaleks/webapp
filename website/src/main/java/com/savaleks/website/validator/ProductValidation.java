package com.savaleks.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.savaleks.websiteback.dto.Product;

public class ProductValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select file to upload");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg") ||
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif")
				)){
			errors.rejectValue("file", null, "Please use only image file for upload");
			return;
		}
		// can write more if statement if need more checks
	}

}
