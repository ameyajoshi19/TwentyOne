package com.game.twentyone.model.game;

public enum PlayerMove {

	DOUBLE_DOWN("double_down"),
	TRIPLE_DOWN("triple_down"),
	HIT("hit"),
	STAY("stay"),
	SURRENDER("surrender");
	
	String move;
	
	PlayerMove(String move) {
		this.move = move;
	}
	
	public String getValue() {
		return this.move;
	}
}
