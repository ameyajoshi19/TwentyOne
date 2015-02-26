package com.game.twentyone.model.game.rules;

/**
 * <p>
 * This enum declares the values for BlackJack payouts.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public enum BlackJackPayout {

	TwoToOne(2.0),
	ThreeToTwo(1.5);
	
	private double blackjackPayout;
	
	BlackJackPayout(double blackjackPayout) {
		this.blackjackPayout = blackjackPayout;
	}
	
	public double getBlackjackPayout() {
		return this.blackjackPayout;
	}
}
