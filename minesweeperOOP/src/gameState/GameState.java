package gameState;

public class GameState {
	
	// Global Variables
	
	public static String question = "?";
	public static String bomb = new String("?");
	public static String revealBomb = "\u001B[31m" + "X" + "\u001B[0m";
	
	public static String[][] gameGrid;
	
	public int numberOfBombs;
	public static int clearCells;
	public static int count;
	public static Boolean gameOver;

		
	// Constructor for GameState
	public GameState(int numberOfBombs) {
		GameState.gameGrid = new String[10][10];
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				gameGrid[i][j] = question;
			}
		}
		
		this.numberOfBombs = numberOfBombs;
		GameState.clearCells = 100 - numberOfBombs;
		GameState.count = 0;
		GameState.gameOver = false;
		
		placeBombs();
	}
	
	// Method to place bombs randomly in the gameGrid
	public void placeBombs() {
	    int bombCount = 0;
	    while (bombCount < numberOfBombs) {
	        int x = (int) (Math.random() * gameGrid.length);
	        int y = (int) (Math.random() * gameGrid[0].length);
	        if (gameGrid[x][y].equals(question)) {
	            gameGrid[x][y] = bomb;
	            bombCount++;
	        }
	    }
	}

		// Getters
	
	public String[][] getGameGrid(){
		return gameGrid;
	}
	
	public int getNumberOfBombs() {
		return numberOfBombs;
	}
	
	public int getClearCells() {
	return clearCells;	
	}
	
	public static int getCount() {
		return count;
	}
	
	public Boolean getGameOver() {
		return gameOver;
	}
	
	public int getAdjacentBombCount(int x, int y) {
        
		int bombCount = 0;
	    for (int i = Math.max(0, x - 1); i <= Math.min(9, x + 1); i++) {
	    for (int j = Math.max(0, y - 1); j <= Math.min(9, y + 1); j++) {
	         
	    	if (gameGrid[i][j] == bomb) {
	                    bombCount++;
	                }
	            }
	        }
	        return bombCount;
	    }
	
		// Setters
	
	public void incrementCount() {
		count++;
	}
	
	public void setGameOver(Boolean gameOver) {
		GameState.gameOver = gameOver;
	}
		
}
