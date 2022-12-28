package com.kartik.org;

public class ArrayBinarySorting {

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 1, 0, 0, 1, 0, 0, 0 };
		int[] b = sort(a);
		for (int i : b) {
			System.out.printf(i + " ");
		}
	}

	public static int[] sort(int a[]) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			if (a[start] != 0 && a[end] == 0) {
				swap(a, start, end);
				start++;
				end--;
			} else if (a[start] == 0) {
				start++;
			} else if (a[end] != 0) {
				end--;
			}
		}

		return a;
	}

	public static void swap(int[] a, int start, int end) {
		int temp = a[start];
		a[start] = a[end];
		a[end] = temp;
	}

}
