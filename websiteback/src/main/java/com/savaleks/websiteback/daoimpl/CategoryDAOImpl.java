package com.savaleks.websiteback.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> category = new ArrayList<>();
	
	static {
		Category product = new Category();
		product.setId(1);
		product.setName("Laptops");
		product.setDescription("Good laptop for good price");
		product.setImageURL("img1.png");		
		category.add(product);
		
		product = new Category();
		product.setId(2);
		product.setName("Smartphones");
		product.setDescription("Good mobile phones for good price");
		product.setImageURL("img2.png");		
		category.add(product);
		
		product = new Category();
		product.setId(3);
		product.setName("Headphones");
		product.setDescription("Good headphones for good price");
		product.setImageURL("img3.png");		
		category.add(product);
		}

	@Override
	public List<Category> list() {
		
		return category;
	}

}
