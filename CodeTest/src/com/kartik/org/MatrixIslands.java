package com.kartik.org;

//Java program to count islands in boolean 2D matrix 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class MatrixIslands { 
 // No of rows and columns 
 static final int ROW = 5, COL = 5; 

 // A function to check if a given cell (row, col) can 
 // be included in DFS 
 boolean isSafe(int matrix[][], int row, int col, 
                boolean visited[][]) 
 { 
	 int m=matrix.length;
	 int c=matrix[0].length;
     // row number is in range, column number is in range 
     // and value is 1 and not yet visited 
     return (row >= 0) && (row < m) && (col >= 0) && (col < c) && (matrix[row][col] == 1 && !visited[row][col]); 
 } 

 // A utility function to do DFS for a 2D boolean matrix. 
 // It only considers the 8 neighbors as adjacent vertices 
 void DFS(int matrix[][], int row, int col, boolean visited[][]) 
 { 
     // These arrays are used to get row and column numbers 
     // of 8 neighbors of a given cell 
     int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
     int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 

     // Mark this cell as visited 
     visited[row][col] = true; 

     // Recur for all connected neighbours 
     for (int k = 0; k < 8; ++k) 
         if (isSafe(matrix, row + rowNbr[k], col + colNbr[k], visited)) 
             DFS(matrix, row + rowNbr[k], col + colNbr[k], visited); 
 } 

 // The main function that returns count of islands in a given 
 // boolean 2D matrix 
 int countIslands(int matrix[][]) 
 { 
	 int m=matrix.length;
	 int c=matrix[0].length;
     // Make a bool array to mark visited cells. 
     // Initially all cells are unvisited 
     boolean visited[][] = new boolean[m][c]; 

     // Initialize count as 0 and travese through the all cells 
     // of given matrix 
     int count = 0; 
     for (int i = 0; i < m; ++i) 
         for (int j = 0; j < c; ++j) 
             if (matrix[i][j] == 1 && !visited[i][j]) // If a cell with 
             { // value 1 is not 
                 // visited yet, then new island found, Visit all 
                 // cells in this island and increment island count 
                 DFS(matrix, i, j, visited); 
                 ++count; 
             } 

     return count; 
 } 

 
 
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
 // Driver method 
 public static void main(String[] args) throws java.lang.Exception 
 { 
     int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
                               { 0, 1, 0, 0, 1 }, 
                               { 1, 0, 0, 1, 1 }, 
                               { 0, 0, 0, 0, 0 }, 
                               { 1, 0, 1, 0, 1 } }; 
     MatrixIslands I = new MatrixIslands(); 
     System.out.println("Number of islands is: " + I.countIslands(M)); 
     
     System.out.println("Number of islands is sssf: " +findIslands(M)); 
 } 
} 
