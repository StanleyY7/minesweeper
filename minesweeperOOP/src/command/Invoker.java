package command;

import gameState.GameState;
import userInput.UserInput;

public class Invoker {

    private Command command;
    private Receiver receiver;

    public Invoker(Command command, Receiver receiver) {
        this.command = command;
        this.setReceiver(receiver);
    }

    public void invoke() {
        if (command instanceof CheckInput) {
            CheckInput checkInputCommand = (CheckInput) command;
            checkInputCommand.execute();
            checkInputCommand.setResult(Receiver.executeCheckInput(GameState.gameGrid, UserInput.coordinateXInput, UserInput.coordinateYInput));
        } else {
            System.out.println("Unsupported command");
        }
    }

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
}
