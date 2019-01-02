package com.savaleks.websiteback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.savaleks.websiteback.dao.CategoryDAO;
import com.savaleks.websiteback.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.savaleks.websiteback");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Phones");
	 * category.setDescription("Good phones for good price");
	 * category.setImageURL("img2.png");
	 * 
	 * assertEquals("Added inside the table", true, categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(3);
	 * 
	 * assertEquals("Single category fetched from the table", "Laptops",
	 * category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3); category.setName("Notebook");
	 * 
	 * assertEquals("Single category updated from the table", true,
	 * categoryDAO.update(category)); }
	 */
	
	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(4);
	 * 
	 * assertEquals("Single category deleted from the table", true,
	 * categoryDAO.delete(category)); }
	 */
	
//	@Test
//	public void testListCategory() {
//					
//		assertEquals("Successfully fetched the list of categories from the table!",2,categoryDAO.list().size());
//		
//		
//	}

}
