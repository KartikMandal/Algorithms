package com.kartik.org;
/**
 * 
 * @author kmandal
 *
 *https://www.geeksforgeeks.org/trapping-rain-water/
 *https://www.techiedelight.com/trapping-rain-water-within-given-set-bars/
 *https://codepumpkin.com/trapping-rain-water-algorithm-problem/
 *
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Examples:

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_| 
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       | 
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2
 *
 */
public class ArrayRainWaterTrap {

	// Function to find amount of water that can be trapped within
		// given set of bars in linear time and constant space
		public static int trap(int[] heights)
		{
			// maintain two pointers left and right pointing to leftmost and
			// rightmost index of the input array
			int left = 0, right = heights.length - 1, water = 0;

			int maxLeft = heights[left];
			int maxRight = heights[right];

			while (left < right)
			{
				if (heights[left] <= heights[right])
				{
					left++;
					maxLeft = Integer.max(maxLeft, heights[left]);
					water += (maxLeft - heights[left]);
				}
				else
				{
					right--;
					maxRight = Integer.max(maxRight, heights[right]);
					water += (maxRight - heights[right]);
				}
			}

			return water;
		}

		// Trapping Rain Water within given set of bars
		public static void main(String[] args)
		{
			int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

			System.out.print("Maximum amount of water that can be trapped is " +
									trap(heights));
		}

}
