package puzzles.sleep;

public class Sleeper {
	private int level;

	public synchronized int enter(final Dream dream) {
		level++;
		try {
			dream.dream(this);
		} finally {
			level--;
		}
		return level;
	}
}