package com.kartik.org;

public class TestSubPlaindrom {

	/**
	 *
	 * @param word
	 *            word
	 * @return longest
	 */
	public String longestPalindrome(String word) {
		if (word.isEmpty()) {
			return null;
		}
		if (word.length() == 1) {
			return word;
		}
		String longest = word.substring(0, 1);
		String temp = null;
		for (int ite = 0; ite < word.length(); ite++) {
			// get longest palindrome with center of i is single
			if (ite < word.length() - 1
					&& word.charAt(ite) == word.charAt(ite + 1)) {
				temp = helper(word, ite, ite + 1);
			} else {
				temp = helper(word, ite, ite);
			}
			if (temp.length() > 1) {
				if (temp.length() > longest.length()) {
					longest = temp;
				}
				System.out
						.println("Print All palindrom which is more than 1 character "
								+ temp);
			}

		}

		return longest;

	}

	/**
	 * Given a center, either one letter or two letter, Find longest palindrome
	 *
	 * @param word
	 *            word
	 * @param begin
	 *            begin
	 * @param end
	 *            end
	 * @return word.substring
	 */
	public String helper(String word, int begin, int end) {
		while (begin >= 0 && end <= word.length() - 1
				&& word.charAt(begin) == word.charAt(end)) {
			begin--;// this is for middle to left when matching
			end++;// this is middle to right when matching
		}
		return word.substring(begin + 1, end);
	}

	public static void main(String args[]) {
		TestSubPlaindrom lps = new TestSubPlaindrom();
		String str = "ABCCBAKARTIKMANDALOLADNAMKITRAKOJMALABCDCBA";
		// String str = "MOMABCCBAKA";
		// String str = "My Mother is a w a si rehtoM";
		System.out.println("Print longest palindrom from the word "
				+ lps.longestPalindrome(str));
	}

}
