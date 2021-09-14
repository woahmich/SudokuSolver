/**
 * Sudoku Solver
 */

import java.util.Stack;
import java.awt.Font;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {


	/**
	 * Print a grid to the console
	 * 
	 * @param grid
	 */
	public void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j< grid.length; j++) {

				if (grid[i][j] == 0) {
					System.out.print(". "); 
				}
				else {
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println();
		}

		System.out.println();
	}


	/**
	 * Create a new grid that is a copy of the input grid with value i at position (r, c)
	 * 
	 * @param grid
	 * @param r
	 * @param c
	 * @param value
	 * 
	 * @return the new grid
	 */
	public int[][] createNewGrid(int[][] grid, int r, int c, int value) {
		int[][] newGrid = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newGrid[i][j] = grid[i][j]; 
			}
		}
		newGrid[r][c] = value;
		return newGrid;
	}


	/**
	 * Test if it is possible to place the given value at position (r, c) of the input grid
	 * 
	 * @param value
	 * @param grid
	 * @param r
	 * @param c
	 * 
	 * @return true if the assignment is possible, false otherwise
	 */
	public boolean isValid(int value, int[][] grid, int r, int c) {

		for (int i = 0; i < r; i++) {
			if (grid[i][c] == value) {
				printGrid(grid);
				System.out.println("test 1");
				return false;
			}
		}
		for (int i = r + 1; i < 9; i++) {
			if (grid[i][c] == value) {
				printGrid(grid);
				System.out.println("test 2");
				return false;
			}
		}
		for (int i = 0; i < c; i++) {
			if (grid[r][i] == value) {
				printGrid(grid);
				System.out.println("test 3");
				return false;
			}
		}
		for (int i = c + 1; i < 9; i++) {
			if (grid[r][i] == value) {
				printGrid(grid);
				System.out.println("test 4");
				return false;
			}
		}
		
		int square_upper_left_row = 0;
	    int square_upper_left_col = 0;
		
		// Upper left 3x3 square
		// row and col are both in the range 0 to 2
		if (r < 3 && c < 3) {
		    square_upper_left_row = 0;
		    square_upper_left_col = 0;
		}

		// Lower right 3x3 square
		if (r > 5 && c > 5) {
		    square_upper_left_row = 6;
		    square_upper_left_col = 6;
		}
		
		//upper right 3x3 square
		if (r < 3 && c > 5) {
		    square_upper_left_row = 0;
		    square_upper_left_col = 6;
		}
		
		//lower left 3x3 square
		if (r > 5 && c < 3) {
		    square_upper_left_row = 6;
		    square_upper_left_col = 0;
		}
		
		//middle 3x3 square
		if ((r > 2 && r < 6) && (c > 2 && c < 6)) {
		    square_upper_left_row = 3;
		    square_upper_left_col = 3;
		}
		
		//top middle 3x3 square
		if (r < 3 && (c > 2 && c < 6)) {
		    square_upper_left_row = 0;
		    square_upper_left_col = 6;
		}
		
		//bottom middle 3x3 square
		if (r > 5 && (c > 2 && c < 6)) {
		    square_upper_left_row = 6;
		    square_upper_left_col = 3;
		}
		
		//left middle 3x3 square
		if ((r > 2 && r < 6) && c < 3) {
		    square_upper_left_row = 3;
		    square_upper_left_col = 0;
		}
		
		// right middle 3x3 square
		if ((r > 2 && r < 6) && c > 5) {
		    square_upper_left_row = 3;
		    square_upper_left_col = 6;
		}
		
		for (int x = square_upper_left_row; x < square_upper_left_row + 3; x++) {
		    for (int y = square_upper_left_col; y < square_upper_left_col + 3; y++) {
		        if (grid[x][y] == value && (x != r && y != c)) {
		        	printGrid(grid);
		        	System.out.println("test 5");
		        	return false;
		        }
		    }
		}

		
		printGrid(grid); 
		System.out.println("true");
		return true;
			}



	/**
	 * Find a solution to the Sudoku puzzle using iterative backtracking search
	 * 
	 * @param grid  the initial grid that begins the search
	 */
	public void solve(int[][] grid) {

		// Create a new stack and push the input grid onto it
		//
		// Note: int[][] is an object, so it can be used as the Stack's data type
		Stack<int[][]> stack = new Stack<int[][]>();
		stack.push(grid);

		

		while (!stack.empty()) {

			// Pop the current grid from the top of the stack
			grid = stack.pop();	
			
			
			// Find the next empty square on the current grid
			
			
			// If there are no empty squares, the search is complete
			// Print the solution and return
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
			// Test each of the nine digits on the chosen empty square
				int k = 1;
					if (grid[x][y] == 0) {
						while (k < 10) {
							grid[x][y] = k;
							if (isValid(k, grid, x, y) == true) {
								createNewGrid(grid, x, y, k);
								break;
							}
							k++;
								
										}
									}
									}
								}
							}
						

					
				
				
			
				// If it's possible to put i at position (r,c) on the grid, add it 
				// to the stack as a new search state
				//
				// Use createNewGrid to get a copy of the current grid with value i 
				// assigned to position (r,c)
				
			


		printGrid(grid);
	}



	/**
	 * Solve the file of 95 hard puzzles
	 * 
	 * This is just for fun: you don't have to complete it to get credit
	 */
	public void solveHardSudoku() {

		try {
			Scanner file = new Scanner(new File("hard_sudoku.txt"));

			while (file.hasNext()) {

				String s = file.nextLine();

				int[][] input = new int[9][9];
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (s.charAt(i * 9 + j) == '.') 
							input[i][j] = 0;
						else
							input[i][j] = Character.getNumericValue(s.charAt(i * 9 + j));
					}
				}

				solve(input);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
	}


	/**
	 * Main: solve one example puzzle
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = {{5,3,0,0,7,0,0,0,0},
						 {6,0,0,1,9,5,0,0,0},
						 {0,9,8,0,0,0,0,6,0},
						 {8,0,0,0,6,0,0,0,3},
						 {4,0,0,8,0,3,0,0,1},
						 {7,0,0,0,2,0,0,0,6},
						 {0,6,0,0,0,0,2,8,0},
						 {0,0,0,4,1,9,0,0,5},
						 {0,0,0,0,8,0,0,7,9} };


		Sudoku solver = new Sudoku();
		solver.solve(input);

		// Uncomment the next line to try the hard puzzles
		//solver.solveHardSudoku();
	}

}