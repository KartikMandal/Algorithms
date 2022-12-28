package com.kartik.org;

public class MatrixMaxSubSquare {

	public void displayMatrix(int[][] matrixInput, int row, int cols) {

		  for (int i = 0; i < row; i++) {

		   for (int j = 0; j < cols; j++) {

		    System.out.print(matrixInput[i][j] + " ");

		   }

		   System.out.println();

		  }

		 }

		 
		 /**

		  * @purpose This is find out the Square sub matrix 

		  * @param baseMatrixInput

		  *            arrA

		  * @param row

		  *            row

		  * @param cols

		  *            cols

		  */

		 public void subMatrix(int[][] baseMatrixInput, int row, int cols) {

		  System.out.println("Display base of matrix");

		  displayMatrix(baseMatrixInput, row, cols);

		  int maxSizeOfMatrix, maxRow, maxCol;

		  int[][] auxiliaryMatrix = new int[row][cols];

		  // copy the first row

		  for (int i = 0; i < cols; i++) {

		   auxiliaryMatrix[0][i] = baseMatrixInput[0][i];

		  }

		  // copy the first column

		  for (int i = 0; i < row; i++) {

		   auxiliaryMatrix[i][0] = baseMatrixInput[i][0];

		  }

		  // for rest of the matrix check if arrA[i][j]==1

		  System.out.println("----------Start---------------");

		  createAuxiliaryMatrix(baseMatrixInput, row, cols, auxiliaryMatrix);

		  System.out.println("----------End---------------");

		  System.out.println("Display auxiliary matrix");

		  displayMatrix(auxiliaryMatrix, row, cols);

		  // find the maximum size of sub matrix

		  maxSizeOfMatrix = auxiliaryMatrix[0][0];

		  maxRow = 0;

		  maxCol = 0;

		  for (int i = 0; i < row; i++) {

		   for (int j = 0; j < cols; j++) {

		    if (auxiliaryMatrix[i][j] > maxSizeOfMatrix) {

		     maxSizeOfMatrix = auxiliaryMatrix[i][j];

		     maxRow = i;

		     maxCol = j;

		    }

		   }

		  }

		  System.out.println("Maximum size square sub-matrix with all 1s: "

		    + maxSizeOfMatrix);

		 
		  System.out.println("Display of the sub matrix");

		  displaySubMatrix(maxSizeOfMatrix, maxRow, maxCol, auxiliaryMatrix);

		  System.out.println("Display of the sub matrix position");

		  displayPositionOfSubMatrix(maxSizeOfMatrix, maxRow, maxCol);

		 }

		 
		 /**

		  * 

		  * @param baseMatrixInput

		  * @param row

		  * @param cols

		  * @param auxiliaryMatrix

		  */

		 private void createAuxiliaryMatrix(int[][] baseMatrixInput, int row,

		   int cols, int[][] auxiliaryMatrix) {

		  for (int i = 1; i < row; i++) {

		   for (int j = 1; j < cols; j++) {

		    if (baseMatrixInput[i][j] == 1) {

		     // +1 is for increment because new formating of matrix like

		     //create your own minimum function  or use Math.min function like this 

		     System.out.println(i+""+j+"-->"+(i - 1)+""+(j - 1)+" , "+i+""+(j-1)+" , "+(i-1)+""+j);

		     auxiliaryMatrix[i][j] = min(auxiliaryMatrix[i - 1][j - 1],auxiliaryMatrix[i][j - 1],auxiliaryMatrix[i - 1][j]) + 1;

		    } else {

		     auxiliaryMatrix[i][j] = 0;

		    }

		   }

		  }

		 }

		 
		 /**

		  * @purpose This is display of matrix data in reverser order

		  * @param maxSizeOfMatrix

		  * @param maxRow

		  * @param maxCol

		  * @param auxiliaryMatrix

		  */

		 private void displaySubMatrix(int maxSizeOfMatrix, int maxRow, int maxCol,

		   int[][] auxiliaryMatrix) {
//because of square matrix so max row and max column should be deduct by maxSizeOfMatrix
		  for (int i = maxRow; i > maxRow - maxSizeOfMatrix; i--) {

		   for (int j = maxCol; j > maxCol - maxSizeOfMatrix; j--) {

		    System.out.print(auxiliaryMatrix[i][j] + " ");

		   }

		   System.out.println();

		  }

		 }

		 
		 /**

		  * @purpose This is display of matrix position where this matrix generated

		  *          in reverse order

		  * @param maxSizeOfMatrix

		  * @param maxRow

		  * @param maxCol

		  */

		 private void displayPositionOfSubMatrix(int maxSizeOfMatrix, int maxRow,

		   int maxCol) {

		  for (int i = maxRow; i > maxRow - maxSizeOfMatrix; i--) {

		   for (int j = maxCol; j > maxCol - maxSizeOfMatrix; j--) {

		    System.out.print(i + "" + j + ",");

		   }

		   System.out.println();

		  }

		 }

		 /**

		  * 

		  * @param a

		  * @param b

		  * @param c

		  * @return

		  */

		 int min(int a, int b, int c)

		 {

		   int m = a;

		   if (m > b) 

		     m = b;

		   if (m > c) 

		     m = c;

		   return m;

		 }

		 
		 public static void main(String[] args) {

		  int[][] twoDimensionalMatrix = { { 0, 1, 0, 1, 0, 1 },

		    { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 0 },

		    { 0, 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1 } };

		  /*int[][] twoDimensionalMatrix = { {0 , 1 , 1,  0,  1  },

		    { 1 , 1 , 0 , 1 , 0 }, { 0,  1  ,0, 1,  0 },

		    { 1 , 1,  1 , 1 , 0 }, { 1 , 1 , 1,  1 , 1 },{0 , 1 , 1, 1 , 1} };*/

		  

		  MatrixMaxSubSquare baseMatrix = new MatrixMaxSubSquare();

		  baseMatrix.subMatrix(twoDimensionalMatrix, 5, 6);

		 }

		}
