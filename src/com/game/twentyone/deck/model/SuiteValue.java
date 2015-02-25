package com.game.twentyone.deck.model;

/**
 * <p>
 * This enum declares the values a 'suite' can have.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public enum SuiteValue {

	CLUBS("clubs"),
	HEARTS("hearts"),
	SPADE("spade"),
	DIAMOND("diamond");
	
	private String value;
	
	SuiteValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
