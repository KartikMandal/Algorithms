/**
 * 
 */
package com.kartik.org;

/**
 Find difference between sums of two diagonals
Given a matrix of n X n. The task is to calculate the absolute difference between the sums of its diagonal.

Examples:

Input : mat[][] = 11 2 4
                   4 5 6
                  10 8 -12 
Output : 15
Sum of primary diagonal = 11 + 5 + (-12) = 4.
Sum of primary diagonal = 4 + 5 + 10 = 19.
Difference = |19 - 4| = 15.


Input : mat[][] = 10 2
                   4 5
Output : 7
 * @author kmandal
 *
 */
public class MatrixDiogonalDifference {
	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int difference(int arr[][], int n) 
    { 
        // Initialize sums of diagonals 
        int d1 = 0, d2 = 0; 
       
        for (int i = 0; i < n; i++) 
        { 
            d1 += arr[i][i]; 
            d2 += arr[i][n-i-1]; 
        } 
       
        // Absolute difference of the sums 
        // across the diagonals 
        return Math.abs(d1 - d2); 
    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int arr[][] = 
			    { 
			        {11, 2, 4}, 
			        {4 , 5, 6}, 
			        {10, 8, -12} 
			    };
      System.out.println(difference(arr, arr.length));
      
      
      
      System.out.println("===============String Rotation another one program===========================");
      String str1 = "AACD"; 
      String str2 = "ACDA"; 

      if (areRotations(str1, str2)) 
          System.out.println("Yes"); 
      else
          System.out.printf("No"); 
	}
	
	
	
	/* Function checks if passed strings (str1 and str2) 
    are rotations of each other */
 static boolean areRotations(String str1, String str2) 
 { 
     // There lengths must be same and str2 must be 
     // a substring of str1 concatenated with str1. 
     return (str1.length() == str2.length()) &&  
            ((str1 + str1).contains(str2)); 
 } 



}
