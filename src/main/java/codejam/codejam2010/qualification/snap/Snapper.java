package codejam.codejam2010.qualification.snap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Snapper {
	private static boolean isOnOrOff(int n, int k) {
		if (k == 0) {
			return false;
		}

		k++;

		double div = Math.pow(2, n);
		return (k % div) == 0;
	}

	public static void main(String[] in) throws IOException {
		URL fileIn = Snapper.class.getResource("Cright-large.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File("Cright.out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int n = Integer.parseInt(params[0]);
			int k = Integer.parseInt(params[1]);

			String outputLine = "Case #" + (t + 1) + ": "
					+ (isOnOrOff(n, k) ? "ON" : "OFF");
			// System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}
}
