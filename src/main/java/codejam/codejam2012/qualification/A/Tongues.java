package codejam.codejam2012.qualification.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Tongues {
	private static Map<String, String> alfa = new HashMap<String, String>();

	private static String getTranslation(final String line) {
		String answer = "";

		for (int i = 0; i < line.length(); i++) {
			answer += alfa.get(line.charAt(i) + "");
		}

		return answer;
	}

	private static void initAlfa() {
		alfa.put(" ", " ");
		alfa.put("a", "y");
		alfa.put("b", "h");
		alfa.put("c", "e");
		alfa.put("d", "s");
		alfa.put("e", "o");
		alfa.put("f", "c");
		alfa.put("g", "v");
		alfa.put("h", "x");
		alfa.put("i", "d");
		alfa.put("j", "u");
		alfa.put("k", "i");
		alfa.put("l", "g");
		alfa.put("m", "l");
		alfa.put("n", "b");
		alfa.put("o", "k");
		alfa.put("p", "r");
		alfa.put("q", "z");
		alfa.put("r", "t");
		alfa.put("s", "n");
		alfa.put("t", "w");
		alfa.put("u", "j");
		alfa.put("v", "p");
		alfa.put("w", "f");
		alfa.put("x", "m");
		alfa.put("y", "a");
		alfa.put("z", "q");
	}

	public static void main(final String[] in) throws IOException {
		initAlfa();

		URL file = Tongues.class.getResource("A-small-attempt1.in");
		String path = file.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			System.out.println("Case #" + (t + 1) + ": " + getTranslation(reader.readLine()));
		}
	}
}
