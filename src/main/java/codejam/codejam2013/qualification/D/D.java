package codejam.codejam2013.qualification.D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D {
	public class Chase {
		public int keyToOpen;
		public int[] keysInside;
		boolean open;
	}

	private static List<String> solutions = new ArrayList<String>();
	private static List<Chase> chases = new ArrayList<Chase>();
	
	public static void main(String[] in) throws IOException {
		URL fileIn = D.class.getResource("sample.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(D.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			String[] params = reader.readLine().split(" ");
			int k = Integer.parseInt(params[0]);
			int n = Integer.parseInt(params[1]);
			
			params = reader.readLine().split(" ");
			Integer[] keys = new Integer[k];
			for (int i = 0; i < k; i++) {
				keys[i] = Integer.parseInt(params[i]);
			}
			
			for (int i = 0; i < n; i++) {
				params = reader.readLine().split(" ");
				
				Chase chase = (new D()).new Chase();
				chase.keyToOpen = Integer.parseInt(params[0]);
				int numOfKeysInside = Integer.parseInt(params[1]);
				chase.keysInside = new int[numOfKeysInside];
				for (int j = 0; i < numOfKeysInside; i++) {
					chase.keysInside[j] = Integer.parseInt(params[2 + j]);
				}
				chases.add(chase);
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(k, n, keys);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static String result(int k, int n, Integer[] keys) {
		open(new boolean[n], keys, "");
		
		if (solutions.isEmpty()) {		
			return "IMPOSSIBLE";
		}
		
		Collections.sort(solutions);
		return solutions.get(0);
	}

	private static void open(boolean[] opened, 
			Integer[] keys, String solution) {
		for (int key : keys) {
			solution = solution += " " + key;
			
			for (int c = 0; c < chases.size(); c++) {
				if (chases.get(c).keyToOpen != key) {
					continue;
				}
				
				opened[c] = true;
				if (isAllOpen(opened)) {
					solutions.add(solution.trim());
					return;
				}
				
				List<Integer> keysList = new ArrayList<Integer>();
				boolean removed = false;
				for (Integer k :keys) {
					if (k == key && !removed) {
						removed = true;
						continue;
					}
					keysList.add(k);
				}
				for (Integer k : chases.get(c).keysInside) {
					keysList.add(k);	
				}
				if (!keysList.isEmpty()) {
					open(opened, keysList.toArray(new Integer[keysList.size()]), solution);
				}
			}
		}
	}
	
	private static boolean isAllOpen(boolean[] opened) {
		for (boolean open : opened) {
			if (!open) {
				return false;
			}
		}
		return true;
	}
}
