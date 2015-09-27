package codejam.codejam2013.qualification.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class A {
	private static final int BOARD_SIZE = 4;
	
	public static void main(String[] in) throws IOException {
		URL fileIn = A.class.getResource("A-large.in");
		String path = fileIn.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(A.class.getSimpleName() + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());
		for (int t = 0; t < numOfCases; t++) {
			String[] board = new String[BOARD_SIZE];
			
			int i = 0;
			while (i < BOARD_SIZE) {
				board[i] = reader.readLine();
				i++;
			}

			String outputLine = "Case #" + (t + 1) + ": " + result(board);
			System.out.println(outputLine);
			writer.write(outputLine + System.getProperty("line.separator"));
			reader.readLine();
		}

		reader.close();
		writer.close();
	}

	private static String result(String[] board) {
		boolean gameFinnished = true;
		for (int i = 0; i < BOARD_SIZE; i++) {
			String line = board[i];
			
			if (line.contains(".")) {
				gameFinnished = false;
			}
			
			String result = checkLine(line);
			if (result != null) {
				return result;
			}
			
			line = "" + board[0].charAt(i) + 
					board[1].charAt(i) + 
					board[2].charAt(i) + 
					board[3].charAt(i);
			result = checkLine(line);
			if (result != null) {
				return result;
			}
			
			line = "" + board[0].charAt(0) + 
					board[1].charAt(1) + 
					board[2].charAt(2) + 
					board[3].charAt(3);
			result = checkLine(line);
			if (result != null) {
				return result;
			}
			
			line = "" + board[0].charAt(3) + 
					board[1].charAt(2) + 
					board[2].charAt(1) + 
					board[3].charAt(0);
			result = checkLine(line);
			if (result != null) {
				return result;
			}
		}
		
		return gameFinnished ? "Draw" : "Game has not completed";
	}

	private static String checkLine(String line) {
		if (!line.contains(".") 
				&& !line.contains("O")) {
			return "X won";
		}
		
		if (!line.contains(".") 
				&& !line.contains("X")) {
			return "O won";
		}
		
		return null;
	}
}
