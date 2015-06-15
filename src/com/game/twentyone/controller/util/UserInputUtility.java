package com.game.twentyone.controller.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

import com.game.twentyone.model.game.rules.BlackJackPayout;
import com.game.twentyone.model.game.rules.DeckCount;
import com.game.twentyone.model.game.rules.DeckPenetration;

/**
 * <p>
 * This class has all the utility methods used by the controller to get user
 * input.
 * </p>
 * 
 * @author AmeyaCJoshi
 * 
 */
public class UserInputUtility {

	private static Logger logger = Logger.getLogger(UserInputUtility.class.getName());
	private static InputStreamReader isr;
	private static BufferedReader br;

	private static final DeckCount DECK_COUNT_DEFAULT = DeckCount.ONE;
	private static final DeckPenetration DECK_PENETRATION_DEFAULT = DeckPenetration.EIGHTY;
	private static final BlackJackPayout BLACKJACK_PAYOUT_DEFAULT = BlackJackPayout.TwoToOne;
	private static final boolean SURRENDER_ALLOWED_DEFAULT = Boolean.FALSE;
	private static final boolean DOUBLE_DOWN_ALLOWED_DEFAULT = Boolean.FALSE;
	private static final boolean TRIPLE_DOWN_ALLOWED_DEFAULT = Boolean.FALSE;
	private static final boolean DEALER_HITS_ON_17_DEFAULT = Boolean.FALSE;
	private static final String BJ_PAYOUT_2_TO_1 = "TwoToOne";
	private static final String BJ_PAYOUT_3_TO_2 = "ThreeToTwo";

	public UserInputUtility() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}

	/**
	 * Take deck count as an input from user.
	 * @throws InterruptedException 
	 */
	public DeckCount getDeckCountFromUser() throws InterruptedException {
		System.out
		        .print("How many decks of cards you want to play with? (Default is " + DECK_COUNT_DEFAULT
		        		+ ". Press ENTER for default.) " + Arrays.asList(DeckCount.values()) + ": ");
		int userCount = DECK_COUNT_DEFAULT.getDeckCountIntValue();
		try {
			userCount = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			logger.info("Error reading the deck count. Setting it to default.");
		} catch (IOException e) {
			logger.info("Error reading the deck count. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		// Iterate over DeckCount enum only if userCount is not default.
		DeckCount enteredCount = null;
		if (userCount != DECK_COUNT_DEFAULT.getDeckCountIntValue()) {
			for (DeckCount count : DeckCount.values()) {
				if (userCount == count.getDeckCountIntValue()) {
					enteredCount = count;
				}
			}
		}
		// Set value to default if null.
		if (null == enteredCount) {
			enteredCount = DECK_COUNT_DEFAULT;
		}
		return enteredCount;
	}

	/**
	 * Take deck penetration as an input from user.
	 * @throws InterruptedException 
	 */
	public DeckPenetration getDeckPenetrationFromUser() throws InterruptedException {
		System.out
		        .print("What should be the deck penetration? (Deck penetration is the percentage depth"
		                + " of the deck when it will be reshuffled. Default is " + DECK_PENETRATION_DEFAULT 
		                + ". Press ENTER for default.) " + Arrays.asList(DeckPenetration.values()) + ": ");
		int userPenetration = DECK_PENETRATION_DEFAULT.getDeckPenetration();
		try {
			userPenetration = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			logger.info("Error reading the deck penetration. Setting it to default.");
		}  catch (IOException e) {
			logger.info("Error reading the deck penetration. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		
		// Iterate over DeckPenetration enum only if userPenetration is not default.
		DeckPenetration enteredPenetration = null; // 'enteredPenetration' pun not intended! :P
		if (userPenetration != DECK_PENETRATION_DEFAULT.getDeckPenetration()) {
			for (DeckPenetration penetration : DeckPenetration.values()) {
				if (userPenetration == penetration.getDeckPenetration()) {
					enteredPenetration = penetration;
				}
			}
		}
		// Set value to default if null.
		if (null == enteredPenetration) {
			enteredPenetration = DECK_PENETRATION_DEFAULT;
		}
		return enteredPenetration;
	}

	/**
	 * Ask user if 'surrender' is allowed.
	 * @throws InterruptedException 
	 */
	public boolean getIsSurrenderAllowedFromUser() throws InterruptedException {
		System.out
		        .print("Is 'surrender' allowed in the game? (Default is " + SURRENDER_ALLOWED_DEFAULT + ". Press ENTER for default.): ");
		boolean isSurrenderAllowed = SURRENDER_ALLOWED_DEFAULT;
		try {
			isSurrenderAllowed = Boolean.parseBoolean(br.readLine());
		} catch (IOException e) {
			logger.info("Error reading the value for isSurrenderAllowed. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		return isSurrenderAllowed;
	}

	/**
	 * Ask user if 'double down' is allowed.
	 * @throws InterruptedException 
	 */
	public boolean getIsDoubleDownAllowedFromUser() throws InterruptedException {
		System.out
		        .print("Should 'double down' allowed in the game? (Default is " + DOUBLE_DOWN_ALLOWED_DEFAULT + ". Press ENTER for default.): ");
		boolean isDoubleDownAllowed = DOUBLE_DOWN_ALLOWED_DEFAULT;
		try {
			isDoubleDownAllowed = Boolean.parseBoolean(br.readLine());
		} catch (IOException e) {
			logger.info("Error reading the value for isDoubleDownAllowed. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		return isDoubleDownAllowed;
	}

	/**
	 * Ask user if 'triple down' is allowed.
	 * @throws InterruptedException 
	 */
	public boolean getIsTripleDownAllowedFromUser() throws InterruptedException {
		System.out
		        .print("Should 'triple down' allowed in the game? (Default is " + TRIPLE_DOWN_ALLOWED_DEFAULT + ". Press ENTER for default.): ");
		boolean isTripleDownAllowed = TRIPLE_DOWN_ALLOWED_DEFAULT;
		try {
			isTripleDownAllowed = Boolean.parseBoolean(br.readLine());
		} catch (IOException e) {
			logger.info("Error reading the value for isTripleDownAllowed. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		return isTripleDownAllowed;
	}

	/**
	 * Ask user if 'dealer hits on 17'.
	 * @throws InterruptedException 
	 */
	public boolean getDoesDealerHitOn17FromUser() throws InterruptedException {
		System.out
		        .print("Should dealer hit on 17? (Default is " + DEALER_HITS_ON_17_DEFAULT + ". Press ENTER for default.): ");
		boolean doesDealerHitOn17 = DEALER_HITS_ON_17_DEFAULT;
		try {
			doesDealerHitOn17 = Boolean.parseBoolean(br.readLine());
		} catch (IOException e) {
			logger.info("Error reading the value for doesDealerHitOn17. Setting it to default.");
		} finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(100);
		}
		return doesDealerHitOn17;
	}

	/**
	 * Take 'blackJack payout' as an input from user.
	 * @throws InterruptedException 
	 */
	public BlackJackPayout getBlackJackPayoutFromUser() throws InterruptedException {
		System.out
		        .print("What is the BJ payout? (Default is " + BLACKJACK_PAYOUT_DEFAULT + ". Press ENTER for default.) "
		                + Arrays.asList(BlackJackPayout.values()) + ": ");
		double userPayout = BLACKJACK_PAYOUT_DEFAULT.getBlackjackPayout();
		String userInput = null;
        try {
	        userInput = br.readLine();
        } catch (IOException e) {
        	logger.info("Error reading the value for blackjackPayout. Setting it to default.");
        } finally {
			// Sleeping to give time to logger to log.
			Thread.sleep(1000);
		}
		if(!userInput.equalsIgnoreCase(BJ_PAYOUT_2_TO_1) && !userInput.equalsIgnoreCase(BJ_PAYOUT_3_TO_2)) {
			logger.info("Error reading the value for blackjackPayout. Setting it to default.");
		}
		// Iterate over DeckCount enum only if userCount is not default.
		BlackJackPayout enteredCount = null;
		if (userPayout != BLACKJACK_PAYOUT_DEFAULT.getBlackjackPayout()) {
			for (BlackJackPayout payout : BlackJackPayout.values()) {
				if (userPayout == payout.getBlackjackPayout()) {
					enteredCount = payout;
				}
			}
		}
		// Set value to default if null.
		if (null == enteredCount) {
			enteredCount = BLACKJACK_PAYOUT_DEFAULT;
		}
		return enteredCount;
	}

}
