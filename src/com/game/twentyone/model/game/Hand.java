package com.game.twentyone.model.game;

import java.util.List;

import com.game.twentyone.model.deck.values.Card;

/**
 * This class represents a list of cards and attributes associated with them.
 * 
 * @author AmeyaCJoshi
 *
 */
public class Hand {

	private List<Card> handCards;
	private boolean hasAce;

	public void addCard(Card card) {
		handCards.add(card);
	}
	
	public int getHandTotal() {
		int total = 0;
		for(Card c : handCards) {
			total = c.getCardValue().getValue();
		}
		return total;
	}
	
	public List<Card> getHandCards() {
    	return handCards;
    }
	
	public void setHandCards(List<Card> handCards) {
    	this.handCards = handCards;
    }
	
	public boolean isHasAce() {
    	return hasAce;
    }
	
	public void setHasAce(boolean hasAce) {
    	this.hasAce = hasAce;
    }
}
