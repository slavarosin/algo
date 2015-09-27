package codejam.codejam2010.practice7;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Cright {
	static FileWriter fw;

	static String insmall = "D-small-practice.in",
			outsmall = "Cright-small.out", inlarge = "Cright-large.in",
			outlarge = "Cright-large.out";

	static boolean small = true;

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		if (small) {
			in = new BufferedReader(new FileReader(insmall));
			fw = new FileWriter(outsmall);
		} else {
			in = new BufferedReader(new FileReader(inlarge));
			fw = new FileWriter(outlarge);
		}
		int N = new Integer(in.readLine());
		for (int cases = 1; cases <= N; cases++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int p = new Integer(st.nextToken());
			int c = new Integer(st.nextToken());
			long[] a = new long[p];
			for (int i = 0; i < a.length; i++) {
				a[i] = new Integer(st.nextToken());
			}
			fw.write("Case #" + cases + ": " + numGroups(c, a) + "\n");
		}
		fw.flush();
		fw.close();
	}

	public static long numGroups(int k, long[] a) {
		long l = 0, h = 1000000000000L;
		while (l < h) {
			long m = l + (h - l + 1) / 2, sum = 0;
			for (long x : a) {
				sum += min(m, x);
			}
			if (sum >= m * k) {
				l = m;
			} else {
				h = m - 1;
			}
		}
		return l;
	}
}