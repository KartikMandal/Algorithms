package com.kartik.org;

import java.util.Arrays;

/**
 * Adding one to number represented as array of digits
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ). The digits are stored such that the most significant digit is first element of array.

Examples :

Input : [1, 2, 4]
Output : [1, 2, 5]

Input : [9, 9, 9]
Output : [1, 0, 0, 0]

 * @author kmandal
 *
 */
public class ArrayPlusOne {

	public int[] plusOne(int[] digits) {
	    if(digits==null||digits.length==0)
	        return new int[0];
	 
	    int carry = 1;    
	    for(int i=digits.length-1; i>=0; i--){
	        int sum = digits[i]+carry;
	        if(sum>=10){
	            carry=1;
	        }else{
	            carry=0;
	        }
	        digits[i]=sum%10;
	    }
	 
	    if(carry==1){
	        int[] result = new int[digits.length+1];
	        System.arraycopy(digits, 0, result, 1, digits.length);
	        result[0]=1;
	        return result;
	    }else{
	        //int[] result = new int[digits.length];
	        return digits;
	    }
	}
	
	
	public static void main(String[] args) {
		ArrayPlusOne a=new ArrayPlusOne();
		int[] b={0,9,9,9};
		System.out.println(Arrays.toString(a.plusOne(b)));
		
	}

}
