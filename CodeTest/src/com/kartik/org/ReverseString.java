package com.kartik.demo;
/**
 * 
 * @author SG0308108
 *
 *      <p>   
 *     
 *         <b>char []arr = str.toCharArray();</b>Convert String to character. <br>
 *         <b>Arrays.sort(arr);</b> Sort of array <br>
 *         <b>Character.isAlphabetic(str[l])</b> Condition check for character is Alphabetic<br>
 *         <b>Character.isDigit(str[l])</b> Condition check for character is number<br>
 * 		   <b>String s[] = st.split(" ")</b> String data split by using space to string array
 *         <table border="1px solid">
 *         <tr>
 *         <th>Syntax</th>
 *         <th>Explanation</th>
 *         </tr>
 *         <tr>
 *         <td>int MAX_CHAR = 26;int letters[] = new int[MAX_CHAR];for(char x : <b>str.toCharArray()</b>) {<b>letters[x -'a']++;</b>}</td>
 *         <td>Traverse string and increment count of characters 'a'-'a' will be 0, 'b'-'a' will be 1, so for location of character in count array we will do str[i]-'a'.</td>
 *         </tr>
 *         <tr>
 *         <td>for (int i = 0; i < MAX_CHAR; i++) { System.out.print(<b>(char) (i + 'a')</b>); }</td>
 *         <td>Traverse string and increment count of characters 'a'-'a' will be 0, 'b'-'a' will be 1, so for location of character in count array we will do str[i]-'a'.</td>
 *         </tr>
 *         </table>
 *         <br>
 *         </p>
 */
public class ReverseString {
	public static void main(String[] args)
    {
        String input = "GeeksForGeeks";
        reverse(input);
        System.out.println();
        String s = "a+b*c-d/e";
        reverse(s);
        
        System.out.println();
        reverse("20 - 3 + 5 * 2");
        System.out.println(reverseEquation("20 - 3 + 5 * 2"));
    }
	
	static void reverse(String input){
		  // convert String to character array
        // by using toCharArray
		 char[] try1 = input.toCharArray();
		 
	        for (int i = try1.length - 1; i >= 0; i--)
	            System.out.print(try1[i]);
	}
	
	
	// Function to reverse order of words
	public static String reverseEquation(String s)
	{
	     
	    // Exact Resultant string
	    String result = "";
	    // for every character with space of the string
	    String str = "";
	     
	    for(int i = 0; i < s.length(); i++)
	    {
	         
	        // A space marks the end of the word
	        if (s.charAt(i) == '+' ||
	            s.charAt(i) == '-' ||
	            s.charAt(i) == '/' ||
	            s.charAt(i) == '*')
	        {
	             
	            // Insert the word at the beginning
	            // of the result string
	        	//s.charAt(i) is the operator 
	        	// current character of the string
	        	// reverse data
	            result = s.charAt(i) + str + result;
	            // Nullify current string
	            str = "";
	        }
	        else
	        {
	            str += s.charAt(i);
	        }
	    }
	    result = str + result;
	    return result;
	}
}
