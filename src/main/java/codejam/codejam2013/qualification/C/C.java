package codejam.codejam2013.qualification.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class C {
	public static void main(String[] in) throws IOException {
		URL fileIn = C.class.getResource("C-small-attempt0.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			String[] line = reader.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);

			String outputLine = "Case #" + (t + 1) + ": " + result(a, b);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static int result(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			if (isPalindrome(i) && isPalindrome(Math.sqrt(i))) {
			
				count++;
			}
		}
		return count;
	}

	private static boolean isPalindrome(double d) {
		if (Math.floor(d) != Math.ceil(d)) {
			return false;
		}
		long l = (long) d;
		return (l + "").equals(new StringBuffer(l + "").reverse().toString());
	}
}
