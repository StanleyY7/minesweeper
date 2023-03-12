package main;

import gameState.GameState;
import gameState.StartScreen;

import userInput.UserInput;

public class Main {
	
 public static void main (String[] args) {
	 
	 StartScreen.display();
	 
	 // instance/object of GameState class
	 
	 GameState gameState = new GameState(15);
 
 	// Running the game
	 
	 while(gameState.getGameOver().equals(false)) {
		 UserInput.initiateGame(GameState.gameGrid);
	 }
	 
	 if(GameState.gameOver) {
			System.out.println(" ");	
			General.setTimeout(2000);
			GameState.gameOver = false;
			main(args);
		}
 }
 
}
