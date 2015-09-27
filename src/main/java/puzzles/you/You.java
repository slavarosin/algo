package puzzles.you;

import puzzles.clowns.Clown;
import puzzles.clowns.Volkswagen;

public class You {
	static class RClown extends Clown {
		@Override
		public int hashCode() {
			if (--howMuchWeNeed > 0) {
				vw.add(new RClown());
			}
			return super.hashCode();
		}
	}

	static int howMuchWeNeed = 20;

	static Volkswagen vw = new Volkswagen();

	public static void main(final String args[]) {
		vw.add(new RClown());
		vw.done();
	}

}
