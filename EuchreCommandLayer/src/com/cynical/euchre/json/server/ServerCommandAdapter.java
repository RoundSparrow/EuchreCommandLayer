package com.cynical.euchre.json.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.cynical.euchre.json.command.Command;
import com.cynical.euchre.json.model.CommandArgumentsModel;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * This class will act as an adapter to <b><i>receive</i></b> commands, and the objects (arguments)
 * that will be needed for the command to successfully execute on the server.
 * 
 * @author Adam Benjamin
 *
 */
public class ServerCommandAdapter {
	
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;
	
	private Gson gson;
	
	public ServerCommandAdapter(Socket s) throws IOException {
		this.sock = s;
		this.gson = new Gson();
		try {
			this.reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (IOException e1) {
			throw new IOException("Could not open input stream", e1);
		}
		try {
			this.writer = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			throw new IOException("Could not open output stream", e);
		}
	}
	
	public Command getNextCommand() throws IOException {
		try {
			String command = reader.readLine();
			Command c = gson.fromJson(command, Command.class);
			return c;
		} catch (IOException e) {
			throw new IOException("Reading next command failed", e);
		} catch (JsonSyntaxException e) {
			return Command.NOT_A_COMMAND;
		}
	}
	
	public CommandArgumentsModel getCommandArguments(Command c) {
		switch(c) {
		//////////////////////////////////
		//	Pre-Game Commands
		//////////////////////////////////
		case LOGIN:
			
			break;
		case REQUEST_LOBBY_REFRESH:
			
			break;
		case JOIN_GAME:
			
			break;
			
		//////////////////////////////////
		//	In-Game Commands
		//////////////////////////////////
		case REQUEST_GAME_STATE:
			
			break;
		case ORDER_UP:
			
			break;
		case PASS:
			
			break;
		case DISCARD:
			
			break;
		case PLAY_CARD:
			
			break;
			
		///////////////////////////////////
		//	Error
		///////////////////////////////////
		case NOT_A_COMMAND:
			
			break;
			
		}
		return null; //	TODO: Temporary
	}

}
