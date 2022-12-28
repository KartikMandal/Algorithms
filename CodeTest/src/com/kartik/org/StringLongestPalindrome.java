package com.kartik.org;
//http://rextester.com/QNKJQ65800
public class StringLongestPalindrome {

	
	 public static void main(String args[]) {
		    String str = "ABCCBAKARTIKMANDALOLADNAMKITRAKOJMALABCDCBA";
		  // String str = "MOMABCCBAKA";
		  // String str = "My Mother is a w a si rehtoM";
		  System.out.println("Print longest palindrom from the word "
		    + longestPalindrome(str));
		  System.out.println("Print longest palindrom length "
				    + longestPalindrome(str).length());
		  
		 }

	/**
	 * 
	 * @param word
	 * @param left
	 * @param right
	 * @return
	 */
	static public String helper(String word, int left, int right) {
		if (left > right) return null;
		return (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right))?helper(word,--left,++right):word.substring(++left, right);
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public static String longestPalindrome(String word) {
		if (word == null) return null;
		String longest = word.substring(0, 1);
		for (int i = 0; i < word.length() - 1; i++) {
			//odd cases like 121
			String palindrome = helper(word, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			//even cases like 1221
			palindrome = helper(word, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

}