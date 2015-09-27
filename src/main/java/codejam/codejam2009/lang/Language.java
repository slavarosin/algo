package codejam.codejam2009.lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Language {
	public static void main(String[] in) throws IOException {
		URL file = Language.class.getResource("a.txt");
		String path = file.getFile();

		BufferedReader reader = new BufferedReader(new FileReader(path));

		String line = reader.readLine();
		String[] params = line.split("\\s");

		int l = Integer.parseInt(params[0]);
		int d = Integer.parseInt(params[1]);
		int n = Integer.parseInt(params[2]);

		List<String> dict = new LinkedList<String>();
		for (int i = 0; i < d; i++) {
			line = reader.readLine();
			dict.add(line);
		}

		for (int i = 0; i < n; i++) {
			String[] x = new String[l];

			String pattern = reader.readLine();
			boolean exact = true;
			String group = "";
			int xIndex = 0;
			for (int j = 0; j < pattern.length(); j++) {
				char c = pattern.charAt(j);
				if (c == '(') {
					exact = false;
					continue;
				}
				if (c == ')') {
					exact = true;
					x[xIndex] = group + "";
					xIndex++;
					group = "";
					continue;
				}

				if (exact) {
					x[xIndex] = c + "";
					xIndex++;
				} else {
					group += c;
				}
			}

			int w = 0;
			for (String word : dict) {
				boolean valid = true;

				for (int k = 0; k < l; k++) {
					String signal = x[k];
					char letter = word.charAt(k);
					if (!signal.contains(letter + "")) {
						valid = false;
					}
				}

				if (valid)
					w++;
			}

			System.out.println("Case #" + (i + 1) + ": " + w);
		}
	}
}
