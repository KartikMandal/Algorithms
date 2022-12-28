package com.kartik.demo;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/**
 * Given a set of time intervals in any order, merge all overlapping intervals
 * into one and output the result which should have only mutually exclusive
 * intervals. Let the intervals be represented as pairs of integers for
 * simplicity. For example, let the given set of intervals be {{1,3}, {2,4},
 * {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other, so they
 * should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be
 * merged and become {5, 8}
 */
public class MergeOverlappingIntervals {

	// Function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	public static void mergeIntervals(Interval arr[]) {
		// Sort Intervals in increasing order of
		// start time
		/*
		 * Arrays.sort(arr,new Comparator<Interval>(){ public int
		 * compare(Interval i1,Interval i2) { return i1.start - i2.start; } });
		 */

		Arrays.sort(arr, (o1, o2) -> (Integer.valueOf(o1.start))
				.compareTo(Integer.valueOf(o2.start)));

		int index = 0; // Stores index of last element
		// in output array (modified arr[])

		// Traverse all input Intervals
		for (int i = 1; i < arr.length; i++) {
			// If this is not first Interval and overlaps
			// with the previous one
			if (arr[index].end >= arr[i].start) {
				// Merge previous and current Intervals
				arr[index].end = Math.max(arr[index].end, arr[i].end);
			} else {
				index++;
				arr[index] = arr[i];
			}
		}

		// Now arr[0..index-1] stores the merged Intervals
		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i <= index; i++) {
			System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
		}
	}

	// Driver Code
	public static void main(String args[]) {
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(1, 3);
		arr[2] = new Interval(4, 5);
		arr[3] = new Interval(4, 7);
		mergeIntervals(arr);
	}
}
