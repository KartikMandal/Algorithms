package com.kartik.org;
/**
 * 
 * @author kmandal
 *
 */
public class MatrixInZigzagFormPrint {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, 
				{ 13, 14, 15, 16 } };
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
		zigOnlyLeftToRight(matrix, 0, 0, 0);
		System.out.println();
		System.out.println("Right to left Zigzag convert");
		zigOnlyRightToLeft(matrix, 0, 0, 0);

		System.out.println();
		System.out.println("Zigzag using tail recursive");
		zigzagTailRecursive(matrix, 0, 0, 0, 0, 0);

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

	static void zigzagTailRecursive(int[][] matrix, int bottom, int left, int right,
			int top, int level) {
		int row = matrix.length, column = matrix[0].length;

		if (level % 2 == 0 && level < row + column - 1) {
			// traversing bottom to top
			for (int j = bottom, k = left; j >= 0 && k < column; j--, k++) {
				System.out.print(matrix[j][k] + " ");
			}
		} else if (level % 2 == 1 && level < row + column - 1) {
			// traversing top to bottom
			for (int j = right, k = top; j < row && k >= 0; j++, k--) {
				System.out.print(matrix[j][k] + " ");
			}
		}
		// changing the index to traverse from bottom to top
		if (bottom < row - 1) {
			bottom++;
		} else {
			bottom = row - 1;
			left++;
		}
		// changing the index to traverse from bottom to top
		if (top < column - 1) {
			top++;
		} else {
			top = column - 1;
			right++;
			
		}
		if (level++ < row + column - 1) {
			zigzagTailRecursive(matrix, bottom, left, right, top, level++);
		}
	}

}
