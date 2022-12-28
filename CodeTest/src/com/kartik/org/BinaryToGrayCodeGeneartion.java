package com.kartik.org;

import static java.lang.StrictMath.pow;
/**
 * 
 * @author kmandal
 *
 */
public class BinaryToGrayCodeGeneartion {

	public static void main(String[] args) {
		String x = "";
		int n = 10;//number
		
		//convert number to binary
		while (n > 0) {
			int a = n % 2;
			x = a + x;
			n = n / 2;
		}
		System.out.println("Integer to Binary Conversion "+x);
		BinaryToGrayCodeGeneartion obj = new BinaryToGrayCodeGeneartion();
		int m = Integer.parseInt(x);
		int result = obj.grayCode(m, 0);
		System.out.println("Binary to Graycode Conversion "+result);

	}
/**
 * https://www.geeksforgeeks.org/digital-logic-code-converters-binary-gray-code/
 * @param x
 * @param i
 * @return
 */
	int grayCode(int x, int i) {
		int a, b, result = 0;
		if (x != 0) {
			a = x % 10;
			x = x / 10;
			b = x % 10;
			if ((a & ~b) == 1 || (~a & b) == 1) {
				result = (int) (result + pow(10, i));
			}
			return grayCode(x, ++i) + result;
		}
		return 0;
	}
}
