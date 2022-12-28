package com.kartik.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The problem differs from the problem of finding the longest subsequence with
 * k distinct characters. Unlike subsequences, substrings are required to occupy
 * consecutive positions within the original string.
 * 
 * 
 * For example, consider string abcbdbdbbdcdabd.
 * 
 * For k = 2, o/p is ‘bdbdbbd’ 
 * For k = 3, o/p is ‘bcbdbdbbdcd’ 
 * For k = 5, o/p is ‘abcbdbdbbdcdabd’
 * 
 *
 */
public class FindUniqueLongestSubstring {

	// Define the character range
	public static final int CHAR_RANGE = 128;

	// Function to find the longest substring of a given string containing
	// `k` distinct characters using a sliding window
	public static String findLongestSubstring(String str, int k) {
		// base case
		if (str == null || str.length() == 0) {
			return str;
		}

		// stores the longest substring boundaries
		int end = 0, begin = 0;

		// set to store distinct characters in a window
		Set<Character> window = new HashSet<>();

		// Count array `freq` stores the frequency of characters present in the
		// current window. We can also use a map instead of a count array.
		int[] freq = new int[CHAR_RANGE];

		// `[low…high]` maintains the sliding window boundaries
		for (int low = 0, high = 0; high < str.length(); high++) {
			window.add(str.charAt(high));
			freq[str.charAt(high)]++;

			// if the window size is more than `k`, remove characters from the
			// left
			while (window.size() > k) {
				// If the leftmost character's frequency becomes 0 after
				// removing it in the window, remove it from the set as well
				if (--freq[str.charAt(low)] == 0) {
					window.remove(str.charAt(low));
				}

				low++; // reduce window size
			}

			// update the maximum window size if necessary
			if (end - begin < high - low) {
				end = high;
				begin = low;
			}
		}

		// return the longest substring found at `str[begin…end]`
		return str.substring(begin, end + 1);
	}
	
	
	
	public static int longestkSubstr(String s, int k) {
	       // code here
	       HashMap<Character,Integer> map = new HashMap<>();
	       int n = s.length();
	       int i=0,j=0,MaxLen=-1;
	       while(i<n){
	           if(map.containsKey(s.charAt(i))){
	               map.put(s.charAt(i),map.get(s.charAt(i))+1);
	           }
	           else{
	               map.put(s.charAt(i),1);
	           }
	           if(map.size()<k){
	               i++;
	           }
	           else if(map.size()==k){
	               if(MaxLen < (i-j+1) ){
	                   MaxLen = i-j+1;
	               }
	               i++;
	           }
	           else{
	               while(map.size()>k && j<i){
	                   char c = s.charAt(j);
	                   int freq = map.get(c);
	                   map.remove(c);
	                   freq--;
	                   if(freq>0){
	                       map.put(c,freq);
	                   }
	                   j++;
	               }
	               i++;
	           }
	       }
	       return MaxLen;
	   }

	

	public static void main(String[] args) {
		String str = "abcbdbdbbdcdabd";
		int k = 3;

		System.out.print(findLongestSubstring(str, k));
		
		System.out.println(longestkSubstr(str, k));
	}

}
