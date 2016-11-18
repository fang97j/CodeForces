package Solved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No7A {
	// Solved.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[8][8];
		int noRows = 0;
		int noColumns = 0;
		
		for (int i = 0; i < 8; i++) {
			String line = sc.next();
			for (int j = 0; j < 8; j++)	 {
				board[i][j] = line.charAt(j);
			}
			if (line.equals("BBBBBBBB")) {
				noRows++;
			}
		}
		
		// Check columns
		for (int y = 0; y < 8; y++) {
			int noB = 0;
			for (int x = 0; x < 8; x++) {
				if (board[x][y] == 'B') {
					noB++;
				}
			}
			if (noB == 8) {
				noColumns++;
			}
		}
		
		if (noRows == 8) {
			System.out.println(8);
		}
		else {
			System.out.println((noRows + noColumns));
		}
	}
}
