package com.kartik.org;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kmandal
 *
 */

// https://www.techiedelight.com/find-all-paths-from-source-to-destination-in-matrix/
public class MatrixFindAllPathFromSourceToDestination {

	static int sum = 0;
	static int count = 0;

	// Function to print the route taken
	public static void printPath(List<Character> path, char last) {
		if (!path.contains('X')) {
			count = count + 1;
			int temp = 0;
			for (int i = 1; i <= path.size() - 1; i++) {
				temp = temp + Integer.parseInt(path.get(i).toString());
			}

			if (temp > sum) {
				sum = temp;
			}
			for (char i : path) {
				System.out.print(i + " - ");
			}
			System.out.println(last);

		}
	}

	public static void findPaths(char[][] mat, List<Character> path, int i,
			int j) {
		int M = mat.length;
		int N = mat[0].length;

		// if we have reached the last cell, print the route
		if (i == M - 1 && j == N - 1) {
			printPath(path, mat[i][j]);
			return;
		}

		// include current cell in path
		path.add(mat[i][j]);

		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {

			findPaths(mat, path, i, j + 1);
		}

		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
			findPaths(mat, path, i + 1, j);
		}

		// remove current cell from path
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		char[][] mat = { { 'e', '2', '3' }, 
						{ '4', 'X', '6' },
						{ '7', '8', 's' } };

		List<Character> path = new ArrayList<>();

		// start from (0, 0) cell
		int x = 0, y = 0;

		findPaths(mat, path, x, y);
		System.out.println(sum + " " + count);
	}

}
