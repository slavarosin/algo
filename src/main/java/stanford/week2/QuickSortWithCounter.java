package stanford.week2;

public class QuickSortWithCounter {
	protected static void swapInArray(final int[] n, final int i, final int j) {
		int tmp = n[i];
		n[i] = n[j];
		n[j] = tmp;
	}

	public int counter = 0;

	public QuickSortWithCounter(final int[] n) {
		sort(n, 0, n.length - 1);
	}

	protected int choosePivot(final int[] n, final int i, final int r) {
		return i;
	}

	protected int partition(final int[] n, final int p, final int r) {
		int i = p + 1;

		for (int j = i; j <= r; j++) {
			if (n[j] < n[p]) {
				swapInArray(n, i, j);
				i++;
			}
			counter++;
		}

		swapInArray(n, p, --i);

		return i;
	}

	protected void sort(final int[] n, final int i, final int r) {
		int p = choosePivot(n, i, r);

		if (p != i) {
			swapInArray(n, i, p);
			p = i;
		}

		p = partition(n, p, r);

		if (p - 1 - i > 0) {
			sort(n, i, p - 1);
		}

		if (r - (p + 1) > 0) {
			sort(n, p + 1, r);
		}
	}
}
