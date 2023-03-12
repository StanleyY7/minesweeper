package gameState;

public class GameStats {
		static int wins = 0;
		static int losses = 0;

		public GameStats() {
		}

		public static void incrementWins() {
			wins++;
		}

		public static void incrementLosses() {
			losses++;
		}

		public int getWins() {
			return GameStats.wins;
		}

		public int getLosses() {
			return GameStats.losses;
}
}