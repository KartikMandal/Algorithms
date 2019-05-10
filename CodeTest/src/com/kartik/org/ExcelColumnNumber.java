package com.kartik.org;
/**
 * 
 * @author kmandal
 *
 */
public class ExcelColumnNumber {
	 /**
	  *
	  */
	 public static final char[] matrix = new char[] { 'A', 'B', 'C', 'D', 'E',
	   'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
	   'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	 /**
	  *
	  * @param number
	  * @return
	  */
	 public static String columnNumber(int number) {
	  return String.valueOf(findOutFirstDigit(number)) + matrix[number % 26];
	 }

	 public static int firstDigit = 0;

	 /**
	  *
	  * @param number
	  * @return
	  */
	 public static int findOutFirstDigit(int number) {
	  if (number > 26) {
	   firstDigit++;
	   findOutFirstDigit(number - 26);
	  }
	  return firstDigit;
	 }

	 /**
	  *
	  */
	 public static void main(String[] args) {
	  // Excel File Column number get by.
	  System.out.println("Excel file column no->" + columnNumber(90));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(25));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(255));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(2700));
	  firstDigit = 0;
	 }
	}