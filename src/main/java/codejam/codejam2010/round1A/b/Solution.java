package codejam.codejam2010.round1A.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		new Solution();
	}

	final String f = "B-small-practice";
	private BufferedReader in;
	private PrintWriter out;

	private StringTokenizer st;

	Solution() throws IOException {
		in = new BufferedReader(new FileReader(f + ".in"));
		out = new PrintWriter(f + ".out");

		eat("");

		int tests = nextInt();
		for (int test = 0; test < tests; ++test) {
			System.out.println("Test #" + (test + 1));
			out.print("Case #" + (test + 1) + ": ");
			solve();
		}

		in.close();
		out.close();
	}

	private void eat(String str) {
		st = new StringTokenizer(str);
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	void solve() throws IOException {
		int D = nextInt();
		int I = nextInt();
		int m = nextInt();
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		int[] d = new int[256];
		for (int i = 0; i < n; ++i) {
			int[] t = new int[256];
			Arrays.fill(t, Integer.MAX_VALUE);
			for (int u = 0; u < 256; ++u) {
				t[u] = Math.min(t[u], d[u] + D);
				for (int v = 0; v < 256; ++v) {
					if (Math.abs(u - v) <= m) {
						t[v] = Math.min(t[v], d[u] + Math.abs(v - a[i]));
					}
				}
			}
			if (m != 0) {
				for (int u = 0; u < 256; ++u) {
					for (int v = 0; v < 256; ++v) {
						t[v] = Math.min(t[v], t[u]
								+ ((Math.abs(u - v) + m - 1) / m) * I);
					}
				}
			}
			d = t;
		}
		int ans = Integer.MAX_VALUE;
		for (int u = 0; u < 256; ++u) {
			ans = Math.min(ans, d[u]);
		}
		out.println(ans);
	}
}
