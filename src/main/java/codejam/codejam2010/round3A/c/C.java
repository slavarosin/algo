package codejam.codejam2010.round3A.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class C {
	private static boolean isBoardRow(int start, boolean[] row) {
		if ((start == -1) || (new Boolean(start == 1).booleanValue() != row[0])) {
			Boolean prev = null;
			for (boolean b : row) {
				if ((prev == null) || (prev != b)) {
					prev = b;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] in) throws IOException {
		URL fileIn = C.class.getResource("sample.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(C.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] ps = line.split("\\s");

			int m = Integer.parseInt(ps[0]);
			int n = Integer.parseInt(ps[1]);

			boolean[][] board = new boolean[m][n];

			int i = 0;
			while (i < m) {
				String l = reader.readLine();
				l = Integer.toString(Integer.parseInt(l, 16), 2);
				while (l.length() < n) {
					l = "0" + l;
				}

				// System.out.println(l);
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = (l.charAt(j) != '0');
				}

				i++;
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(n, m, board);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int n, int m, boolean[][] board) {
		String result = "";
		Map<Integer, Integer> cut = new TreeMap<Integer, Integer>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					};
				});
		int bsize = Math.min(n, m);

		boolean[][] cutted = new boolean[m][n];

		int i1 = 0, i2 = 0;

		while (bsize >= 2) {
			i2 = i1 + bsize;
			int r = 0;

			do {
				while (i2 < n + 1) {
					int j = r;

					boolean cuttedB = false;
					for (int ii = i1; ii < Math.min(i1 + bsize, m); ii++) {
						for (int jj = r; jj < Math.min(r + bsize, n); jj++) {
							if (cutted[jj][ii]) {
								cuttedB = true;
								break;
							}
						}
					}

					if (!cuttedB) {
						int start = -1;
						boolean[] row = Arrays.copyOfRange(board[j], i1, i2);

						int c = 0;
						while (isBoardRow(start, row) & (j + bsize - 1 <= m)
								& (j - r < bsize)) {
							c++;
							start = row[0] ? 1 : 0;

							j++;
							if (j >= m) {
								break;
							}
							row = Arrays.copyOfRange(board[j], i1, i2);
						}

						if (c >= bsize) {
							Integer count = cut.get(bsize);
							if (count == null) {
								count = 1;
							} else {
								count++;
							}
							cut.put(bsize, count);

							for (int ii = i1; ii < i1 + bsize; ii++) {
								for (int jj = r; jj < Math.min(j, n); jj++) {
									cutted[jj][ii] = true;
								}
							}

							for (int ii = 0; ii < m; ii++) {
								for (int jj = r; jj < n; jj++) {
									if (cutted[ii][jj]) {
										System.out.print(" ");
									} else {
										System.out.print(board[ii][jj] ? "1"
												: "0");
									}
								}
								System.out.println("");
							}
							System.out.println("~");
						}
					}

					i1++;
					i2 = i1 + bsize;
				}
				i1 = 0;
				i2 = i1 + bsize;
				r++;
			} while (r + bsize - 1 < m);

			bsize--;
		}

		int uncutted = 0;
		for (boolean[] c : cutted) {
			for (boolean c1 : c) {
				if (!c1) {
					uncutted++;
				}
			}
		}
		cut.put(1, uncutted);

		result += cut.size();
		for (Entry<Integer, Integer> c : cut.entrySet()) {
			if (c.getValue() > 0) {
				result += System.getProperty("line.separator") + c.getKey()
						+ " " + c.getValue();
			}
		}

		return result;
	}
}
