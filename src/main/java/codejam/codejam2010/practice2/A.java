package codejam.codejam2010.practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class A {
	public static void main(String[] in) throws IOException {
		URL fileIn = A.class.getResource("Cright-large-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(A.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			int c = Integer.parseInt(reader.readLine());
			int i = Integer.parseInt(reader.readLine());

			String line = reader.readLine();
			String[] params = line.split("\\s");

			int[] prices = new int[i];
			int index = 0;
			while (index < i) {
				int p = Integer.parseInt(params[index]);
				prices[index] = p;
				index++;
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(c, prices);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int c, int[] prices) {
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (i == j) {
					continue;
				}
				if (prices[i] + prices[j] == c) {
					return i < j ? (++i) + " " + (++j) : (++j) + " " + (++i);
				}
			}
		}

		return 0 + " " + 0;
	}
}
