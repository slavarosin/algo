package stanford.week2;

public class QuickSortWithCounterPivotMedian extends QuickSortWithCounter {
	public QuickSortWithCounterPivotMedian(final int[] n) {
		super(n);
	}

	@Override
	protected int choosePivot(final int[] n, final int i, final int r) {
		int m = i + (r - i) / 2;

		int first = n[i];
		int last = n[r];
		int middle = n[m];

		int min = Math.min(Math.min(first, last), middle);
		int max = Math.max(Math.max(first, last), middle);

		if (middle != min && middle != max) {
			return m;
		}

		if (last != min && last != max) {
			return r;
		}

		return i;
	}
}
