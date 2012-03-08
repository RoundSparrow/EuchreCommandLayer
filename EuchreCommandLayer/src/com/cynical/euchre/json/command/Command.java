package com.cynical.euchre.json.command;

/**
 * This enum will act as an index of commands to be sent server side.
 * 
 * @author Adam Benjamin
 *
 */
public enum Command {
	
	
	//////////////////////////////
	//	Pre-Game Commands
	//////////////////////////////
	LOGIN,
	REQUEST_LOBBY_REFRESH,
	JOIN_GAME,
	
	//////////////////////////////
	//	In-Game Commands
	//////////////////////////////
	REQUEST_GAME_STATE,
	ORDER_UP,
	PASS,
	DISCARD,
	PLAY_CARD,
	
	//////////////////////////////
	//	Error
	//////////////////////////////
	NOT_A_COMMAND;
	
}
