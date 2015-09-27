package puzzles.sleep;

public class Main {
	public static void main(final String[] args) {
		if (new Sleeper().enter(new Dream()) != 0) {
			// The goal is to reach this line
			System.out.println("Am I still dreaming?");
		}
	}
}