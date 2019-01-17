package com.savaleks.websiteback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.savaleks.websiteback.dao.CardLineDAO;
import com.savaleks.websiteback.dao.ProductDAO;
import com.savaleks.websiteback.dao.UserDAO;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.CardLine;
import com.savaleks.websiteback.dto.Product;
import com.savaleks.websiteback.dto.User;

public class CardTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static CardLineDAO cardLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private CardLine cardLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.savaleks.websiteback");
		context.refresh();
		cardLineDAO = (CardLineDAO)context.getBean("cardLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("alex@mail.ru");		
		
		Card card = user.getCard();
		
		// fetch the product 
		Product product = productDAO.get(1);
		
		// Create a new CartLine
		cardLine = new CardLine();	
		cardLine.setBuyingPrice(product.getUnitPrice());
		cardLine.setProductCount(cardLine.getProductCount() + 1);
		cardLine.setTotal(product.getUnitPrice() * cardLine.getProductCount());
		cardLine.setAvailable(true);	
		cardLine.setCardId(card.getId());		
		cardLine.setProduct(product);
		
		assertEquals("Failed to add the CartLine!",true, cardLineDAO.add(cardLine));
		
		
		card.setGrandTotal(card.getGrandTotal() + cardLine.getTotal());
		card.setCardLines(card.getCardLines() + 1);
		
		assertEquals("Failed to update the cart!",true, cardLineDAO.updateCard(card));
		
	}
}
