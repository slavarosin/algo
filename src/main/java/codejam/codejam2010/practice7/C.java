package codejam.codejam2010.practice7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;

public class C {
	public static void main(String[] in) throws IOException {
		URL fileIn = C.class.getResource("Cright-small-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int c = Integer.parseInt(params[1]);

			BigInteger[] bi = new BigInteger[params.length - 2];

			for (int i = 2; i < params.length; i++) {
				bi[i - 2] = new BigInteger(params[i]);
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(c, bi);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int c, BigInteger[] bis) {
		if (c == bis.length) {
			Arrays.sort(bis);
			return bis[0].toString();
		}

		BigInteger sum = null;

		for (BigInteger bi : bis) {
			if (sum == null) {
				sum = bi;
			} else {
				sum = sum.add(bi);
			}
		}

		return sum.divide(new BigInteger(c + "")).toString();
	}
}
