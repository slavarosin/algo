package codejam.codejam2010.round1A.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class B {
	private static long cost(int d, int i, int m, List<String> pixels) {
		long cost = 0;

		if (pixels.size() < 2) {
			return 0;
		}

		int prevP = -1;
		for (int j = 0; j < 2; j++) {
			int p = Integer.parseInt(pixels.get(j));

			long c = 0;
			if (prevP >= 0) {
				if (Math.abs(p - prevP) > m) {
					long ccost = Math.max(p, prevP) - (Math.min(p, prevP) + m);

					if (j + 1 < pixels.size()) {
						LinkedList<String> cpixels = new LinkedList<String>();
						cpixels.add((Math.min(p, prevP) + m) + "");
						cpixels.addAll(pixels.subList(j + 1, pixels.size()));
						ccost += cost(d, i, m, cpixels);
					}

					long dcost = d;
					if (j + 1 < pixels.size()) {
						LinkedList<String> dpixels = new LinkedList<String>();
						dpixels.add(prevP + "");
						dpixels.addAll(pixels.subList(j + 1, pixels.size()));
						dcost += cost(d, i, m, dpixels);
					}

					c = Math.min(ccost, dcost);

					if (m > 0) {
						long icost = (Math.abs(p - prevP) / m) * i;
						LinkedList<String> ipixels = new LinkedList<String>();
						ipixels.add(p + "");
						ipixels.addAll(pixels.subList(j + 1, pixels.size()));
						icost += cost(d, i, m, ipixels);

						c = Math.min(c, icost);
					}

					if (c == dcost) {
						j++;
					}
				}
			}

			cost += c;
			prevP = p;
		}

		return cost;
	}

	public static void main(String[] in) throws IOException {
		URL fileIn = B.class.getResource("B-small-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(B.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line1 = reader.readLine();
			String[] params = line1.split("\\s");

			int d = Integer.parseInt(params[0]);
			int i = Integer.parseInt(params[1]);
			int m = Integer.parseInt(params[2]);
			// int n = Integer.parseInt(params[3]);

			String line2 = reader.readLine();
			params = line2.split("\\s");

			List<String> p = new LinkedList<String>();
			for (String pix : params) {
				p.add(pix);
			}

			System.out.println(line1);
			System.out.println(line2);

			String outputLine = "Case #" + (t + 1) + ": " + cost(d, i, m, p);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}
}
