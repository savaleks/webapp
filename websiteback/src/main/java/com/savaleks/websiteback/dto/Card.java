package com.savaleks.websiteback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private User user;
	
	@Column(name="grand_total")
	private double grandTotal;
	@Column(name="cart_lines")
	private int cardLines;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCardLines() {
		return cardLines;
	}
	public void setCardLines(int cardLines) {
		this.cardLines = cardLines;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", user=" + user + ", grandTotal=" + grandTotal + ", cardLines=" + cardLines + "]";
	}
}
