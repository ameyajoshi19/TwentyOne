package com.game.twentyone.model.game;

/**
 * <p>
 * This class declares the model for a game.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class Game {

	private boolean dealerHitsOn17;
	private boolean doubleDownAllowed;
	private boolean tripleDownAllowed;
	private boolean surrenderAllowed;
	private Payout blackJackPayout;
	private DeckCount deckCount;
	private DeckPenetration deckPenetration;
	
	public boolean isDealerHitsOn17() {
		return dealerHitsOn17;
	}
	
	public void setDealerHitsOn17(boolean dealerHitsOn17) {
		this.dealerHitsOn17 = dealerHitsOn17;
	}
	
	public boolean isDoubleDownAllowed() {
		return doubleDownAllowed;
	}
	
	public void setDoubleDownAllowed(boolean doubleDownAllowed) {
		this.doubleDownAllowed = doubleDownAllowed;
	}
	
	public boolean isTripleDownAllowed() {
		return tripleDownAllowed;
	}
	
	public void setTripleDownAllowed(boolean tripleDownAllowed) {
		this.tripleDownAllowed = tripleDownAllowed;
	}
	
	public boolean isSurrenderAllowed() {
		return surrenderAllowed;
	}
	
	public void setSurrenderAllowed(boolean surrenderAllowed) {
		this.surrenderAllowed = surrenderAllowed;
	}
	
	public Payout getBlackJackPayout() {
		return blackJackPayout;
	}
	
	public void setBlackJackPayout(Payout blackJackPayout) {
		this.blackJackPayout = blackJackPayout;
	}
	
	public DeckCount getDeckCount() {
		return deckCount;
	}
	
	public void setDeckCount(DeckCount deckCount) {
		this.deckCount = deckCount;
	}
	
	public DeckPenetration getDeckPenetration() {
		return deckPenetration;
	}
	
	public void setDeckPenetration(DeckPenetration deckPenetration) {
		this.deckPenetration = deckPenetration;
	}
}
