package com.savaleks.websiteback.dao;

import java.util.List;

import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.CardLine;

public interface CardLineDAO {

	public CardLine get(int id);
	public boolean add(CardLine cardLine);
	public boolean update(CardLine cardLine);
	public boolean delete(CardLine cardLine);
	public List<CardLine> list(int cardId);
	
	public List<CardLine> listAvailable(int cardId);
	public CardLine getByCardAndProduct(int cardId, int productId);
	
	boolean updateCard(Card card);
}
