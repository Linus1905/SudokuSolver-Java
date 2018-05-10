package SudokuSolver;

import java.util.Scanner;

public class SudokuSolver { 
	
	static boolean solve(int i, int j, int Sudoku[][]) {
		
		if (i == 9 && j == 8) { 						
			return true; 
		}

		if (i == 9) { 
			i = 0;
			j++;
		}

		if (Sudoku[i][j] != 0) { 
			return solve(i + 1, j, Sudoku); 
		}

		for (int value = 1; value <= 9; value++) { 

			if (check(i, j, value, Sudoku) == true) { 
				Sudoku[i][j] = value; 
				if (solve(i + 1, j, Sudoku) == true)
					return true;

			}

		}
		Sudoku[i][j] = 0; 
		return false;
	}

	static boolean check(int i, int j, int value, int Sudoku[][]) {
		for (int k = 0; k < 9; k++) { 
			if (value == Sudoku[i][k])
				return false;
		}
		for (int k = 0; k < 9; k++) { 
			if (value == Sudoku[k][j])
				return false;
		}

		int n = i - (i % 3); 
		int m = j - (j % 3);
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (Sudoku[a + n][b + m] == value)
					return false;
			}
		}

		return true; 
	}

	public static void printSolution(int Sudoku[][]) { // Sudoku Ausgabe
		System.out.println("Lösung:");
		System.out.println();
		int x;
		int y;
		for (x = 0; x < Sudoku.length; x++) {
			if (x % 3 == 0)
				System.out.println("---------------------");

			for (y = 0; y < Sudoku.length; y++) {

				if (y % 3 == 0)
					System.out.print("|");
				System.out.print(Sudoku[x][y] + " ");

			}
			System.out.println();
		}
	}

	static int[][] readSudoku() {
		int Sudoku[][] = new int[9][9];

		Scanner sc = new Scanner(System.in); // Scanner zur Eingabe

		System.out.println("Input Numbers like this: 123456789");

		for (int m = 0; m < 9; m++) {
			String eingabe = sc.nextLine();
			for (int n = 0; n < 9; n++) {

				Sudoku[m][n] = eingabe.charAt(n) - '0'; 
			}
		}
		return Sudoku;
	}

	public static void main(String[] args) {

		
		  int Sudoku1[][] =
		  
		  new int[][] { 
			  { 0,5,0,0,0,0,0,0,0}, 
			  { 4,0,0,0,8,0,0,0,3}, 
			  { 0,0,0,0,2,5,0,0,0},
			  { 0,0,0,0,0,0,6,0,0},
			  { 0,1,0,0,0,2,0,0,0},
		      { 5,0,0,6,0,9,0,0,4},		  
		      { 0,0,0,2,0,0,7,3,0}, 
		      { 0,0,9,0,0,6,0,2,0}, 
		      { 7,2,8,0,0,0,0,1,0}};
		 

		int Sudoku2[][] = readSudoku(); 
		
		solve(0, 0, Sudoku1); 
		solve(0,0,Sudoku2);
		printSolution(Sudoku1);		
		printSolution(Sudoku2);
	}
}
