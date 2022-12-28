package com.kartik.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
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
 *
 *         i like this program very much --> i ekil siht margorp yrev hcum
 *
 */
public class ReverseIndividualWord {
	public static void main(String... args) {

		String str = "i like this program very much";
		String result = Arrays.asList(str.split(" ")).stream()
				.map(s1 -> new StringBuilder(s1).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(result);
	}
}