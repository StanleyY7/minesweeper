package minesweeper;

import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	static String bomb = new String ("?");
	
	static String revealBomb = "\u001B[31m" + "X" + "\u001B[0m";
	
	static String question = "?";
	
	static Boolean gameOver = false;
	
	static Boolean correctInput = false;
	
	static int numberOfBombs = 5;
	
	static int clearCells = 100 - numberOfBombs;
	
	static int count = 0;	
	
	static String heading = 
			"  __  __   _                   _____                                                 \n" +
					" |  \\/  | (_)                 / ____|                                               \n" +
					" | \\  / |  _   _ __     ___  | (___   __      __   ___    ___   _ __     ___   _ __ \n" +
					" | |\\/| | | | | '_ \\   / _ \\  \\___ \\  \\ \\ /\\ / /  / _ \\  / _ \\ | '_ \\   / _ \\ | '__|\n" +
					" | |  | | | | | | | | |  __/  ____) |  \\ V  V /  |  __/ |  __/ | |_) | |  __/ | |   \n" +
					" |_|  |_| |_| |_| |_|  \\___| |_____/    \\_/\\_/    \\___|  \\___| | .__/   \\___| |_|   \n" +
					"                                                               | |                  \n" +
					"                                                               |_|                  \n";   
	static String rules = "The rules of this simplified minesweeper clone are: \n" +
					"on the grid, there are 100 cells, a cell could be empty \n"+
			"or it could contain a bomb. In the console, type in an X \n" +
					"(i.e. 0 to 9) coordinate and then a Y coordinate (also 0 to 9). \n"
					+ "If that location contains a bomb it will be game over. \n";
	
	public static String[][] gameGrid() {
int cols = 10;
int rows = 10;

String[][] gameArray = new String [rows][cols];
for (int i = 0; i < gameArray.length; i++) {
	for (int j = 0; j < gameArray[i].length; j++) {
		gameArray[i][j] = question;
	}
}
return gameArray;
	}
	
 public static void placeBombs(String[][] gameGrid, int bombs) {
		int bombCount = 0;
		while (bombCount < bombs) {
	        int x = (int) (Math.random() * gameGrid.length);
	        int y = (int) (Math.random() * gameGrid[0].length);
	        if(gameGrid[x][y] == question) {
	        	gameGrid[x][y] = bomb;
	        	System.out.printf(" the bombs are at %d%d \n", x, y);
	        	bombCount++;
	        } 
		}
	}
 
 public static void setTimeout(int ms) {
	 try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
 }
 
 public static String checkInput(String[][] gameGrid, int coordinateXInput, int coordinateYInput) {

int xCor = coordinateXInput;
int yCor = coordinateYInput;
String result = "";

if (xCor >= 0 && xCor <= 9 && yCor >= 0 && yCor <= 9) {
	
	 if (gameGrid[xCor][yCor] == question) {
         if (count < clearCells) {
             // Count bombs in adjacent squares
             int bombCount = 0;
             for (int x = Math.max(0, xCor - 1); x <= Math.min(9, xCor + 1); x++) {
                 for (int y = Math.max(0, yCor - 1); y <= Math.min(9, yCor + 1); y++) {
                     if (gameGrid[x][y] == bomb) {
                         bombCount++;
                     }
                 }
             }
             // Set clear square to bomb count/unicode for relevant bomb count
String displayBombCount = Integer.toString(bombCount);
if (bombCount > 0) {
    gameGrid[xCor][yCor] = "\u001B[38;2;255;165;0m" + displayBombCount + "\u001B[0m";
} else {
    gameGrid[xCor][yCor] = "\u001B[32m" + displayBombCount + "\u001B[0m";
}

             count += 1;
             int remaining = clearCells - count;
             System.out.println("That cell is clear! There are: " + remaining + " cell/s left to clear");
             setTimeout(1250);
         }
	
} else if (gameGrid[xCor][yCor] == bomb) {
	
	gameGrid[xCor][yCor] = revealBomb;
	
	for (String[] row : gameGrid) {
	    for (String cell : row) {
	            System.out.print("| " + cell + " |");
	    }
	    System.out.println();
	}
	System.out.println(" ");
	
	setTimeout(2000);
	System.out.println("Boom!");
	System.out.println("============GAME OVER============");
	setTimeout(1250);
	System.out.println("GAME RESTARTING...");
	setTimeout(3000);
	gameOver = true;
}

}  else {
	result = "Not valid input, please enter coordinates/numbers from 0 to 9";
}

return result;

	}
	
 public static void initiateGame(String[][] gameGrid) {
	 while(gameOver.equals(false) && count < clearCells) {
			for (String[] row : gameGrid) {
			    for (String cell : row) {
			            System.out.print("| " + cell + " |");
			    }
			    System.out.println();
			}

			System.out.println(" ");	
			
		System.out.println("Please enter an X coordinate");
		int coordinateXInput = scan.nextInt();

		System.out.println("Please enter a Y coordinate");
		int coordinateYInput = scan.nextInt();

		System.out.println(checkInput(gameGrid, coordinateXInput, coordinateYInput));
		} 

		if(count >= clearCells) {
			System.out.println("\n================You WON!!!================");

			setTimeout(3000);
			count = 0;
			gameOver = true;
		}
 }
 
	public static void main(String[] args) {
		System.out.println(heading);
		
		setTimeout(1000);
		System.out.println("Version 1.00\n"
				+ "Made by Stanley ");
		System.out.println("");
		
		setTimeout(1500);
		System.out.println(rules);
		correctInput = false;
		String[][] gameGrid = gameGrid();
		
		setTimeout(3000);
		while(!correctInput) {
		System.out.println("When you are ready to play, please input S or s");
		String startInput = scan.next(); 
		if(startInput.equals("S") || startInput.equals("s")) {
			correctInput = true;

			placeBombs(gameGrid, numberOfBombs);

			initiateGame(gameGrid);
		} 
		}

if(gameOver) {
	System.out.println(" ");	
	setTimeout(2000);
	gameOver = false;
	main(args);
}

	}
}