package com.game.twentyone.controller;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import com.game.twentyone.controller.util.UserInputUtility;
import com.game.twentyone.model.deck.values.Card;
import com.game.twentyone.model.deck.values.CardValue;
import com.game.twentyone.model.deck.values.PlayerMoney;
import com.game.twentyone.model.game.Game;
import com.game.twentyone.model.game.GameRules;
import com.game.twentyone.model.game.Hand;
import com.game.twentyone.model.game.PlayerMove;
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
	 * @throws InterruptedException 
	 */
	private void startGame() throws InterruptedException {
		System.out.println("Welcome to TwentyOne! Are you ready for a game of BlackJack? Alright then!");
		playGame(new Game(initializeRules()));
	}
	
	private void playGame(Game game) throws InterruptedException {
		boolean play = true;
		while(play) {
			play = inputUtil.askIfPlayerWantsToContinue();
			if(play) {
				playNextHand(game);
			} else {
				System.out.println("Thank you for playing!");
				displayPlayerMoney(game);
			}
		}
	}
	
	/**
	 * Play the next hand.
	 */
	private void playNextHand(Game game) throws InterruptedException {
		// Place bet.
		int betAmount = inputUtil.getBetValueFromUser(true);
		// Update player money.
		updatePlayerMoney(game, betAmount);
		// Deal the cards.
		dealCards(game);
		// Display dealer and player cards.
		displayOpenCards(game);
		// If the first dealer card is Ace, offer player option to surrender.
		boolean playerWantsSurrender = false;
		// Offer player to surrender if open dealer card is Ace.
		if(game.getDealerHand().getHandCards().get(0).getCardValue().equals(CardValue.ACE)) {
			playerWantsSurrender = offerPlayerSurrender();
		}
		// If player doesn't want to surrender, play on.
		boolean oneMoreCardChance = true;
		if(!playerWantsSurrender) {
			while(oneMoreCardChance) {
				oneMoreCardChance = playTheNextMove(game, askPlayerNextMove());
			}
			boolean playerIsBust = game.getPlayerHand().isBusted();
			
		} else {
			System.out.println("Surrendered.");
		}
	}
	
	/**
	 * Play user's next move.
	 */
	private boolean playTheNextMove(Game game, PlayerMove nextMove) {
		boolean isPlayerBust = game.getPlayerHand().isBusted();
		if(!isPlayerBust) {
			if(nextMove.equals(PlayerMove.DOUBLE_DOWN)) {
				playDoubleDown(game);
			} else if(nextMove.equals(PlayerMove.TRIPLE_DOWN)) {
				playTripleDown(game);
			} else if(nextMove.equals(PlayerMove.HIT)) {
				dealACard(game, game.getPlayerHand());
			} else if(nextMove.equals(PlayerMove.STAY)) {
				return false;
			}
		}
		return game.getPlayerHand().isBusted();
	}
	
	/**
	 * Play player double down.
	 */
	private void playDoubleDown(Game game) {
		Hand playerHand = game.getPlayerHand();
		int betAmount = playerHand.getBetAmount();
		PlayerMoney money = game.getPlayerMoney();
		money.setPlayerMoney(money.getPlayerMoney() - betAmount);
		playerHand.setBetAmount(betAmount * 2);
		dealACard(game, game.getPlayerHand());
	}
	
	/**
	 * Play player triple down.
	 */
	private void playTripleDown(Game game) {
		Hand playerHand = game.getPlayerHand();
		int betAmount = playerHand.getBetAmount();
		PlayerMoney money = game.getPlayerMoney();
		money.setPlayerMoney(money.getPlayerMoney() - (betAmount * 2));
		playerHand.setBetAmount(betAmount * 3);
		dealACard(game, game.getPlayerHand());
	}
	
	/**
	 * Update player money by the given amount.
	 */
	private void updatePlayerMoney(Game game, int betAmount) {
		game.getPlayerMoney().setPlayerMoney(game.getPlayerMoney().getPlayerMoney() - betAmount);
	}
	
	/**
	 * Display players money.
	 */
	private void displayPlayerMoney(Game game) {
		System.out.print("Your have $" + game.getPlayerMoney().getPlayerMoney());
	}
	
	/**
	 * Displays player's and dealer's open cards.
	 */
	private void displayOpenCards(Game game) {
		System.out.print("DEALER CARDS: ");
		game.getDealerHand().displayOpenCards();
		System.out.print("\nYOUR CARDS: ");
		game.getPlayerHand().displayOpenCards();
	}
	
	/**
	 * Ask player for their next move.
	 */
	private PlayerMove askPlayerNextMove() {
		return inputUtil.getPlayerNextMove();
	}
	
	/**
	 * Offer player the option to surrender.
	 */
	private boolean offerPlayerSurrender() {
		return inputUtil.getPlayerWantsSurrender();
	}
	
	/**
	 * Deal cards.
	 */
	private void dealCards(Game game) {
		// Initialize hands.
		Hand playerHand = new Hand(false);
		Hand dealerHand = new Hand(true);
		// Deal cards. Deal two cards each for player and dealer.
		boolean dealerCard = false;
		for (int i = 0; i < 4; i++) {
			if(dealerCard) {
				dealACard(game, dealerHand);
				dealerCard = false;
			} else {
				dealACard(game, playerHand);
				dealerCard = true;
			}
		}
		game.setDealerHand(dealerHand);
		game.setPlayerHand(playerHand);
	}
	
	/**
	 * Deal a card.
	 */
	private void dealACard(Game game, Hand hand) {
		int random = new Random().nextInt(game.getUnseenCards().size());
		Card randomCard = game.getUnseenCards().get(random);
		if(randomCard.equals(CardValue.ACE)) {
			hand.setHasAce(true);
		}
		game.getUnseenCards().remove(random);
		game.getSeenCards().add(randomCard);
		hand.addCard(randomCard);
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
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws IOException, InterruptedException {
		TwentyOne to = new TwentyOne();
		to.startGame();
	}
}
