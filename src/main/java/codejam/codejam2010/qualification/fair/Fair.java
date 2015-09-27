package codejam.codejam2010.qualification.fair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Fair {
	private static String getTime(String[] params) {
		int n = Integer.parseInt(params[0]);
		BigInteger y = new BigInteger(params[1]);

		List<BigInteger> ints = new LinkedList<BigInteger>();
		for (int i = 1; i <= n; i++) {
			BigInteger bigI = new BigInteger(params[i]);
			ints.add(bigI.subtract(y).abs());
		}

		BigInteger gcd = null;

		for (BigInteger bigI : ints) {
			if (gcd == null) {
				gcd = bigI;
			} else {
				gcd = gcd.gcd(bigI);
			}
		}

		BigInteger rm = y.remainder(gcd);

		if (rm.intValue() == 0) {
			return "0";
		}

		return gcd.subtract(rm).toString();
	}

	public static void main(String[] in) throws IOException {
		URL file = Fair.class.getResource("Cright-large-practice.in");

		String path = file.getFile();

		BufferedReader reader = new BufferedReader(new FileReader(path));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			System.out.println("Case #" + (t + 1) + ": " + getTime(params));
		}
	}
}
