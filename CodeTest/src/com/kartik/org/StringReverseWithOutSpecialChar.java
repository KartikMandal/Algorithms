package com.kartik.demo;

/**
 * /**
 * 
 * @author SG0308108
 *
 *         <p>
 * 
 *         <b>char []arr = str.toCharArray();</b>Convert String to character. <br>
 *         <b>Arrays.sort(arr);</b> Sort of array <br>
 *         <b>Character.isAlphabetic(str[l])</b> Condition check for character
 *         is Alphabetic<br>
 *         <b>Character.isDigit(str[l])</b> Condition check for character is
 *         number<br>
 *         <b>String s[] = st.split(" ")</b> String data split by using space to
 *         string array
 *         <table border="1px solid">
 *         <tr>
 *         <th>Syntax</th>
 *         <th>Explanation</th>
 *         </tr>
 *         <tr>
 *         <td>int MAX_CHAR = 26;int letters[] = new int[MAX_CHAR];for(char x :
 *         <b>str.toCharArray()</b>) {<b>letters[x -'a']++;</b>}</td>
 *         <td>Traverse string and increment count of characters 'a'-'a' will be
 *         0, 'b'-'a' will be 1, so for location of character in count array we
 *         will do str[i]-'a'.</td>
 *         </tr>
 *         <tr>
 *         <td>for (int i = 0; i < MAX_CHAR; i++) { System.out.print(<b>(char)
 *         (i + 'a')</b>); }</td>
 *         <td>Traverse string and increment count of characters 'a'-'a' will be
 *         0, 'b'-'a' will be 1, so for location of character in count array we
 *         will do str[i]-'a'.</td>
 *         </tr>
 *         </table>
 *         <br>
 *         </p>
 *         Given a string, that contains a special character together with
 *         alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way
 *         that special characters are not affected. Examples:
 * 
 * 
 *         Input: str = "a,b$c" Output: str = "c,b$a" Note that $ and , are not
 *         moved anywhere. Only subsequence "abc" is reversed
 * 
 *         Input: str = "Ab,c,de!$" Output: str = "ed,c,bA!$"
 */
public class StringReverseWithOutSpecialChar {
	public static void reverse(char str[]) {
		// Initialize left and right pointers
		int r = str.length - 1, l = 0;

		// Traverse string from both ends until 'l' and 'r'
		while (l < r) {
			// Ignore special characters
			if (!Character.isAlphabetic(str[l]))
				l++;
			else if (!Character.isAlphabetic(str[r]))
				r--;

			// Both str[l] and str[r] are not spacial
			else {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		String str = "a!!!b.c.d,e'f,ghi";
		char[] charArray = str.toCharArray();

		System.out.println("Input string: " + str);
		reverse(charArray);
		String revStr = new String(charArray);

		System.out.println("Output string: " + revStr);
	}
}