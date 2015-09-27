package codejam.codejam2010.round3A.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class B {
	public static void main(String[] in) throws IOException {
		URL fileIn = B.class.getResource("B-small-attempt0.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(B.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line1 = reader.readLine();
			String[] params = line1.split("\\s");

			int n = Integer.parseInt(params[0]);
			long k = Long.parseLong(params[1]);
			long b = Long.parseLong(params[2]);
			long tt = Long.parseLong(params[3]);

			String pos = reader.readLine();
			String[] xs = pos.split("\\s");
			long[] x = new long[n];
			for (int i = 0; i < x.length; i++) {
				x[i] = Long.parseLong(xs[i]);
			}

			String speed = reader.readLine();
			String[] vs = speed.split("\\s");
			long[] v = new long[n];
			for (int i = 0; i < v.length; i++) {
				v[i] = Long.parseLong(vs[i]);
			}

			String outputLine = "Case #" + (t + 1) + ": "
					+ result(k, b, tt, x, v);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(long k, long b, long t, long[] xs, long[] vs) {
		long minswap = -1;

		long[] sxs = Arrays.copyOf(xs, xs.length);
		long[] svs = Arrays.copyOf(vs, vs.length);

		long swamp = simulate(k, b, t, sxs, svs, -1);
		if (swamp == -1) {
			return "IMPOSSIBLE";
		}

		if (swamp == 0) {
			return "0";
		}

		minswap = swamp;
		long swapAvailable = swamp;

		do {
			swapAvailable--;
			swamp = simulate(k, b, t, Arrays.copyOf(xs, xs.length), Arrays
					.copyOf(vs, vs.length), swapAvailable);
			if (swamp == -1) {
				return minswap + "";
			}

			minswap = swamp;
		} while (swapAvailable > 0);

		return minswap + "";
	}

	private static long simulate(long k, long b, long t, long[] xs, long[] vs,
			long swapAvailable) {
		long swap = 0;

		long[] vst = new long[vs.length];
		for (int j = 0; j < vst.length; j++) {
			vst[j] = vs[j];
		}

		boolean moveDone = false;
		for (int i = 0; i < t; i++) {
			long reached = 0;
			for (long x : xs) {
				if (x >= b) {
					reached++;
				}
			}

			if (reached >= k) {
				return swap;
			}

			if (!moveDone) {
				for (int j = 0; j < xs.length; j++) {
					xs[j] += vst[j];
				}
			}

			for (int j = 0; j < vst.length; j++) {
				vst[j] = vs[j];
			}

			for (int j = 0; j < xs.length; j++) {
				List<Integer> g = new LinkedList<Integer>();
				if (j + 1 == xs.length) {
					break;
				}
				for (int z = j + 1; z < xs.length; z++) {
					if ((j != z) && (xs[j] == xs[z])) {
						g.add(j);
						g.add(z);
					}
				}

				if (!g.isEmpty()) {
					long mspeed = -1;

					if ((swapAvailable == -1) || (swap < swapAvailable)) {
						swap++;

						long vmax = Long.MIN_VALUE;
						for (Integer z : g) {
							if (vs[z] > vmax) {
								vmax = vs[z];
								mspeed = z;
							}
						}
					}

					long vmin = Long.MAX_VALUE;
					for (Integer z : g) {
						vmin = Math.min(vmin, vs[z]);
					}

					for (Integer z : g) {
						if (z != mspeed) {
							xs[z] += vmin;
						} else {
							xs[z] += vs[z];
						}
					}
					moveDone = true;
				} else {
					moveDone = false;
				}
			}
		}

		long reached = 0;
		for (long x : xs) {
			if (x >= b) {
				reached++;
			}
		}

		if (reached >= k) {
			return swap;
		}

		return -1;
	}

	// private static String result(long k, long b, long t, long[] xs, long[]
	// vs) {
	// int nl = 0;
	// int no = 0;
	// int ns = 0;
	// int n = xs.length;
	//
	// for (int i = n - 1; i >= 0; i--) {
	// if (b - xs[i] <= vs[i] * t) {
	// no++;
	// ns += nl;
	// if (no == k) {
	// break;
	// }
	// } else {
	// nl++;
	// }
	// }
	// if (no == k) {
	// return ns + "";
	// }
	//
	// return "IMPOSSIBLE";
	// }
}
