package codejam.codejam2010.round1A.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class C {
	public static void main(String[] in) throws IOException {
		URL fileIn = C.class.getResource("sample.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int a1 = Integer.parseInt(params[0]);
			int a2 = Integer.parseInt(params[1]);
			int b1 = Integer.parseInt(params[2]);
			int b2 = Integer.parseInt(params[3]);

			String outputLine = "Case #" + (t + 1) + ": "
					+ result(a1, a2, b1, b2);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static int result(int a1, int a2, int b1, int b2) {
		if (a1 < b1) {
			return 0;
		}

		return 1;
	}
}
