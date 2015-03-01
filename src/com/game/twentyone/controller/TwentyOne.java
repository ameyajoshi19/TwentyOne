package com.game.twentyone.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.game.twentyone.controller.util.UserInputUtility;
import com.game.twentyone.model.game.Game;
import com.game.twentyone.model.game.GameRules;
import com.game.twentyone.model.game.rules.BlackJackPayout;
import com.game.twentyone.model.game.rules.DeckCount;
import com.game.twentyone.model.game.rules.DeckPenetration;

/**
 * <p>
 * This is the main controller class for the app.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class TwentyOne {

	private static Logger logger = Logger.getLogger(TwentyOne.class.getName());
	private static UserInputUtility inputUtil;
	
	public TwentyOne() {
		inputUtil = new UserInputUtility();
	}
	
	/**
	 * Start the game.
	 */
	private void startGame() {
		System.out.println("Welcome to TwentyOne! Are you ready for a game of BlackJack? Alright then!");
		GameRules rules = initializeRules();
		Game game = initializeGame(rules);
		
		
		//TODO: implement game logic.
		
		
	}
	
	/**
	 * Initliaze the game using the game rules.
	 */
	private Game initializeGame(GameRules rules) {
		return new Game(rules);
	}
	
	/**
	 * Initialize rules by getting input from the user.
	 */
	private GameRules initializeRules() {
		System.out.println("Let's set the rules for the game:");
		GameRules rules = new GameRules();
		try {
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
			
			// Get the value for 'is triple down allowed'.
			boolean tripleDownAllowed = inputUtil.getIsTripleDownAllowedFromUser();
			rules.setDoubleDownAllowed(tripleDownAllowed);
			
			// Get the BlackJack payout.
			BlackJackPayout bjPayout = inputUtil.getBlackJackPayoutFromUser();
			rules.setBlackJackPayout(bjPayout);
		} catch (InterruptedException e) {
			logger.severe("InterruptedException while getting user input. Ex: " + e);
		}
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
