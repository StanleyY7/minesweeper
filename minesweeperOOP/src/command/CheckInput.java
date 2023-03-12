package command;

import gameState.GameState;
import userInput.UserInput;

public class CheckInput implements Command {

    String result;

    public void execute() {
        result = Receiver.executeCheckInput(GameState.gameGrid, UserInput.coordinateXInput, UserInput.coordinateYInput);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}
