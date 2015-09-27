package codejam.codejam2010.round2A.a;

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
	private static boolean folderExists(List<String> dirE, String folderPathC) {
		if (folderPathC.equals("/") || folderPathC.equals("//")) {
			return true;
		}

		return dirE.contains(folderPathC);
	}

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
			String[] params = line.split("\\s");

			int n = Integer.parseInt(params[0]);
			int m = Integer.parseInt(params[1]);

			List<String> dirsE = new LinkedList<String>();

			int i = 0;
			while (i < n) {
				String p = reader.readLine();
				String[] pathes = p.split("/");

				String pa = "/";
				for (String e : pathes) {
					pa += e + "/";
					dirsE.add(pa);
				}

				i++;
			}

			List<String> dirsC = new LinkedList<String>();
			i = 0;
			while (i < m) {
				String p = reader.readLine();
				String[] pathes = p.split("/");

				String pa = "/";
				for (String e : pathes) {
					pa += e + "/";
					dirsC.add(pa);
				}

				i++;
			}

			String outputLine = "Case #" + (t + 1) + ": "
					+ result(n, m, dirsE, dirsC);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static int result(int n, int k, List<String> dirE, List<String> dirC) {
		int mkdir = 0;

		for (String d : dirC) {
			if (folderExists(dirE, d)) {
				continue;
			}

			dirE.add(d);
			mkdir++;
		}

		return mkdir;
	}
}
