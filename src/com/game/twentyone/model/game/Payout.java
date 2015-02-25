package com.game.twentyone.model.game;

/**
 * <p>
 * This enum declares the values for BlackJack payouts.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public enum Payout {

	TwoToOne(2.0),
	ThreeToTwo(1.5);
	
	private double payout;
	
	Payout(double payout) {
		this.payout = payout;
	}
	
	public double getPayout() {
		return this.payout;
	}
}
