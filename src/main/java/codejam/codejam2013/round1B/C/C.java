package codejam.codejam2013.round1B.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class C {
	private static Set<String> DICT = new HashSet<String>();
	
	public static void main(String[] in) throws IOException {
		readDictionary();
		
		URL fileIn = C.class.getResource("C-small-practice.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			String outputLine = "Case #" + (t + 1) + ": " + result(reader.readLine());
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static void readDictionary() throws IOException {
		URL fileIn = C.class.getResource("garbled_email_dictionary.txt");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String line;
		while ((line = reader.readLine()) != null) {
			DICT.add(line);
			buildPatterns(DICT, line, "");
		}
		
		reader.close();
	}

	private static String result(String input) {
		Set<String> patterns = new LinkedHashSet<String>();
		patterns.add(input);
		buildPatterns(patterns, input, "");
		
		List<String> p = new ArrayList<String>();
		p.addAll(patterns);
		
		Collections.sort(p, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return countStar(o1).compareTo(countStar(o2));
			}
		});
		
		for (String pattern : p) {
			if (reduce(pattern)) {
				return countStar(pattern);
			}
		}
		
		return "0";
	}

	private static String countStar(String s) {
		return s.replaceAll("[^\\.]", "").length() + "";
	}

	private static void buildPatterns(Set<String> patterns, String input,
			String prefix) {
		for (int j = 0; j < input.length(); j++) {
			String p = prefix + input.substring(0, j) + "." + input.substring(j + 1);
			patterns.add(p);
			
			if (j + 5 < input.length()) {
				buildPatterns(patterns, input.substring(j + 5), p.substring(0, j + 5));
			}
		}
	}
	
	private static boolean reduce(String pattern) {
		for (int j = 1; j < pattern.length() - 1; j++) {
			String subPattern1 = pattern.substring(0, j);
			String subPattern2 = pattern.substring(j);
			boolean m1 = findMatch(subPattern1);
			boolean m2 = findMatch(subPattern2);
			if (m1 && m2) {
				return true;
			}
			
			if (m1 && reduce(subPattern2)) {
//				System.out.println("match!" + pattern + " = " + subPattern1 + " + " + subPattern2);
				return true;
			}
			
			if (m2 && reduce(subPattern1)) {
//				System.out.println("match!" + pattern + " = " + subPattern1 + " + " + subPattern2);
				return true;
			}
		}
		
		return false;
	}
	
	static HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

	private static boolean findMatch(String pattern) {
		return DICT.contains(pattern);
	}
}
