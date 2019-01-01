package com.savaleks.websiteback.dao;

import java.util.List;

import com.savaleks.websiteback.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
