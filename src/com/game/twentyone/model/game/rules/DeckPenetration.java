package com.game.twentyone.model.game.rules;

/**
 * <p>
 * This enum declares the values for deck penetrations.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public enum DeckPenetration {

	TWENTY(20),
	THIRTY(30),
	FOURTY(40),
	FIFTY(50),
	SIXTY(60),
	SEVENTY(70),
	EIGHTY(80);
	
	private int deckPenetration;
	
	private DeckPenetration(int deckPenetration) {
		this.deckPenetration = deckPenetration;
	}
	
	public int getDeckPenetration() {
		return this.deckPenetration;
	}
}
