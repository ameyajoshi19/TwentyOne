package com.game.twentyone.model.game;

import java.util.ArrayList;
import java.util.List;

import com.game.twentyone.model.deck.values.Card;
import com.game.twentyone.model.deck.values.CardValue;
import com.game.twentyone.model.deck.values.PlayerMoney;
import com.game.twentyone.model.deck.values.SuiteValue;

/**
 * <p>
 * This class implements the Game class.
 * </p>
 * @author AmeyaCJoshi
 *
 */
public class Game {

	private GameRules gameRules;
	private List<Card> unseenCards;
	private List<Card> seenCards;
	private PlayerMoney playerMoney;
	private Hand dealerHand;
	private Hand playerHand;
	
	private static final double INITIAL_MONEY = 1000.0; 
	
	/**
	 * Constructor.
	 */
	public Game(GameRules rules) {
		this.gameRules = rules;
		this.unseenCards = initializeDecks(rules.getDeckCount().getDeckCountIntValue());
		this.seenCards = new ArrayList<Card>();
		this.playerMoney.setPlayerMoney(INITIAL_MONEY);
	}
	
	/**
	 * Method which initializes the unseenCards for the game.
	 */
	private List<Card> initializeDecks(int count) {
		List<Card> decks = new ArrayList<Card>();
		for(int deck = 0; deck < count; deck++) {
			for(SuiteValue suite : SuiteValue.values()) {
				for(CardValue card : CardValue.values()) {
					Card c = new Card(card, suite);
					decks.add(c);
				}
			}
		}
		return decks;
	}

	public GameRules getGameRules() {
		return gameRules;
	}

	public void setGameRules(GameRules gameRules) {
		this.gameRules = gameRules;
	}

	public List<Card> getUnseenCards() {
    	return unseenCards;
    }

	public void setUnseenCards(List<Card> unseenCards) {
    	this.unseenCards = unseenCards;
    }

	public List<Card> getSeenCards() {
    	return seenCards;
    }

	public void setSeenCards(List<Card> seenCards) {
    	this.seenCards = seenCards;
    }

	public PlayerMoney getPlayerMoney() {
    	return playerMoney;
    }

	public void setPlayerMoney(PlayerMoney playerMoney) {
    	this.playerMoney = playerMoney;
    }

	public Hand getDealerHand() {
    	return dealerHand;
    }

	public void setDealerHand(Hand dealerHand) {
    	this.dealerHand = dealerHand;
    }

	public Hand getPlayerHand() {
    	return playerHand;
    }

	public void setPlayerHand(Hand playerHand) {
    	this.playerHand = playerHand;
    }
}
