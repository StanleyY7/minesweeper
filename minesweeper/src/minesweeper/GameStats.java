package minesweeper;

public class GameStats {
private int wins;
private int losses;

public GameStats() {
	this.wins = 0;
	this.losses = 0;
}

public int getWins() {
	return wins;
}
public int getLosses() {
	return losses;
}

public void incrementWins() {
wins++;	
}

public void incrementLosses() {
losses++;	
}

}

