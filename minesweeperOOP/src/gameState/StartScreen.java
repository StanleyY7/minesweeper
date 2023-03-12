package gameState;
import main.General;

public class StartScreen {
	
	// Global Variables
	public static String heading = 
			"  __  __   _                   _____                                                 \n" +
					" |  \\/  | (_)                 / ____|                                               \n" +
					" | \\  / |  _   _ __     ___  | (___   __      __   ___    ___   _ __     ___   _ __ \n" +
					" | |\\/| | | | | '_ \\   / _ \\  \\___ \\  \\ \\ /\\ / /  / _ \\  / _ \\ | '_ \\   / _ \\ | '__|\n" +
					" | |  | | | | | | | | |  __/  ____) |  \\ V  V /  |  __/ |  __/ | |_) | |  __/ | |   \n" +
					" |_|  |_| |_| |_| |_|  \\___| |_____/    \\_/\\_/    \\___|  \\___| | .__/   \\___| |_|   \n" +
					"                                                               | |                  \n" +
					"                                                               |_|                  \n";   
	
	public static String rules = "\nThe rules of this simplified minesweeper clone are: \n" +
					"on the grid, there are 100 cells, a cell could be empty \n"+
			"or it could contain a bomb. In the console, type in an X \n" +
					"(i.e. 0 to 9) coordinate and then a Y coordinate (also 0 to 9). \n"
					+ "If that location contains a bomb it will be game over. \n";
	public static GameStats gameStats = new GameStats();
		
	// constructor
	public StartScreen(GameStats gameStats) {
		StartScreen.gameStats = gameStats;
	}
	
	// display startScreen
	public static void display() {
		System.out.println(heading);
		General.setTimeout(1000);
		System.out.println("Version 1.00\n"
				+ "Made by Stanley ");
		System.out.println("");
		System.out.printf("Your Wins: %d Your Losses: %d \n", gameStats.getWins(), gameStats.getLosses());
		General.setTimeout(1500);
		System.out.println(rules);
	}	
}
