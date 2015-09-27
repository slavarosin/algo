package puzzles.driver;

import puzzles.car.Car;

public class Driver {
	@SuppressWarnings("deprecation")
	public static void main(final String args[]) {
		final Car car = new Car();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				car.accelerate(Integer.MAX_VALUE);
			}
		});

		thread1.start();

		try {
			thread1.suspend();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(thread1.countStackFrames());
	}
}