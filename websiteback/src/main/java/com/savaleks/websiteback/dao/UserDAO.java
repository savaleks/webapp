package com.savaleks.websiteback.dao;

import java.util.List;

import com.savaleks.websiteback.dto.Address;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);

	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	boolean updateCard(Card card);
}
