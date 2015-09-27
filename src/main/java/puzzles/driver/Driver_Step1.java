package puzzles.driver;

import puzzles.car.Car;

public class Driver_Step1 {
	public static void main(final String args[]) {
		// TODO break the speed limit
		Car car = new Car();
		car.accelerate(Integer.MIN_VALUE + 1001);
		car.accelerate(Integer.MIN_VALUE);
		car.vroom();
	}
}