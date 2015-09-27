// this is the only file you're allowed to edit
package puzzles.sleep;

public class Dream {
	public void dream(final Sleeper s) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				s.enter(new Dream() {
					@Override
					public void dream(final Sleeper s) {
						try {
							s.wait(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}).start();

		try {
			s.wait(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}