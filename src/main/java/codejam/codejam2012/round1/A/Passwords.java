package codejam.codejam2012.round1.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

public class Passwords {
	public static void main(final String[] args) throws IOException {
		URL file = Passwords.class.getResource("sample.in");
		String path = file.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			String[] line = reader.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			line = ("1 " + reader.readLine()).split(" ");

			double best = b + 2d;
			double p = 1;
			for (int i = 0; i <= a; i++) {
				int dKeep = a + b + 1 - 2 * i;
				int dKeepAndWrong = dKeep + b + 1;
				p *= Double.parseDouble(line[i]);
				best = Math.min(best, p * dKeep + (1 - p) * dKeepAndWrong);
			}

			System.out.println("Case #" + (t + 1) + ": " + format(best));
		}
	}

	private static String format(double d) {
		return new BigDecimal(d).setScale(6, RoundingMode.HALF_UP).toString();
	}
}
