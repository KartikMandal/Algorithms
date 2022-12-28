package com.kartik.org;

public class MatrixSudokoSolver {

	private static int NUM_ROWS=9;
	private static int NUM_COLS=9;
	/* Helper function which checks if it is possible to place a number in a cell
	grid: the 2d sudoku matrix
	rowNr: row number of the cell we are checking
	colNr: column number of the cell we are checking
	num: the number which we want to place in the cell
	Returns: true if we can place num in the cell, false otherwise
	*/
	public static boolean canFillCell(int[][] grid, int rowNr, int colNr, int num) {
	 
	    /*Ensure that the number is not present in any row of requested column*/
	    int i, j;
	    for (i = 0; i < NUM_ROWS; ++i)
	        if (grid[i][colNr] == num)
	            return false;
	 
	    /*Ensure that the number is not present in any column of requested row*/
	    for (j = 0; j < NUM_COLS; ++j)
	        if (grid[rowNr][j] == num)
	            return false;
	 
	    /*Ensure that the number is not present in the 3*3 box it belongs to*/
	    int regionStartRow = (rowNr / 3) * 3;
	    int regionStartCol = (colNr / 3) * 3;
	
	    for (i = regionStartRow; i < regionStartRow + 3; ++i)
	        for (j = regionStartCol; j < regionStartCol + 3; ++j)
	            if (grid[i][j] == num)
	                return false;
	 
	    return true;
	}
	 
	/*Main function for solving the sudoku puzzle
	grid: the 2d sudoku matrix
	rowNr: row number of the current cell being processed
	colNr: column number of the current cell being processed
	*/
	public static void solveSudoku(int[][] grid, int rowNr, int colNr) {
	 
	    if (rowNr >= NUM_ROWS) {
	        /*We have found a solution. print the grid and
	        terminate the recursion*/
	        printGrid(grid, true);
	        return;
	    }
	 
	    /*Pre-compute the row and column of the next cell*/
	    int nextRow = rowNr;
	    int nextCol = colNr + 1;
	    if (nextCol >= NUM_COLS) {
	        nextCol = 0;
	        nextRow = rowNr + 1;
	    }
	 
	    if (grid[rowNr][colNr] == -1) {
	        /*The puzzle writer has not assigned a number to this cell.
	        So try assigning numbers 1-9 to the cell*/
	        for (int num = 1; num <= 9; ++num) {
	            if (canFillCell(grid, rowNr, colNr, num)) {
	                grid[rowNr][colNr] = num;
	                solveSudoku(grid, nextRow, nextCol);
	            }
	        }
	        /*Once we are done trying all numbers from 1-9 assign the cell
	        back to -1 to indicate puzzle writer has not assigned a number 
	        to the cell*/
	        grid[rowNr][colNr] = -1;
	 
	    } else {
	        /*The puzzle writer has already assigned a value to the cell. 
	        So proceed to the next cell*/
	        solveSudoku(grid, nextRow, nextCol);
	    }
	}
	public static void printGrid(int[][] grid,boolean flag){
		for (int[] is : grid) {
			for (int i : is) {
				System.out.println(i+" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
