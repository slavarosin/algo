package codejam.codejam2010.practice5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class B {
	public static void main(String[] in) throws IOException {
		URL fileIn = B.class.getResource("Cright-large-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(B.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int n = Integer.parseInt(params[0]);
			int to = Integer.parseInt(params[1]) - 1;

			line = reader.readLine();
			int e = Integer.parseInt(line);

			int[] capacity = new int[n];
			int[] home = new int[n];
			int[][] cars = new int[n][e];

			int i = 0;
			do {
				line = reader.readLine();
				params = line.split("\\s");

				int h = Integer.parseInt(params[0]);
				int p = Integer.parseInt(params[1]);

				capacity[h - 1] += p;
				home[h - 1]++;
				cars[h - 1][i] = p;

				i++;
			} while (i < e);

			// for (int j = 0; j < home.length; j++) {
			// System.out.println("h" + j + "=" + home[j]);
			// }
			//
			// for (int j = 0; j < capacity.length; j++) {
			// System.out.println("capacity" + j + "=" + capacity[j]);
			// }

			String outputLine = "Case #" + (t + 1) + ": "
					+ result(to, capacity, home, cars);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int to, int[] capacity, int[] home,
			int[][] cars) {
		String res = "";

		for (int i = 0; i < home.length; i++) {
			if (i == to) {
				res += " " + 0;
				continue;
			}

			if ((home[i] > capacity[i])) {
				return "IMPOSSIBLE";
			}

			int[] c = cars[i];

			Arrays.sort(c);

			int numOfCars = 0;
			int p = home[i];
			if (p > 0) {
				for (int j = c.length - 1; j >= 0; j--) {
					p -= c[j];
					numOfCars++;

					if (p <= 0) {
						break;
					}
				}
			}

			res += " " + numOfCars;
		}

		return res.trim();
	}
}
