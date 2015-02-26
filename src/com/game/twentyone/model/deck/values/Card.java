package com.game.twentyone.model.deck.values;

/**
 * <p>
 * This class implements the model for a card.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class Card {

	private SuiteValue cardSuite;
	private CardValue cardValue;
	
	public SuiteValue getCardSuite() {
		return cardSuite;
	}
	
	public void setCardSuite(SuiteValue cardSuite) {
		this.cardSuite = cardSuite;
	}
	
	public CardValue getCardValue() {
		return cardValue;
	}
	
	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}
}
