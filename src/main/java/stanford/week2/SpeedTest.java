package stanford.week2;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import stanford.week1.ProgrammingSet1;

public class SpeedTest {

	public static void main(final String[] args) throws IOException {
		int[] n = readArrayToSort();
		long t = System.currentTimeMillis();
		Arrays.sort(n);
		out.println("Answer in " + (System.currentTimeMillis() - t) + "ms");

		// n = readArrayToSort();
		t = System.currentTimeMillis();
		new QuickSortWithCounter(n);
		out.println("Answer in " + (System.currentTimeMillis() - t) + "ms");
		// out.println(Arrays.toString(n));

		n = readArrayToSort();
		t = System.currentTimeMillis();
		ProgrammingSet1.invCount(n);
		out.println("Answer in " + (System.currentTimeMillis() - t) + "ms");
	}

	private static int[] readArrayToSort() throws IOException {
		InputStream is = SpeedTest.class.getResourceAsStream("IntegerArray.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		int len = 100000;
		int[] n = new int[len];

		for (int i = 0; i < len; i++) {
			n[i] = parseInt(reader.readLine());
		}

		reader.close();

		// Test
		n = Arrays.copyOfRange(n, 0, len); // new int[] { 3, 8, 2, 5, 1, 4,
											// 7, 6 };
		return n;
	}
}
