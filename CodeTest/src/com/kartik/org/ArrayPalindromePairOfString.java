package com.kartik.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author kmandal
 * Palindrome pair in an array of words (or strings)
Given a list of words, find if any of the two words can be joined to form a palindrome.

Examples:

Input  : list[] = {"geekf", "geeks", "or", 
                            "keeg", "abc", "bc"}
Output : Yes
There is a pair "geekf" and "keeg"

Input : list[] =  {"abc", "xyxcba", "geekst", "or",
                                      "keeg", "bc"}
Output : Yes
There is a pair "abc" and "xyxcba"
https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
 *
 */
public class ArrayPalindromePairOfString {

	// Utility function to check if a string is a 
    // palindrome 
    static boolean isPalindrome(String str) 
    { 
        int len = str.length(); 
       
        // compare each character from starting 
        // with its corresponding character from last 
        for (int i = 0; i < len/2; i++ ) 
            if (str.charAt(i) != str.charAt(len-i-1)) 
                return false; 
       
        return true; 
    } 
       
    // Function to check if a palindrome pair exists 
    static boolean checkPalindromePair(List<String> vect) 
    { 
        // Consider each pair one by one 
        for (int i = 0; i< vect.size()-1; i++) 
        { 
            for (int j = i+1; j< vect.size() ; j++) 
            { 
                String check_str = ""; 
       
                // concatenate both strings 
                check_str = check_str + vect.get(i) + vect.get(j); 
       
                // check if the concatenated string is 
                // palindrome 
                if (isPalindrome(check_str)) 
                    return true; 
            } 
        } 
        return false; 
    } 
       
    
    // Function to check if a palindrome pair exists 
    static List<String> checkPalindromePairList(List<String> vect) 
    { 
    	List<String> list=new ArrayList<>();
        // Consider each pair one by one 
        for (int i = 0; i< vect.size()-1; i++) 
        { 
            for (int j = i+1; j< vect.size() ; j++) 
            { 
                String check_str = ""; 
       
                // concatenate both strings 
                check_str = check_str + vect.get(i) + vect.get(j); 
       
                // check if the concatenated string is 
                // palindrome 
                if (isPalindrome(check_str)){ 
                	list.add(vect.get(i)+","+vect.get(j)) ;
                }
            } 
        } 
        return list; 
    } 
    // Driver code 
    public static void main(String args[]) 
    { 
        List<String> vect = Arrays.asList("geekf", "geeks", "or", 
                                "keeg", "abc", "bc"); 
       
       
       /* if (checkPalindromePair(vect) == true) 
            System.out.println("Yes"); 
        else    
            System.out.println("No");*/ 
        
        List<String> abc= checkPalindromePairList( vect);
        for (String string : abc) {
        	System.out.println(string);
		}
        
    } 

}
