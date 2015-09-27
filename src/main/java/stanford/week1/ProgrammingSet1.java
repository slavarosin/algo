package stanford.week1;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static java.util.Arrays.copyOfRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProgrammingSet1 {
	// Right answer: 2407905288

	public static long invCount(final int[] whole) {
		int len = whole.length;

		if (len < 2) {
			return 0;
		}

		int m = len / 2;
		int left[] = copyOfRange(whole, 0, m);
		int right[] = copyOfRange(whole, m, len);

		return invCount(left) + invCount(right) + merge(whole, left, right);
	}

	public static void main(final String[] args) throws IOException {
		InputStream is = ProgrammingSet1.class.getResourceAsStream("IntegerArray.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		int len = 100000;
		int[] n = new int[len];

		for (int i = 0; i < len; i++) {
			n[i] = parseInt(reader.readLine());
		}

		reader.close();

		// Test
		// n = new int[] { 2, 27, 28, 38, 3, 43, 11, 1 };

		out.println("Answer: " + invCount(n));
	}

	static long merge(final int[] whole, final int[] left, final int[] right) {
		long count = 0;
		int i = 0, j = 0;

		while (i + j < whole.length) {
			if (i == left.length) {
				whole[i + j] = right[j];
				j++;
			} else if (j == right.length || left[i] <= right[j]) {
				whole[i + j] = left[i];
				i++;
			} else {
				whole[i + j] = right[j];
				j++;

				count += left.length - i;
			}
		}

		return count;
	}
}
