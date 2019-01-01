package com.savaleks.websiteback.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> allCategories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Laptops");
		category.setDescription("Good laptop for good price");
		category.setImageURL("img1.png");		
		allCategories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Smartphones");
		category.setDescription("Good mobile phones for good price");
		category.setImageURL("img2.png");		
		allCategories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Headphones");
		category.setDescription("Good headphones for good price");
		category.setImageURL("img3.png");		
		allCategories.add(category);
		}

	@Override
	public List<Category> list() {
		
		return allCategories;
	}

	@Override
	public Category get(int id) {
		// enhanced for loop 
		for(Category category:allCategories) {
			if(category.getId() == id)
				return category;
		}
		
		return null;
	}

}
