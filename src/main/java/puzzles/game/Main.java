package puzzles.game;

import puzzles.game.Game.Ball;

public class Main {
	public static void main(final String[] args) {
		Game game = new Game();

		try {
			game.play();
		} catch (Ball e) {
			e.initCause(e.getCause());
		}
	}
}
