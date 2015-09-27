package codejam.codejam2010.round1A.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class A {
	private static boolean checkWin(int[][] g, int p, int k) {
		int n = g.length;

		for (int i = 0; i < n; i++) {
			int win = 0;
			for (int j = 0; j < n; j++) {
				if (g[i][j] == p) {
					win++;
					if (win == k) {
						return true;
					}
				} else {
					win = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int win = 0;
			for (int j = 0; j < n; j++) {
				if (g[j][i] == p) {
					win++;
					if (win == k) {
						return true;
					}
				} else {
					win = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = i;
				int b = j;

				while ((a > 0) && (b > 0)) {
					a--;
					b--;
				}

				int win = 0;
				while ((a < n) && (b < n)) {
					if (g[a][b] == p) {
						win++;
						if (win == k) {
							return true;
						}
					} else {
						win = 0;
					}

					a++;
					b++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = i;
				int b = j;

				while ((a < n - 1) && (b > n)) {
					a++;
					b--;
				}

				int win = 0;
				while ((a >= 0) && (b < n)) {
					if (g[a][b] == p) {
						win++;
						if (win == k) {
							return true;
						}
					} else {
						win = 0;
					}

					a--;
					b++;
				}
			}
		}

		return false;
	}

	public static void main(String[] in) throws IOException {
		URL fileIn = A.class.getResource("B-large.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(A.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();
			String[] params = line.split("\\s");

			int n = Integer.parseInt(params[0]);
			int k = Integer.parseInt(params[1]);

			String[] board = new String[n];
			int i = 0;
			while (i < n) {
				board[i] = reader.readLine();
				i++;
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(n, k, board);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int n, int k, String[] board) {
		int[][] b = new int[n][n];
		int[][] r = new int[n][n];
		int[][] g = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = board[i];

			for (int j = 0; j < n; j++) {
				b[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int ii = j;
				int jj = i;

				jj = n - jj - 1;

				r[ii][jj] = b[i][j];
			}
		}

		// System.out.println("R ---");
		//
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print((r[i][j] == 46) || (r[i][j] == 0) ? "0"
		// : r[i][j] == 82 ? "R" : "B");
		// }
		// System.out.println("");
		// }

		for (int j = 0; j < n; j++) {
			int gi = n - 1;
			for (int i = n - 1; i >= 0; i--) {
				if (r[i][j] != 46) {
					g[gi][j] = r[i][j];
					gi--;
				}
			}
		}

		// System.out.println("G ---");
		//
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print((g[i][j] == 46) || (g[i][j] == 0) ? "0"
		// : g[i][j] == 82 ? "R" : "B");
		// }
		// System.out.println("");
		// }

		String result = "Neither";

		if (checkWin(g, 82, k)) {
			result = "Red";
		}

		if (checkWin(g, 66, k)) {
			if (result.equals("Red")) {
				result = "Both";
			} else {
				result = "Blue";
			}
		}

		return result;
	}
}
