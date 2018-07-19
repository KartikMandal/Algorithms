package com.kartik.org;

/**
 * '
 * @author kmandal
 *
 */
public class MatrixInSpiralFormPrint {
	 
	 public static void main(String[] args) {
	  new MatrixInSpiralFormPrint();
	 }
	 
	 public MatrixInSpiralFormPrint() {
	  int[][] matrix = {
			  {1,	2,	3,	4},
              {5, 	6, 	7, 	8},
              {9, 	10, 11, 12},
              {13, 	14, 15, 16}
	  };
	  
	  for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	  System.out.println("---------------------Spiral printing Solution 1---------------------------");
	  System.out.println();
	  printMatrixInSpiralWay(matrix,0,0,matrix[0].length-1,matrix.length-1);//matrix, top,left,right,bootom
	  System.out.println();
	  System.out.println();
	  System.out.println("----------------Spiral printing Solution 2---------------------------------");
	  System.out.println();
	  printSpiral(matrix);
	  System.out.println();
	  System.out.println("---------------------Spiral printing Solution 3---------------------------");
	  System.out.println();
		int lastRow = matrix.length - 1;
		int lastColumn = matrix[0].length - 1;
		int totalElems = matrix.length * matrix[0].length;

		traverseMatrixInSpiral(matrix, 0, lastRow, 0, lastColumn, totalElems,
				0, Direction.LEFT_RIGHT);
		
		 System.out.println();
		  System.out.println("------------------------------------------------------------------------");
		
	 }
	  /**
	   * @purpose:Solution 1
	   * @param matrix
	   * @param rowStart
	   * @param colStart
	   * @param colLength
	   * @param rowLength
	   */
	 private void printMatrixInSpiralWay(int[][] matrix, int rowStart, int colStart, int colLength,  int rowLength){
	  for (int i = rowStart; i <= colLength; i++) { //it is printing top-left to top-right 
	   System.out.print(matrix[rowStart][i] + " ");
	  }
	  for (int i = rowStart+1; i <= rowLength; i++) { // it is top-right to bottom-right 
		//we already printed corner element in Left to Right printing and no need to include it again.
	   System.out.print(matrix[i][colLength] + " ");
	  }
	   
	  if(rowStart+1 <= rowLength){//we already printed corner element in Left to Right printing and no need to include it again.
	   for (int i = colLength-1; i >= colStart; i--) { //it is bottom-right to bottom-left
	    System.out.print(matrix[rowLength][i] + " ");
	   } 
	  }
	   
	  if(colStart+1 <= colLength){//we already printed corner element in Left to Right printing and no need to include it again.
	   for (int i = rowLength-1; i > rowStart; i--) { // it is bottom-left to bottom-top 
	    System.out.print(matrix[i][colStart] + " ");
	   }
	  }
	   
	  if(rowStart+1 <= rowLength-1 && colStart+1 <= colLength-1){
	   printMatrixInSpiralWay(matrix, rowStart+1, colStart+1, colLength-1, rowLength-1);
	  }
	 }
	 
	 
	 /**
		 * Solution 2 
		 * @param arr
		 */
		public static void printSpiral(int arr[][]) {
		    printTopRight(arr,0,0,arr[0].length-1,arr.length-1);
		    System.out.println();
		    System.out.println("------------Bottom corner to spiral modle ---------------------");
		    printBottomLeft(arr,0,0,arr[0].length-1,arr.length-1);
		    System.out.println("\n");
		}
	 
		
		 
	// function to print the top-right peel of the matrix and 
	// recursively call the print bottom-left on the submatrix.
	 /**
	  * Soltion 2 with recursive 
	  * @param a
	  * @param left
	  * @param top
	  * @param right
	  * @param bottom
	  */
	 public static void printTopRight(int a[][], int left, int top, int right, int bottom) {
	    int i = 0, j = 0;

	    // print values in the row.
	    for(i = left; i<=right; i++) {
	    	System.out.print(a[top][i]+ " ");
	    }

	    // print values in the column.
	    for(j = top + 1; j <= bottom; j++)         {
	    	System.out.print(a[j][right]+ " ");
	    }

	    // see if more layers need to be printed.
	    if(right-left > 0) {
	        // if yes recursively call the function to 
	        // print the bottom left of the sub matrix.
	        printBottomLeft(a, left, top + 1, right-1, bottom);
	    }
	}

	// function to print the bottom-left peel of the matrix and 
	// recursively call the print top-right on the submatrix.
	 /**
	  * Soltion 2 with recursive 
	  * @param a
	  * @param left
	  * @param top
	  * @param right
	  * @param bottom
	  */
	public static void printBottomLeft(int a[][], int left, int top, int right, int bottom) {
	    int i = 0, j = 0;

	    // print the values in the row in reverse order.
	    for(i = right; i>=left; i--) {
	        System.out.print(a[bottom][i]+ " ");
	    }

	    // print the values in the col in reverse order.
	    for(j = bottom - 1; j >= top; j--) {
	    	System.out.print(a[j][left]+ " ");
	    }

	    // see if more layers need to be printed.
	    if(right-left > 0) {
	        // if yes recursively call the function to 
	        // print the top right of the sub matrix.
	        printTopRight(a, left+1, top, right, bottom-1);
	    }
	}

	
	
	 

	/**
	 * Solution 3
	 * @author kmandal
	 *
	 */
	enum Direction {
			LEFT_RIGHT, TOP_DOWN, RIGHT_LEFT, BOTTOM_UP
		};
		/**
		 * 
		 * @param matrix
		 * @param initialRow
		 * @param finalRow
		 * @param initialColumn
		 * @param finalColumn
		 * @param totalElems
		 * @param visited
		 * @param direction
		 */
		public static void traverseMatrixInSpiral(int[][] matrix, int initialRow,
				int finalRow, int initialColumn, int finalColumn, int totalElems,
				int visited, Direction direction) {
			if (visited != totalElems) {
				int count = 0;
				switch (direction) {
				case LEFT_RIGHT:
					for (int col = initialColumn; col <= finalColumn; col++) {
						System.out.print(matrix[initialRow][col] + " ");
						count++;
					}
					traverseMatrixInSpiral(matrix, initialRow + 1, finalRow,
							initialColumn, finalColumn, totalElems,
							visited + count, Direction.TOP_DOWN);
					break;
				case TOP_DOWN:
					for (int row = initialRow; row <= finalRow; row++) {
						System.out.print(matrix[row][finalColumn] + " ");
						count++;
					}
					traverseMatrixInSpiral(matrix, initialRow, finalRow,
							initialColumn, finalColumn - 1, totalElems, visited
									+ count, Direction.RIGHT_LEFT);
					break;
				case RIGHT_LEFT:
					for (int col = finalColumn; col >= initialColumn; col--) {
						System.out.print(matrix[finalRow][col] + " ");
						count++;
					}
					traverseMatrixInSpiral(matrix, initialRow, finalRow - 1,
							initialColumn, finalColumn, totalElems,
							visited + count, Direction.BOTTOM_UP);
					break;
				case BOTTOM_UP:
					for (int row = finalRow; row >= initialRow; row--) {
						System.out.print(matrix[row][initialColumn] + " ");
						count++;
					}
					traverseMatrixInSpiral(matrix, initialRow, finalRow,
							initialColumn + 1, finalColumn, totalElems, visited
									+ count, Direction.LEFT_RIGHT);
					break;
				}
			}
		}
	}
