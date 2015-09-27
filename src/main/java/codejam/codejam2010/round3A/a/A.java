package codejam.codejam2010.round3A.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class A {
	public static void main(String[] in) throws IOException {
		URL fileIn = A.class.getResource("A-large.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(A.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();

			int n = Integer.parseInt(line);

			int i = 0;
			int[] a = new int[n];
			int[] b = new int[n];

			while (i < n) {
				String p = reader.readLine();
				String[] ps = p.split("\\s");

				a[i] = Integer.parseInt(ps[0]);
				b[i] = Integer.parseInt(ps[1]);

				i++;
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(a, b);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int[] a, int[] b) {
		int res = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i] < a[j]) && (b[i] > b[j])) {
					res++;
				}
			}
		}

		return res + "";
	}
}
