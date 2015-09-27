package stanford.week2;

import static java.lang.Integer.parseInt;
import static junit.framework.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class ProgrammingSet2 {
	private static int[] readArray() throws IOException {
		InputStream is = ProgrammingSet2.class.getResourceAsStream("QuickSort.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		int len = 10000;
		int[] n = new int[len];

		for (int i = 0; i < len; i++) {
			n[i] = parseInt(reader.readLine());
		}

		reader.close();

		return n;
	}

	@Test
	public void test() throws IOException {
		assertEquals(162085, new QuickSortWithCounter(readArray()).counter);
		assertEquals(164123, new QuickSortWithCounterPivotLast(readArray()).counter);

		assertEquals(1, new QuickSortWithCounterPivotMedian(new int[] { 4, 5, 6, 7 }).choosePivot(new int[] { 4, 5, 6,
				7 }, 0, 3));
		assertEquals(
				4,
				new QuickSortWithCounterPivotMedian(new int[] { 0, 1, 2, 3, 4, 5 }).choosePivot(new int[] { 0, 1, 2, 3,
						4, 5 }, 3, 5));
		assertEquals(
				0,
				new QuickSortWithCounterPivotMedian(new int[] { 4, 1, 5, 6, 3, 2 }).choosePivot(new int[] { 4, 1, 5, 6,
						3, 2 }, 0, 5));

		assertEquals(8, (new QuickSortWithCounterPivotMedian(new int[] { 4, 1, 5, 6, 3, 2 })).counter);
		assertEquals(13, (new QuickSortWithCounterPivotMedian(new int[] { 3, 8, 2, 5, 1, 4, 7, 6 })).counter);
		assertEquals(138382, new QuickSortWithCounterPivotMedian(readArray()).counter);
	}
}
