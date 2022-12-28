package com.kartik.org;

public class StringLongestRepeatingSubSeq {

	// Refer https://www.geeksforgeeks.org/longest-repeating-subsequence/
	// for complete code.
	// This function mainly returns LCS(str, str)
	// with a condition that same characters at
	// same index are not considered. 
	int findLongestRepeatingSubSeq(String str)
	{
	    int n = str.length();
	  
	    // Create and initialize DP table
		int[][] dp = new int[n+1][n+1];
		//dp[n+1][n+1]=0;
	    for (int i=0; i<=n; i++)
	        for (int j=0; j<=n; j++)
	            dp[i][j] = 0;
	  
	    // Fill dp table (similar to LCS loops)
	    for (int i=1; i<=n; i++)
	    {
	        for (int j=1; j<=n; j++)
	        {
	            // If characters match and indexes are 
	            // not same
	        	char ch = str.charAt(i-1);
	        	String x=String.valueOf(ch);
	        	ch = str.charAt(j-1);
	        	String y=String.valueOf(ch);
	            if (x.equals(y) && i != j)
	                dp[i][j] =  1 + dp[i-1][j-1];          
	                       
	            // If characters do not match
	            else
	                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
	        }
	    }
	    return dp[n][n];
	}
	
	public static void main(String[] args) {
StringLongestRepeatingSubSeq str=new StringLongestRepeatingSubSeq();
String str1 = "ABCCBAKARTIKMANDALOLADNAMKITRAKOJMALABCDCBA";
System.out.println(str.findLongestRepeatingSubSeq(str1));
	}

}
