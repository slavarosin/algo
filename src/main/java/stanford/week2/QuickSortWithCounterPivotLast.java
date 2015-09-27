package stanford.week2;

public class QuickSortWithCounterPivotLast extends QuickSortWithCounter {
	public QuickSortWithCounterPivotLast(final int[] n) {
		super(n);
	}

	@Override
	protected int choosePivot(final int[] n, final int i, final int r) {
		return r;
	}
}
