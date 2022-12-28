package com.kartik.org;
/**
 * https://www.geeksforgeeks.org/maximum-path-sum-triangle/
 * @author kmandal
 * 
 * Maximum path sum in a triangle.
We have given numbers in form of triangle, by starting at the top of the triangle and moving to 
adjacent numbers on the row below, find the maximum total from top to bottom.

Examples :

Input : 
   3
  7 4
 2 4 6
8 5 9 3
Output : 23
Explanation : 3 + 7 + 4 + 9 = 23 


Example:

   3
  7 4
 2 4 6
8 5 9 3

Step 1 :
3 0 0 0
7 4 0 0
2 4 6 0
8 5 9 3

Step 2 :
3  0  0  0
7  4  0  0
10 13 15 0

Step 3 :
3  0  0  0
20 19 0  0

Step 4:
23 0 0 0

output : 23

 * 
 *
 */
public class ArrayMaximumPathSumOfTriangle {
	//static int N = 3; 
    
    // Function for finding maximum sum 
    static int maxPathSum(int tri[][], int m, int n) 
    { 
        // loop for bottom-up calculation 
        for (int i = m - 1; i >= 0; i--) 
        { 
            for (int j = 0; j <= i; j++) 
            { 
                // for each element, check both 
                // elements just below the number 
                // and below right to the number 
                // add the maximum of them to it 
                if (tri[i + 1][j] > tri[i + 1][j + 1]) 
                    tri[i][j] += tri[i + 1][j]; 
                else
                    tri[i][j] += tri[i + 1][j + 1]; 
            } 
        } 
      
        // return the top element 
        // which stores the maximum sum 
        return tri[0][0]; 
    } 
      
    /* Driver program to test above functions */
    public static void main (String[] args) 
    { 
        int tri[][] = { {1, 0, 0}, 
                        {4, 8, 0}, 
                        {1, 5, 3} }; 
        System.out.println ( maxPathSum(tri, tri.length-1, tri[0].length-1)); 
    } 
}
