package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import gameState.GameState;
import command.Receiver;

class Tests {
	 GameState gameState = new GameState(0);
	@Test
	void testCheckInputOutOfBounds() {
	    String[][] gameGrid = GameState.gameGrid;
		int x = 10;
		int y = 10;
		String result = Receiver.executeCheckInput(gameGrid, x, y);
		assertEquals("Not valid input, please enter coordinates/numbers from 0 to 9", result);
		
	}
	
	@Test
	void testCheckInputWithBomb() {

	    String[][] gameGrid = GameState.gameGrid;
	    
	    gameGrid[0][0] = GameState.bomb;
	    
	    int x = 0;
	    int y = 0;
	    
	    String result = Receiver.executeCheckInput(gameGrid, x, y);
	    if(gameGrid[x][y] == GameState.bomb) {
		assertEquals("Adding a Loss", result);
	    }
	}
	
	@Test
	void bombCountInPlaceBombs() {
	    String[][] gameGrid = GameState.gameGrid;

	    int expectedBombs = 5;
	    int actualBombs = 0;

	    List<Integer> bombColumns = new ArrayList<>();
	    while (bombColumns.size() < expectedBombs) {
	        int column = (int) (Math.random() * gameGrid[0].length);
	        if (!bombColumns.contains(column)) {
	            bombColumns.add(column);
	        }
	    }
	    for (int column : bombColumns) {
	        gameGrid[0][column] = GameState.bomb;
	    }
	    for (int i = 0; i < gameGrid.length; i++) {
	        for (int j = 0; j < gameGrid[0].length; j++) {
	            if (gameGrid[i][j] == GameState.bomb) {
	                actualBombs++;
	            }
	        }
	    }
	    assertEquals(expectedBombs, actualBombs);
	}



}
