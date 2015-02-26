package com.game.twentyone.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.game.twentyone.model.game.GameRules;
import com.game.twentyone.model.game.rules.DeckCount;

/**
 * <p>
 * This is the main class of the game. Runner class.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class TwentyOne {

	private static Logger logger = Logger.getLogger(TwentyOne.class.getCanonicalName());
	
	private void startGame(TwentyOne to) {
		System.out.println("Welcome to TwentyOne! Are you ready for a game of BlackJack!");
		to.initializeRules(to);
		
	}
	
	private GameRules initializeRules(TwentyOne to) {
		System.out.println("Set the rules for the game:");
		GameRules rules = new GameRules();
		
		DeckCount count = to.getDeckCount();
		rules.setDeckCount(count);
		
		return rules;
	}
	
	private DeckCount getDeckCount() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		List<Integer> allowedDeckCounts = new ArrayList<Integer>();
		for(DeckCount count : DeckCount.values()) {
			allowedDeckCounts.add(count.getDeckCount());
		}
		System.out.println("How many decks in the game? " + allowedDeckCounts + ": ");
		int userCount = 1;
		try {
			userCount = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			logger.severe("Error reading the deck count!");
		} catch (IOException e) {
			logger.severe("Error reading the deck count!");
		}

		DeckCount enteredCount = null;
		if(userCount == DeckCount.ONE.getDeckCount()) {
			enteredCount = DeckCount.ONE;
		} else if(userCount == DeckCount.TWO.getDeckCount()) {
			enteredCount = DeckCount.TWO;
		} else if(userCount == DeckCount.THREE.getDeckCount()) {
			enteredCount = DeckCount.THREE;
		} else if(userCount == DeckCount.FOUR.getDeckCount()) {
			enteredCount = DeckCount.FOUR;
		} else if(userCount == DeckCount.FIVE.getDeckCount()) {
			enteredCount = DeckCount.FIVE;
		} else if(userCount == DeckCount.SIX.getDeckCount()) {
			enteredCount = DeckCount.SIX;
		} else {
			logger.severe("Enter a valid deck count!");
		}
		return enteredCount;
	}
	
	/**
	 * This is the main entry point for the game. Execution begins here.
	 */
	public static void main(String args[]) throws IOException {
		TwentyOne to = new TwentyOne();
		to.startGame(to);
	}
}
