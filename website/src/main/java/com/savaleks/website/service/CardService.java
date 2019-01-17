package com.savaleks.website.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savaleks.website.model.UserModel;
import com.savaleks.websiteback.dao.CardLineDAO;
import com.savaleks.websiteback.dao.ProductDAO;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.CardLine;
import com.savaleks.websiteback.dto.Product;

@Service("cardService")
public class CardService {
	
	@Autowired
	private CardLineDAO cardLineDAO;
	 
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ProductDAO productDAO;
	
	// returns card of the user who logged in
	private Card getCard() {
		return ((UserModel) httpSession.getAttribute("userModel")).getCard();
	}
	
	public List<CardLine> getCardLines(){
		
		return cardLineDAO.list(this.getCard().getId());
	}

	public String manageCardLine(int cardLineId, int count) {
		CardLine cardLine = cardLineDAO.get(cardLineId);
		if(cardLine == null) {
			return "result=error";
		} else {
			Product product = cardLine.getProduct();
			double oldTotal = cardLine.getTotal();
			
			if(product.getQuantity() <= count) {
				return "result=unavailable";
			}
			
			cardLine.setProductCount(count);
			cardLine.setBuyingPrice(product.getUnitPrice());
			cardLine.setTotal(product.getUnitPrice() * count);
			
			cardLineDAO.update(cardLine);
			
			Card card = this.getCard();
			card.setGrandTotal(card.getGrandTotal() - oldTotal + cardLine.getTotal());
			cardLineDAO.updateCard(card);
			
			return "result=updated";
		}
	}

	public String deleteCardLine(int cardLineId) {
		CardLine cardLine = cardLineDAO.get(cardLineId);
		if(cardLine == null) {
			return "result=error";
		} else {
			Card card = this.getCard();
			card.setGrandTotal(card.getGrandTotal() - cardLine.getTotal());
			card.setCardLines(card.getCardLines() - 1);
			cardLineDAO.updateCard(card);
			
			cardLineDAO.delete(cardLine);
			return "result=deleted";
		}
	}

	public String addCardLine(int productId) {
		String response = null;
		Card card = this.getCard();
		CardLine cardLine = cardLineDAO.getByCardAndProduct(card.getId(), productId);
		if(cardLine == null) {
			cardLine = new CardLine();
			Product product = productDAO.get(productId);
			cardLine.setCardId(card.getId());
			cardLine.setProduct(product);
			cardLine.setBuyingPrice(product.getUnitPrice());
			cardLine.setProductCount(1);
			cardLine.setTotal(product.getUnitPrice());
			cardLine.setAvailable(true);
			
			cardLineDAO.add(cardLine);
			
			card.setCardLines(card.getCardLines() + 1);
			card.setGrandTotal(card.getGrandTotal() + cardLine.getTotal());
			cardLineDAO.updateCard(card);
			
			response = "result=added";
		} else {
			if(cardLine.getProductCount() < 3) {
				response = this.manageCardLine(cardLine.getId(), cardLine.getProductCount() + 1);
			} else {
				response = "result=max";
			}
		}
		
		return response;
	}

}
