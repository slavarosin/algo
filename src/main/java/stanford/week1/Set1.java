package stanford.week1;


public class Set1 {
	public static void main(final String[] args) {
		int len = 500;

		for (int i = 0; i < len; i++) {
			System.out.println(i * i + " " + (Math.log(i) / Math.log(3)));
		}
	}
}
