package com.game.twentyone.model.game;

import java.util.ArrayList;
import java.util.List;

import com.game.twentyone.model.deck.values.Card;
import com.game.twentyone.model.deck.values.CardValue;

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
	private int betAmount;
	private int cardsTotal;

	public Hand(boolean isDealerHand) {
		this.handCards = new ArrayList<Card>();
		this.hasAce = false;
		this.betAmount = 0;
		this.cardsTotal = 0;
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
	
	private int getTotalAccountingForAce() {
		int potentialTotal = cardsTotal;
		if(this.hasAce) {
			for(Card c : handCards) {
				if(c.equals(CardValue.ACE)) {
					if(potentialTotal + 10 <= 21) {
						potentialTotal += 10;
					}
				}
			}
		}
		return potentialTotal;
	}
	
	public int getHandTotal() {
		return getTotalAccountingForAce();
	}
	
	public void addCard(Card card) {
		handCards.add(card);
		cardsTotal += card.getCardValue().getValue();
	}
	
	public boolean isBlackJack() {
		return cardsTotal == 21;
	}
	
	public boolean isBusted() {
		return cardsTotal > 21;
	}
	
	public int getCardsOpen() {
		return this.cardsOpen;
	}
	
	public int getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(int amount) {
		this.betAmount = amount;
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
