package codejam.codejam2010.practice6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class D {
	public static void main(String[] in) throws IOException {
		URL fileIn = D.class.getResource("D-small-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(D.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int n = Integer.parseInt(params[0]);
			int m = Integer.parseInt(params[1]);

			String[] s = new String[m];

			int i = 0;
			do {
				line = reader.readLine();
				s[i] = line;
				i++;
			} while (i < m);

			String outputLine = "Case #" + (t + 1) + ": " + result(n, s);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int n, String[] statements) {
		String result = "";

		boolean[] l = new boolean[n];
		boolean[] t = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!l[i] & !t[i]) {
				result += " -";
			} else if (l[i]) {
				result += " L";
			} else {
				result += " T";
			}
		}

		return result.trim();
	}
}
