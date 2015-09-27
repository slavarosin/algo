package puzzles.liquid;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	private static Object[] arr = new Object[1];

	public static void main(final String[] args) {
		Collection<String> luggage = new ArrayList<String>() {
			@Override
			public Object[] toArray() {
				return arr = super.toArray();
			}
		};
		luggage.add("123");

		Luggage l = (new Luggage(luggage));

		arr[0] = "liquid water";

		l.fly();
	}
}
