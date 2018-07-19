package com.kartik.org;

public class StringLongestPalindromeLength {

	
	public static int longestPalindrome(String X,int i,int j){
		if(i>j){
			return 0;
		}
		if(i==j){
			return 1;
		}
		if(X.charAt(i)==X.charAt(j)){
			return longestPalindrome(X, i+1, j-1)+2;
		}
		return Integer.max(longestPalindrome(X, i, j-1), longestPalindrome(X, i+1, j));
	}
	
	
	public static void main(String[] args) {
		String X="ABCDCBAMAO";
		System.out.println(longestPalindrome(X, 0, X.length()-1));
	}

}
