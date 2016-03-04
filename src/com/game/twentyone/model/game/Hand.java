package com.game.twentyone.model.game;

import java.util.ArrayList;
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
	private boolean isDealerHand;
	private int cardsOpen;
	private int total;

	public Hand(boolean isDealerHand) {
		this.handCards = new ArrayList<Card>();
		this.hasAce = false;
		this.total = 0;
		this.isDealerHand = isDealerHand;
		if(this.isDealerHand) {
			this.cardsOpen = 1;
		} else {
			this.cardsOpen = handCards.size();
		}
	}
	
	public void displayOpenCards() {
		Card c;
		for(int i = 0; i < cardsOpen; i++) {
			c = handCards.get(0);
			System.out.println(c.getCardSuite().getValue() + "-" + c.getCardValue().getValue());
		}
	}
	
	public int getCardsOpen() {
		return this.cardsOpen;
	}
	
	public void addCard(Card card) {
		handCards.add(card);
		total += card.getCardValue().getValue();
	}
	
	public boolean isBlackJack() {
		return total == 21;
	}
	
	public boolean isBusted() {
		return total > 21;
	}
	
	public int getHandTotal() {
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
