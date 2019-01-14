package com.savaleks.websiteback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.savaleks.websiteback.dao.UserDAO;
import com.savaleks.websiteback.dto.Address;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Card card = null;
	private Address address = null;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.savaleks.websiteback");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}
/*
	@Test
	public void testAddUser() {

		// passed
		user = new User();
		user.setFirstName("Alex");
		user.setLastName("Sky");
		user.setEmail("alex@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");

		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLine("Vilniaus g.");
		address.setAddressNumber("5-87");
		address.setCity("Vilnius");
		address.setState("Vilniaus apsk.");
		address.setCountry("Lietuva");
		address.setPostalCode("123456");
		address.setBilling(true);

		// linked the address with the user
		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {
			// linked the cart with the user
			card = new Card();
			card.setUser(user);
			assertEquals("Failed to add the card!", true, userDAO.addCard(card));

			// add the shipping address
			address = new Address();
			address.setAddressLine("Kauno g.");
			address.setAddressNumber("56");
			address.setCity("Kaunas");
			address.setState("Kauno apsk.");
			address.setCountry("Lietuva");
			address.setPostalCode("405401");
			address.setShipping(true);

			address.setUserId(user.getId());

			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}
	}
	*/
	/*
	@Test
	public void testAddUser() {

		user = new User();
		user.setFirstName("Alex");
		user.setLastName("Sky");
		user.setEmail("alex@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("1245");

		if (user.getRole().equals("USER")) {
			// linked the cart with the user
			card = new Card();
			card.setUser(user);
			
			user.setCard(card);
		}
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
	}
	*/
	/*
	@Test
	public void testUpdateCard() {
		
		user = userDAO.getByEmail("alex@gmail.com");

		card = user.getCard();
		
		card.setGrandTotal(5555);
		
		card.setCardLines(2);
		
		// add the user
		assertEquals("Failed to update the card!", true, userDAO.updateCard(card));
	}
	*/
	/*
	@Test
	public void testAddAddress() {
		
		user = new User();
		user.setFirstName("Alex");
		user.setLastName("Sky");
		user.setEmail("alex@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");

		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLine("Vilniaus g.");
		address.setAddressNumber("5-87");
		address.setCity("Vilnius");
		address.setState("Vilniaus apsk.");
		address.setCountry("Lietuva");
		address.setPostalCode("123456");
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add billing address", true, userDAO.addAddress(address));
		
		address = new Address();
		address.setAddressLine("Kauno g.");
		address.setAddressNumber("56");
		address.setCity("Kaunas");
		address.setState("Kauno apsk.");
		address.setCountry("Lietuva");
		address.setPostalCode("405401");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));	
	}	
	*/	
	/*	
	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("alex@gmail.com");
		
		address = new Address();
		address.setAddressLine("Kauno g.");
		address.setAddressNumber("56");
		address.setCity("Jonava");
		address.setState("Kauno apsk.");
		address.setCountry("Lietuva");
		address.setPostalCode("411101");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));	
	}
	*/
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("alex@gmail.com");
		
		assertEquals("Failed to fetch list", 4, userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch list", "Vilnius", userDAO.getBillingAddress(user).getCity());
	}
		
		
		
		
		
		
	}