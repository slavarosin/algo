package codejam.codejam2009.welcome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Welcome {
	// "welcome to code jam";
	static char[] s = new char[] { 'w', 'e', 'l', 'c', 'o', 'm', 'e', ' ', 't',
			'o', ' ', 'c', 'o', 'd', 'e', ' ', 'j', 'a', 'm' };

	public static void main(String[] in) throws IOException {
		URL file = Welcome.class.getResource("c-large.txt");
		String path = file.getFile();

		BufferedReader reader = new BufferedReader(new FileReader(path));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int p = 0; p < numOfCases; p++) {
			String line = reader.readLine();
			System.out.println("Case #" + (p + 1) + ": " + findWelcome(line));
		}
	}

	private static String findWelcome(String line) {
		String line2 = "";
		
		if (line == null)
			return "0000";

		while (line2.length() != line.length()) {
			line2 = reduce1(line);
			line = line2;
		}

		int i1 = line.indexOf(s[0]);
		int i2 = line.lastIndexOf(s[18]) + 1;

		if (line.length() < 19 | i1 < 0 | i2 < 0 | i2 < i1 | i2 > line.length()) {
			return "0000";
		}

		line = line.substring(i1, i2);

		int count = countSubSeq(line, s, 0, 0);

		String answer = count + "";
		for (int z = answer.length(); z < 4; z++) {
			answer = "0" + answer;
		}

		return answer;
	}

	private static String reduce1(String line) {
		String lineReduced = "";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			switch (c) {
			case 'w':
				lineReduced += c;
				break;
			case 'e':
				if (lineReduced.contains("w")) {
					lineReduced += c;
				}
				break;
			case 'l':
				if (lineReduced.contains("w") & lineReduced.contains("e")) {
					lineReduced += c;
				}
				break;
			case 'c':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l")) {
					lineReduced += c;
				}
				break;
			case 'o':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")) {
					lineReduced += c;
				}
				break;
			case 'm':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o")) {
					lineReduced += c;
				}
				break;
			case ' ':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o") & lineReduced.contains("m")) {
					lineReduced += c;
				}
				break;
			case 't':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o") & lineReduced.contains("m")
						& lineReduced.contains(" ")) {
					lineReduced += c;
				}
				break;
			case 'd':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o") & lineReduced.contains("m")
						& lineReduced.contains(" ") & lineReduced.contains("t")) {
					lineReduced += c;
				}
				break;
			case 'j':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o") & lineReduced.contains("m")
						& lineReduced.contains(" ") & lineReduced.contains("t")
						& lineReduced.contains("d")) {
					lineReduced += c;
				}
				break;
			case 'a':
				if (lineReduced.contains("w") & lineReduced.contains("e")
						& lineReduced.contains("l") & lineReduced.contains("c")
						& lineReduced.contains("o") & lineReduced.contains("m")
						& lineReduced.contains(" ") & lineReduced.contains("t")
						& lineReduced.contains("d") & lineReduced.contains("j")) {
					lineReduced += c;
				}
			}
		}
		return lineReduced;
	}

	private static int countSubSeq(String line, char[] s, int count, int index) {
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == s[index]) {
				if (index == 18) {
					count++;
					if (count > 9999) {
						count = 0;
					}
				} else {
					count = countSubSeq(line.substring(i + 1), s, count,
							index + 1);
				}
			}
		}

		return count;
	}
}
