package com.game.twentyone.controller;

import java.io.IOException;

import com.game.twentyone.controller.util.UserInputUtility;
import com.game.twentyone.model.game.GameRules;
//import com.game.twentyone.model.game.rules.BlackJackPayout;
import com.game.twentyone.model.game.rules.DeckCount;
import com.game.twentyone.model.game.rules.DeckPenetration;

/**
 * <p>
 * This is the main class of the game. Runner class.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class TwentyOne {

	private static UserInputUtility inputUtil;
	
	public TwentyOne() {
		inputUtil = new UserInputUtility();
	}
	
	/**
	 * Start the game.
	 */
	private void startGame() {
		System.out.println("Welcome to TwentyOne! Are you ready for a game of BlackJack!");
		GameRules rules = initializeRules();
		//TODO: implement game logic.
	}
	
	/**
	 * Initialize rules by getting input from the user.
	 */
	private GameRules initializeRules() {
		System.out.println("Set the rules for the game:");
		GameRules rules = new GameRules();
		
		// Get the deck count.
		DeckCount count = inputUtil.getDeckCountFromUser();
		rules.setDeckCount(count);
		
		// Get the deck penetration.
		DeckPenetration deckPenetration = inputUtil.getDeckPenetrationFromUser();
		rules.setDeckPenetration(deckPenetration);
		
		// Get value for 'is surrender allowed'.
		boolean surrenderAllowed = inputUtil.getIsSurrenderAllowedFromUser();
		rules.setSurrenderAllowed(surrenderAllowed);
		
		// Get the value for 'is double down allowed'.
		boolean doubleDownAllowed = inputUtil.getIsDoubleDownAllowedFromUser();
		rules.setDoubleDownAllowed(doubleDownAllowed);
		
		// Get the value for 'does dealer hit on 17'.
		boolean dealerHitsOn17 = inputUtil.getDoesDealerHitOn17FromUser();
		rules.setDealerHitsOn17(dealerHitsOn17);
		
//		// Get the value for 'is triple down allowed'.
//		boolean tripleDownAllowed = inputUtil.getIsTripleDownAllowedFromUser();
//		rules.setDoubleDownAllowed(tripleDownAllowed);
//		
//		// Get the BlackJack payout.
//		BlackJackPayout bjPayout = inputUtil.getBlackJackPayoutFromUser();
//		rules.setBlackJackPayout(bjPayout);
		
		return rules;
	}
	
	/**
	 * This is the main entry point for the game. Execution begins here.
	 */
	public static void main(String args[]) throws IOException {
		TwentyOne to = new TwentyOne();
		to.startGame();
	}
}
