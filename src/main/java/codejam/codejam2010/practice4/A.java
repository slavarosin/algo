package codejam.codejam2010.practice4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

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
			String line = reader.readLine();
			line = reader.readLine();

			String[] params = line.split("\\s");

			String outputLine = "Case #" + (t + 1) + ": " + result(params);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(String[] params) {
		List<String> alone = new LinkedList<String>();

		for (String invitation : params) {
			if (alone.contains(invitation)) {
				alone.remove(invitation);
			} else {
				alone.add(invitation);
			}
		}

		return alone.get(0);
	}
}
