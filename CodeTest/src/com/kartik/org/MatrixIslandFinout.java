package com.kartik.org;
/**
 * A 2-dimensional matrix consists of 0’s and 1’s. An island is defined as a contiguous occurrence of 1’s that 
 * are adjacent to each other. Find the number of islands in the matrix

If there are two adjacent cells (left-right neighbors, top-down neighbors, diagonally adjacent neighbors) 
with a value 1, then the two cells belong to the same island. In the matrix below there are 3 islands. 
The cells A0, B1, C0, D0 and E0 form one island. The cells A3, B3, C3 and B4 form one island. The cell E3 forms the remaining island.



To find the number of islands, we make use of recursion. Once we find a cell whose value is 1, we start with 
the neighbors of this cell and recursively visit all cells that are reachable from this cell. To prevent from
 going into loops, we keep track if a cell has been visited or not and once a cell has been visited, we don’t visit it again.

A similar problem is the flood fill problem. The color at each pixel of an image is stored in a 2 dimensional
 matrix. Given the starting pixel and the new color, we have to change the color of all adjacent pixels that 
 have the same color as the starting pixel. So if the starting pixel A[2][3] is red and the new color is blue, 
 then we have to recursively find all red cells that are reachable from A[2][3] and change their color to blue.

In some cases, diagonal neighbors may not be considered as adjacent. It is better to clarify this with the interviewer.

@lonk http://www.interviewdruid.com/category/miscellaneous-algorithms/
 * @author kmandal
 *
 */
public class MatrixIslandFinout {

	/* Helper function that indicates if we can enter the cell or not*/
	public static boolean canEnterCell(int[][] matrix, boolean[][] isVisited, 
	                int curRow, int curCol) {
	    int nRows = matrix.length;
	    int nCols = matrix[0].length;
	 
	    /*If we are outside the bounds of the matrix or
	    if the cell is already visited or if the value in cell is 0
	    then we shouldn't enter the cell */
	    if (curRow < 0 || curRow >= nRows 
	        || curCol < 0 || curCol >= nCols
	        || isVisited[curRow][curCol] 
	        || matrix[curRow][curCol] == 0) {
	        return false;
	    }
	 
	    return true;
	}
	 
	 
	/* Helper function to count the number of islands of 1's
	matrix: 2d matrix consisting of 0's and 1's
	isVisited: if cell (i, j) has been visited, isVisited[i][j] is set to true
	curRow: row of the current cell being processed
	curCol: column of the current cell being processed
	*/
	public static void expandSearch(int[][] matrix, boolean[][] isVisited, int curRow, int curCol) {
	   // int nRows = matrix.length; 
	   // int nCols = matrix[0].length;
	 
	    isVisited[curRow][curCol] = true;
	 
	    /*For the current cell, find out if we can continue the island of 1's
	    with its neighbors. Each cell has 9 neighbors. The rows
	    of neighbors will vary from curRow - 1 to curRow + 1
	    The columns of the neighbors will vary from curCol - 1
	    to curCol + 1*/
	    for (int i = -1; i <= 1; ++i) {
	        for (int j = -1; j <= 1; ++j) {
	            boolean isSafeCell = canEnterCell(matrix, isVisited, curRow+i, 
	                                curCol+j);
	 
	            if (isSafeCell) {
	                expandSearch(matrix, isVisited, curRow+i, curCol+j);
	            }
	        }
	    }
	}
	 
	/* Main function to find the number of islands of 1's
	matrix: 2d matrix consisting of 0's and 1's. Should not be empty
	*/
	public static int findIslands(int[][] matrix) {
	    int nRows = matrix.length; 
	    int nCols = matrix[0].length;
	    boolean[][] isVisited = new boolean[nRows][nCols];
	 
	    /*Initially all cells are not yet visited*/
	    int i, j;
	    for (i = 0; i < nRows; ++i)
	        for (j = 0; j < nCols; ++j) 
	            isVisited[i][j] = false;
	 
	    /*Search all the cells in matrix that are not yet visited*/
	    int count = 0;
	    for (i = 0; i < nRows; ++i) {
	        for (j = 0; j < nCols; ++j) {
	            if (matrix[i][j] == 1 && !isVisited[i][j]) {
	                /*We have found an island. Now expand the island 
	                in all directions*/
	                expandSearch(matrix, isVisited, i, j);
	                ++count;
	            }
	        }
	    }
	    return count;
	}
	public static void main(String[] args) {
		 // Test Case 1
        int mat[][] =
        {
            {1, 0, 0, 1,0},
            {0, 1, 0, 1,0},
            {1, 0, 0, 1,1},
            {1, 0, 0, 0,0},
            {1, 0, 0, 1,0}
        };

        System.out.println(findIslands(mat));
	}

}
