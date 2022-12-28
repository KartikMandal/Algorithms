package com.kartik.org;
/**
 * 
 * @author kmandal
 *
 */
public class MatrixInZigzagFormPrint {

	public static void main(String[] args) {
		char[][] abc = new char[][] { 
				{ 'X', 'X', 'O', 'X' },
				{ 'O', 'O', 'X', 'O' }, 
				{ 'X', 'X', 'X', 'O' } 
				};
		int[][] matrix = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } 
				};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("Right to left Zigzag convert");
		//zigzagRightToLeft(matrix, 0, 0, 0);
		System.out.println();
		System.out.println("Left to right Zigzag convert");
		//zigzagLeftToRight(matrix, 0, 0, 0);

		System.out.println();
		System.out.println("Left to right Zigzag convert");
		//zigOnlyLeftToRight(matrix, 0, 0, 0);
		System.out.println();
		System.out.println("Right to left Zigzag convert");
		//zigOnlyRightToLeft(matrix, 0, 0, 0);

		System.out.println();
		System.out.println("Zigzag using tail recursive");
		zigzagTailRecursive(matrix, 0, 0, 0, 0, 0);
		
		zigOnlyRightToLeftRight(matrix);
		
		//zigOnlyRightToLeftRight1(matrix);
		int row = abc.length, column = abc[0].length;
		//zigOnlyRightToLeftRight1(abc, column-1);
		//zig(matrix,1);
	}
	
	static void zig(int [][]matrix,int top){
		int row = matrix.length;
		/**
		 * -->03
		 * --> 02 -->13
		 * -->01-->12 -->23
		 * -->00-->11-->22 
		 * -->10-->21
		 * -->20
		 */
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int m=0;
		int n=top;
		for(int j=top;j<=row-1;j++){
			System.out.print(matrix[j][m] + " ");
			m++;
		}
		if(n<row-1)
		zig(matrix, n+1);
	}
	
	static void zigOnlyRightToLeftRight1(char[][] matrix, int bottom) {
		int column = matrix[0].length;
		/**
		 * -->03
		 * --> 02 -->13
		 * -->01-->12 -->23
		 * -->00-->11-->22 
		 * -->10-->21
		 * -->20
		 */
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int i=0;
		int k=bottom;
		for(int j=bottom;j<=column-1;j++){
			System.out.print(matrix[i][j] + " ");
			i++;
		}
		if(k>0)
		zigOnlyRightToLeftRight1(matrix, k-1);
		
		// printing elements above and on
		// printing elements below second
		// diagonal
		/*for (int j = n - 1; j >=0; j--) {
			// traversing downwards starting
			// from last column
			int row = 0, col = j;
			while (col < n) {
				System.out.println(matrix[row][col] + " ");
				row--;
				col++;
			}
		}*/

		// second diagonal
		/*for (int k = n - 1; k >= 0; k--) {
			// traversing downwards starting
			// from first row
			int col = 0, row = k;
			while (col >= 0) {
				System.out.println(matrix[row][col] + " ");
				row++;
				col--;
			}
		}*/
	}
	
	
	static void zigOnlyRightToLeftRight(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		// printing elements above and on
		// printing elements below second
		// diagonal
		for (int j = m - 1; j >=0; j--) {
			// traversing downwards starting
			// from last column
			int col = n - 1, row = j;
			while (row < m) {
				System.out.println(matrix[row][col] + " ");
				row--;
				col++;
			}
		}

		// second diagonal
		for (int k = m - 1; k >= 0; k--) {
			// traversing downwards starting
			// from first row
			int row = 0, col = k;
			while (col >= 0) {
				System.out.println(matrix[row][col] + " ");
				row++;
				col--;
			}
		}
	}

	static void zigzagRightToLeft(int[][] matrix, int bottom, int top, int level) {
		int row = matrix.length, column = matrix[0].length;
		// traversing bottom to top
		for (int i = bottom, j = top; i >= 0 && j < column; i--, j++) {
			System.out.print(matrix[i][j] + " ");

		}
		// changing the index to traverse from bottom to top
		if (bottom < row - 1) {
			bottom++;
		} else {
			bottom = row - 1;
			top++;
		}

		if (level++ < row + column - 1) {
			zigzagLeftToRight(matrix, top, bottom, level++);
		}
	}

	static void zigzagLeftToRight(int[][] matrix, int bottom, int top, int level) {
		int row = matrix.length, column = matrix[0].length;
		// traversing top to bottom
		for (int i = bottom, j = top; i < row && j >= 0; i++, j--) {
			System.out.print(matrix[i][j] + " ");
		}
		// changing the index to traverse from bottom to top
		if (top < column - 1) {
			top++;
		} else {
			bottom++;
			top = column - 1;
		}

		if (level++ < row + column - 1) {
			zigzagRightToLeft(matrix, top, bottom, level++);
		}
	}

	static void zigOnlyLeftToRight(int[][] matrix, int bottom, int top,
			int level) {
		int m = matrix.length, n = matrix[0].length;
		// traversing bottom to top
		for (int j = bottom, k = top; j >= 0 && k < n; j--, k++) {
			System.out.print(matrix[j][k] + " ");

		}
		// changing the index to traverse from bottom to top
		if (bottom < m - 1) {
			bottom++;
		} else {
			bottom = m - 1;
			top++;
		}

		if (level++ < m + n - 1) {
			zigOnlyLeftToRight(matrix, bottom, top, level++);
		}
	}
	
	
	

	static void zigOnlyRightToLeft(int[][] matrix, int bottom, int top,
			int level) {
		int m = matrix.length, n = matrix[0].length;
		// traversing top to bottom
		for (int j = bottom, k = top; j < m && k >= 0; j++, k--) {
			System.out.print(matrix[j][k] + " ");
		}
		// changing the index to traverse from bottom to top
		if (top < n - 1) {
			top++;
		} else {
			bottom++;
			top = n - 1;
		}
		if (level++ < m + n - 1) {
			zigOnlyRightToLeft(matrix, bottom, top, level++);
		}
	}
/** 
 *              Top    
 *              |
        Left ___|___right
                |
                |
              Bottom
            
	          ________
	Left     |\		  |
  Bottom	 |	\	  |  Right and top
		     |	 \	  |
		     |	  \	  |
		     |	   \  |
		     |		\ |
		     ________\_
		        
		        
		        
		  Actual Matrix=
		        { 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }
		        
		           
		   row \column 
		        { 0-0, 0-1, 0-2, 0-3 }, 
				{ 1-0, 1-1, 1-2, 1-3 },
				{ 2-0, 2-1, 2-2, 2-3 },
				{ 3-0, 3-1, 3-2, 3-3 }
 * 
 */
	static void zigzagTailRecursive(int[][] matrix, int bottom, int left, int right,
			int top, int level) {
		int matrixRowLength = matrix.length, matrixRowColLength = matrix[0].length;

		if (level % 2 == 0 && level < matrixRowLength + matrixRowColLength - 1) {
			// traversing bottom to top
			for (int row = bottom, col = left; row >= 0 && col < matrixRowColLength; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
		} else if (level % 2 == 1 && level < matrixRowLength + matrixRowColLength - 1) {
			// traversing top to bottom
			for (int row = right, col = top; row < matrixRowLength && col >= 0; row++, col--) {
				System.out.print(matrix[row][col] + " ");
			}
		}
		// changing the index to traverse from bottom to top
		if (bottom < matrixRowLength - 1) {
			bottom++;
		} else {
			bottom = matrixRowLength - 1;
			left++;
		}
		// changing the index to traverse from top to bottom
		if (top < matrixRowColLength - 1) {
			top++;
		} else {
			top = matrixRowColLength - 1;
			right++;
			
		}
		if (level++ < matrixRowLength + matrixRowColLength - 1) {
			zigzagTailRecursive(matrix, bottom, left, right, top, level++);
		}
	}

}
