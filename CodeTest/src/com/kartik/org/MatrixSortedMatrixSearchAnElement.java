package com.kartik.org;

public class MatrixSortedMatrixSearchAnElement {

	//https://www.youtube.com/watch?v=dsPdwhRR_84
	public static void main(String[] args) {
		int a[][]={{1,2,3},
				{4,5,6},
				{7,8,9}};
		System.out.println(search(a, 8));

	}

	public static boolean search(int[][] a, int s) {
		int i = 0;
		int j = a[0].length - 1;
		int n = a[0].length;
		while (i < n && j > 0) {
			if (s == a[i][j]) {
				return true;
			} else {
				if (s < a[i][j]) {
					j--;
				} else {
					i++;
				}
			}
		}
		return false;
	}
	
	
}
