package puzzles.creator;

import puzzles.chicken.Chicken;

public class Creator {
	public static void main(final String[] args) {
		new Chicken(null) {

		}.ask();
	}
}