package command;

import gameState.GameState;
import gameState.GameStats;
import main.General;

public class Receiver {
    
    public static String executeCheckInput(String[][] gameGrid, int coordinateXInput, int coordinateYInput) {
        int xCor = coordinateXInput;
        int yCor = coordinateYInput;

        String result = "";

        if (xCor >= 0 && xCor <= 9 && yCor >= 0 && yCor <= 9) {

            if (gameGrid[xCor][yCor] == GameState.question) {
                if (GameState.count < GameState.clearCells) {
                    // Count bombs in adjacent squares
                    int bombCount = 0;
                    for (int x = Math.max(0, xCor - 1); x <= Math.min(9, xCor + 1); x++) {
                        for (int y = Math.max(0, yCor - 1); y <= Math.min(9, yCor + 1); y++) {
                            if (gameGrid[x][y] == GameState.bomb && (x != xCor || y != yCor)) {
                                bombCount++;
                            }
                        }
                    }

                    // Set clear square to bomb count/unicode for relevant bomb count
                    String displayBombCount = Integer.toString(bombCount);

                    if (bombCount > 0) {
                        gameGrid[xCor][yCor] = "\u001B[38;2;255;165;0m" + displayBombCount + "\u001B[0m";
                    } else {
                        gameGrid[xCor][yCor] = " ";

                    }

                    GameState.count += 1;
                    int remaining = GameState.clearCells - GameState.count;
                    System.out.println("That cell is clear! There are: " + remaining + " cell/s left to clear");

                    General.setTimeout(1250);

                }

            } else if (gameGrid[xCor][yCor] == GameState.bomb) {

                gameGrid[xCor][yCor] = GameState.revealBomb;
                result = "Adding a Loss";

                for (String[] row : gameGrid) {
                    for (String cell : row) {
                        System.out.print("| " + cell + " |");
                    }
                    System.out.println();
                }
                System.out.println(" ");

                General.setTimeout(2000);
                System.out.println("Boom!");
                System.out.println("============GAME OVER============");
                GameStats.incrementLosses();
                General.setTimeout(1250);
                System.out.println("GAME RESTARTING...");
                General.setTimeout(3000);
                GameState.gameOver = true;
            }

        } else {
            result = "Not valid input, please enter coordinates/numbers from 0 to 9";
        }

        return result;
    }
}
