package com.game.twentyone.model.game.rules;

/**
 * <p>
 * This enum declares the values for deck count in a game.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public enum DeckCount {

	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6);
	
	private int deckCount;
	
	DeckCount(int deckCount) {
		this.deckCount = deckCount;
	}
	
	public int getDeckCountIntValue() {
		return this.deckCount;
	}
}
