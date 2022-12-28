package com.kartik.demo;

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

		int n = findOutFirstDigit(number);
		if (n > 0) {
			return String.valueOf(n) + matrix[number % 26];
		} else {
			return String.valueOf(matrix[number % 26]);
		}
	}

	 public static int firstDigit = 0;

	 /**
	  *
	  * @param number
	  * @return
	  */
	 public static int findOutFirstDigit(int number) {
	  if (number > 25) {
	   firstDigit++;
	   findOutFirstDigit(number - 25);
	  }
	  return firstDigit;
	 }
	 
	 
	 private static void printString(int columnNumber)
	    {
	        // To store result (Excel column name)
	        StringBuilder columnName = new StringBuilder();
	 
	        while (columnNumber > 0) {
	            // Find remainder
	            int rem = columnNumber % 26;
	 
	            // If remainder is 0, then a
	            // 'Z' must be there in output
	            if (rem == 0) {
	                columnName.append("Z");
	                columnNumber = (columnNumber / 26) - 1;
	            }
	            else // If remainder is non-zero
	            {
	                columnName.append((char)((rem - 1) + 'A'));
	                columnNumber = columnNumber / 26;
	            }
	        }
	 
	        // Reverse the string and print result
	        System.out.println(columnName.reverse());
	    }

	 /**
	  *
	  */
	 public static void main(String[] args) {
	  // Excel File Column number get by.
	 /* System.out.println("Excel file column no->" + columnNumber(15));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(25));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(255));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(2700));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(1));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(0));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(2));
	  firstDigit = 0;
	  System.out.println("Excel file column no->" + columnNumber(26));
	  firstDigit = 0;
	  printString(27);*/
	  //printString(30);
	  printString(52);
	  //System.out.println("Excel file column no->" + printString("107W"));
	  
	 }
	}