package userInput;

import command.CheckInput;
import command.Invoker;
import command.Receiver;
import gameState.GameState;
import gameState.GameStats;
import main.General;

import java.util.Scanner;

public class UserInput {
	
    public static int coordinateXInput;
    public static int coordinateYInput; 
    public static Scanner scan = new Scanner(System.in);

    public static void initiateGame(String[][] gameGrid){
        
        Receiver receiver = new Receiver();
        CheckInput checkInputCommand = new CheckInput();
        Invoker invoker = new Invoker(checkInputCommand, receiver);

        while(!GameState.gameOver && GameState.getCount() < GameState.clearCells) {
            
            for (String[] row : gameGrid) {
                for(String cell: row) {
                    System.out.print("| " + cell + " |");
                }
                  System.out.println();
            }
            
            System.out.println("Please Enter a X coordinate");
            int coordinateXInput = scan.nextInt();
            
            System.out.println("Please Enter a Y coordinate");
            int coordinateYInput = scan.nextInt();
            
            UserInput.coordinateXInput = coordinateXInput;
            UserInput.coordinateYInput = coordinateYInput;
            
            invoker.invoke();
            System.out.println(checkInputCommand.getResult());
            
            if(GameState.getCount() >= GameState.clearCells) {
                System.out.println("\n================You WON!!!================");
                GameStats.incrementWins();
                General.setTimeout(3000);
                GameState.count = 0;
                GameState.gameOver = true;
            }
        }
        
    }

}
