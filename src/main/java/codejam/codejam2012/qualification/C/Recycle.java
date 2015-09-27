package codejam.codejam2012.qualification.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

public class Recycle {
	private static int a = 0;

	private static int b = 0;

	private static boolean debug = false;

	static HashSet<String> set = new HashSet<String>();

	public static void main(String[] in) throws IOException {
		String fileName = "C-large.in";
		URL file = Recycle.class.getResource(fileName);
		String path = file.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(fileName + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		long tt = System.currentTimeMillis();
		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();

			String outputLine = "Case #" + (t + 1) + ": " + result(line);

			if (debug) {
				System.out.println(outputLine);
			}

			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();

		System.out.println("Took: " + (System.currentTimeMillis() - tt) + "ms");
	}

	private static int result(String line) {
		String[] params = line.split("\\s");
		a = Integer.parseInt(params[0]);
		b = Integer.parseInt(params[1]);

		set.clear();
		for (int i = a; i <= b; i++) {
			String s = i + "";

			for (int j = 0; j < s.length(); j++) {
				String m = s.substring(j) + s.substring(0, j);
				Integer p = Integer.parseInt(m);

				if ((p >= a) && (p <= b) && (p > i)) {
					set.add(s + m);
				}
			}
		}

		return set.size();
	}
}
