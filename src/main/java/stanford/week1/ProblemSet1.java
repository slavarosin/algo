package stanford.week1;

public class ProblemSet1 {
	private static double fA(final double n) {
		return Math.pow(2, Math.pow(2, n));
	}

	private static double fB(final double n) {
		return Math.pow(2, Math.pow(n, 2));
	}

	private static double fC(final double n) {
		return Math.pow(n, 2) * Math.log(n);
	}

	private static double fD(final double n) {
		return n;
	}

	private static double fE(final double n) {
		return Math.pow(n, Math.pow(2, n));
	}

	public static void main(final String[] args) {
		double n = 0;

		while (n < 1000) {
			double a = fA(n);
			double b = fB(n);
			double c = fC(n);
			double d = fD(n);
			double e = fE(n);

			System.out.println((long)a + " " + (long)b + " " + (long)c + " " + (long)d + " " + (long)e);

			n++;
		}
	}
}
