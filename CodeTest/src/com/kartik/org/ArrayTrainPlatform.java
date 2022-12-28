package com.kartik.org;

import java.util.Arrays;
/**
 * Solution 2:
We will use logic very much similar to merge sort.

Sort both arrival(arr) and departure(dep) arrays.
Compare current element in arrival and departure array and pick smaller one among both.
If element is pick up from arrival array then increment platform_needed.
If element is pick up from departure array then decrement platform_needed.
While performing above steps, we need track count of maximum value reached for platform_needed.
In the end, we will return maximum value reached for platform_needed.
Time complexity : O(NLogN)
Below diagram will make you understand above code better:
//https://java2blog.com/minimum-number-of-platforms-required-for-railway-station/

 * @author kmandal
 *
 */

public class ArrayTrainPlatform {
public static void main(String args[]){
	ArrayTrainPlatform a=new ArrayTrainPlatform();
	// arr[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
			// dep[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
	 
			int arr[] = {100, 140, 150, 200, 215,350, 400,450,500};
			int dep[] = {110, 300, 210, 230,315, 600};
			System.out.println("Minimum platforms needed:"+a.findPlatformsRequiredForStation(arr,dep,arr.length,dep.length));
		}
	 
		 int findPlatformsRequiredForStation(int arr[], int dep[], int m,int n)
		{
			int platform_needed = 0, maxPlatforms = 0;
			Arrays.sort(arr);
			Arrays.sort(dep);
			int i = 0, j = 0;
	 
			// Similar to merge in merge sort
			while (i < m && j < n)
			{
				if (arr[i] < dep[j])
				{
					platform_needed++;
					i++;
					if (platform_needed > maxPlatforms) 
						maxPlatforms = platform_needed;
				}
				else 
				{
					platform_needed--;
					j++;
				}
			}
			return maxPlatforms;
		}
}