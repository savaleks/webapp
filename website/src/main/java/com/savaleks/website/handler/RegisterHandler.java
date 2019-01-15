package com.savaleks.website.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.savaleks.website.model.RegisterModel;
import com.savaleks.websiteback.dao.UserDAO;
import com.savaleks.websiteback.dto.Address;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}
	
	public void addBilling (RegisterModel registerModel, Address billing) {
		
		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		// fetch the user
		User user = model.getUser();
		if(user.getRole().equals("USER")) {
			Card card = new Card();
			card.setUser(user);
			user.setCard(card);
		}
		
		// save the user
		userDAO.addUser(user);
		
		// get the address
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		// save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password not match").build());
			transitionValue = "failure";
		}
		if(userDAO.getByEmail(user.getEmail()) != null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email is already used").build());
			transitionValue = "failure";
		}
		return transitionValue;
	}
}

