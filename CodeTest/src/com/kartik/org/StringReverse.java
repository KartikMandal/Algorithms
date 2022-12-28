package com.kartik.org;

public class StringReverse {
	/**
	 * 
	 * @param originalStr
	 * @return
	 */
	private static String reverseEveryCharacter(String str){
		if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseEveryCharacter(str.substring(1)) + str.charAt(0);
	}
	
	/**
	 * 
	 * @param originalStr
	 * @return
	 */
	private static String reverseEveryWord(String originalStr){
		String words[] = originalStr.split("\\s");
        String reversedString = "";
 
        //Reverse each word's position
        for (int i = 0; i < words.length; i++) { 
            if (i == words.length - 1) 
                reversedString = words[i] + reversedString; 
            else
                reversedString = " " + words[i] + reversedString; 
        } 
		return reversedString;
	}
	
	public static void main(String[] args) {
		String s="I love java programming";
		System.out.println("<----------Reverse every character------------>>");
		System.out.println(reverseEveryCharacter(s));
		System.out.println("<----------Reverse every word------------>>");
		System.out.println(reverseEveryWord(s));
	}

}
