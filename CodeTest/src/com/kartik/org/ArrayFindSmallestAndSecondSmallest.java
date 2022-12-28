package com.kartik.org;
/**
 * Find the smallest and second smallest numbers in an array

We can find the smallest and second smallest numbers in a single 
scan of the array. We will maintain another array called min_values 
for storing the 2 smallest numbers. min_values[0] will store the smallest
 value and min_values[1] will store the second smallest value. min_values[0] 
 and min_values[1] are initialized to MAX_INT. As we traverse the main array, 
 we do the following

–	If the current element is smaller than min_values[0], then we move
 min_values[0] to min_values[1] and store the current element in min_values[0]

–	If the current element is larger than min_values[0] but smaller than 
min_values[1], then we store the current element in min_values[1]
 * @author kmandal
 *
 *@link http://www.interviewdruid.com/category/dynamic-programming/
 */
public class ArrayFindSmallestAndSecondSmallest {

	/*
	a:input array 
	minValue: the two smallest values will be returned here
	*/
	public static int[] findTwoSmallest(int[] a, int[] minValue) {
	    minValue[0] = minValue[1] = Integer.MAX_VALUE;
	    /* There should be atleast two elements */
        if (a.length < 2) 
        { 
            System.out.println(" Invalid Input "); 
            return minValue; 
        } 
	    for (int curVal : a) {
	        if (curVal < minValue[0]) {
	            minValue[1] = minValue[0];
	            minValue[0] = curVal;
	        } else if (curVal < minValue[1]) {
	            minValue[1] = curVal;
	        }
	    }
	    return minValue;
	}
	public static void main(String[] args) {
		int[] a = {10, 20, 20, 30, 40, 50};
		int [] b= new int[2];
		int []c=findTwoSmallest(a,b);
		System.out.println(c[0]+" "+c[1]);

	}

}
