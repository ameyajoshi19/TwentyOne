package com.game.twentyone.model.deck;

import java.util.List;

/**
 * <p>
 * This class implements the model of a deck.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class Deck {

	private int deckNumber;
	private List<Card> deckCards;

	public int getDeckNumber() {
		return deckNumber;
	}

	public void setDeckNumber(int deckNumber) {
		this.deckNumber = deckNumber;
	}

	public List<Card> getDeckCards() {
		return deckCards;
	}

	public void setDeckCards(List<Card> deckCards) {
		this.deckCards = deckCards;
	}
}
