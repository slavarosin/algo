package codejam.codejam2010.qualification.park;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

public class Park {
	private static String countEuros(double r, double k, double n,
			String[] groups) {
		double euro = 0;

		Queue<Double> queue = new LinkedList<Double>();
		double people = 0;
		for (int i = 0; i < n; i++) {
			double g = Double.parseDouble(groups[i]);
			queue.add(g);

			people += g;
		}

		double j = 1;
		do {
			double p = 0;

			do {
				double g = queue.poll();
				p += g;

				queue.add(g);
			} while ((queue.peek() <= (k - p)) & (p < people));

			euro += p;
			j++;
		} while (j <= r);

		String answer = (euro + "");
		int ind = answer.indexOf(".");
		if (ind > 0) {
			answer = answer.substring(0, ind);
		}

		return answer;
	}

	public static void main(String[] in) throws IOException {
		URL file = Park.class.getResource("Cright-large.in");
		String path = file.getFile();

		BufferedReader reader = new BufferedReader(new FileReader(path));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int r = Integer.parseInt(params[0]);
			int k = Integer.parseInt(params[1]);
			int n = Integer.parseInt(params[2]);

			line = reader.readLine();
			System.out.println("Case #" + (t + 1) + ": "
					+ countEuros(r, k, n, line.split("\\s")));
		}
	}
}
