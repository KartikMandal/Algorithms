package com.kartik.demo;

import java.util.Scanner;

public class CharacterFrequency {

		static int MAX = 26;
	     
	    // Function to print the frequency
	    // of each of the characters of
	    // s in alphabetical order
	    static void compressString(String s)
	    {
	    	int n=s.length();
	        // To store the frequency
	        // of the characters
	        int freq[] = new int[MAX] ;
	     
	        // Update the frequency array
	        for (int i = 0; i < n; i++)
	        {
			/**
			 * if input is eeabbacde after two iteration [0, 0, 0, 0, 2, 0, 0,
			 * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
			 * 
			 * and last iteration
			 * [2, 2, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
			 */
	            freq[s.charAt(i) - 'a']++;
	        }
	     
	        // Print the frequency in alphatecial order
	        for (int i = 0; i < MAX; i++)
	        {
	     
	            // If the current alphabet doesn't
	            // appear in the string
	            if (freq[i] == 0)
	                continue;
	            // (char)(i + 'a') if i =0 print a
	            // (char)(i + 'a') if i =1 print b
	            System.out.print((char)(i + 'a') +""+ freq[i]);
	        }
	    }
	    
		public static void main(String args[])
		{
			String str ="eeabbacde";
			//Scanner sc = new Scanner(System.in);
			//str = sc.nextLine();
			compressString(str);
		}
	}