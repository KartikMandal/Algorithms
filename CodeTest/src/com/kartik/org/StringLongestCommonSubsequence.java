package com.kartik.org;
/**
 * 
 Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and “AYZX”

                         lcs("AXYT", "AYZX")
                       /                 
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /                              /               
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
In the above partial recursion tree, lcs(“AXY”, “AYZ”) is being solved twice. 
If we draw the complete recursion tree, then we can see that there are many 
subproblems which are solved again and again. So this problem has Overlapping 
Substructure property and recomputation of same subproblems can be avoided 
by either using Memoization or Tabulation. Following is a tabulated 
implementation for the LCS problem.
 
 
 * @author kmandal
 * 
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 *
 */
public class StringLongestCommonSubsequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	  int lcs( char[] X, char[] Y, int m, int n ) 
	  { 
	    if (m == 0 || n == 0) 
	      return 0; 
	    if (X[m-1] == Y[n-1]) 
	      return 1 + lcs(X, Y, m-1, n-1); 
	    else
	      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n)); 
	  } 
	  
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 
	  
	  public static void main(String[] args) 
	  { 
	    StringLongestCommonSubsequence lcs = new StringLongestCommonSubsequence(); 
	    String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	  
	    System.out.println("Length of LCS is" + " " + 
	                                  lcs.lcs( X, Y, m, n ) ); 
	  } 

}
