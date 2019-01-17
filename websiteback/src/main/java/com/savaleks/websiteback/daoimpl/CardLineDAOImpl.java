package com.savaleks.websiteback.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.savaleks.websiteback.dao.CardLineDAO;
import com.savaleks.websiteback.dto.Card;
import com.savaleks.websiteback.dto.CardLine;

@Repository("cardLineDAO")
@Transactional
public class CardLineDAOImpl implements CardLineDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CardLine get(int id) {
		
		return sessionFactory.getCurrentSession().get(CardLine.class, id);
	}

	@Override
	public boolean add(CardLine cardLine) {
		try {
			sessionFactory.getCurrentSession().persist(cardLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CardLine cardLine) {
		try {
			sessionFactory.getCurrentSession().update(cardLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CardLine cardLine) {
		try {
			sessionFactory.getCurrentSession().delete(cardLine);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CardLine> list(int cardId) {
		String query = "FROM CardLine WHERE cardId = :cardId";
		return sessionFactory.getCurrentSession().createQuery(query, CardLine.class)
				.setParameter("cardId", cardId).getResultList();
	}

	@Override
	public List<CardLine> listAvailable(int cardId) {
		String query = "FROM CardLine WHERE cardId = :cardId AND available = :available";
		return sessionFactory.getCurrentSession().createQuery(query, CardLine.class)
				.setParameter("cardId", cardId).setParameter("available", true).getResultList();
	}

	@Override
	public CardLine getByCardAndProduct(int cardId, int productId) {
		String query = "FROM CardLine WHERE cardId = :cardId AND product.id = :productId";
		try {
		return sessionFactory.getCurrentSession().createQuery(query, CardLine.class)
				.setParameter("cardId", cardId).setParameter("productId", productId).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateCard(Card card) {
		try {
			sessionFactory.getCurrentSession().update(card);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
