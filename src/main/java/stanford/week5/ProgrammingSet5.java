package stanford.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class ProgrammingSet5 {
	HashSet<Integer> hashSet = new HashSet<Integer>();

	int[] targetSums = new int[] { 231552, 234756, 596873, 648219, 726312, 981237, 988331, 1277361, 1283379 };

	private String checkSums() {
		String answer = "";
		for (int sum : targetSums) {
			answer += isSumOfTwo(sum);
		}
		return answer;
	}

	private String isSumOfTwo(final int t) {
		Iterator<Integer> iter = hashSet.iterator();
		while (iter.hasNext()) {
			if (hashSet.contains(t - iter.next())) {
				return "1";
			}
		}

		return "0";
	}

	@Test
	public void programmingSet5() throws IOException {
		readArray();
		System.out.println(checkSums());
	}

	private void readArray() throws IOException {
		InputStream is = ProgrammingSet5.class.getResourceAsStream("HashInt.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String l = null;
		while ((l = reader.readLine()) != null) {
			hashSet.add(Integer.parseInt(l));
		}

		reader.close();
	}
}
