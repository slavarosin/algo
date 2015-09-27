package codejam.codejam2010.practice1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class B {
	public static void main(String[] in) throws IOException {
		URL fileIn = B.class.getResource("sample.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(B.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			String outputLine = "Case #" + (t + 1) + ": " + result(params);
			// System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(String[] w1) {
		String result = "";

		for (int i = w1.length - 1; i >= 0; i--) {
			result += " " + w1[i];
		}

		return result.trim();
	}
}
