package codejam.codejam2010.practice3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class C {
	private static Map<String, String> mapping = new HashMap<String, String>();

	public static void main(String[] in) throws IOException {
		URL fileIn = C.class.getResource("Cright-large-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		mapping.put("a", "2");
		mapping.put("b", "22");
		mapping.put("c", "222");
		mapping.put("d", "3");
		mapping.put("e", "33");
		mapping.put("f", "333");
		mapping.put("g", "4");
		mapping.put("h", "44");
		mapping.put("i", "444");
		mapping.put("j", "5");
		mapping.put("k", "55");
		mapping.put("l", "555");
		mapping.put("m", "6");
		mapping.put("n", "66");
		mapping.put("o", "666");
		mapping.put("p", "7");
		mapping.put("q", "77");
		mapping.put("r", "777");
		mapping.put("s", "7777");
		mapping.put("t", "8");
		mapping.put("u", "88");
		mapping.put("v", "888");
		mapping.put("w", "9");
		mapping.put("x", "99");
		mapping.put("y", "999");
		mapping.put("z", "9999");
		mapping.put(" ", "0");

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();

			String outputLine = "Case #" + (t + 1) + ": " + result(line);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(String line) {
		String number = "";

		for (int i = 0; i < line.length(); i++) {
			String n = mapping.get(line.charAt(i) + "");

			if (number.endsWith(n.charAt(0) + "")) {
				number += " " + n;
			} else {
				number += n;
			}
		}

		return number.trim();
	}
}
