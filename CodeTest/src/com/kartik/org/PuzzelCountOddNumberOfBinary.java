package com.kartik.org;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * 
 * @author kmandal
 *
 */
public class PuzzelCountOddNumberOfBinary {

	public static long count(String str,long count,char match){
		 
		for (int i = 0; i < str.length(); i++) {
			   for (int j = i+1; j <= str.length(); j++) {
				   int innerCount = 0;
				   String s=str.substring(i,j);
				   
				   for (int k = 0; k < s.length(); k++) {
				       if (s.charAt(k) == match) {
				    	   innerCount++;
				       }
				       System.out.print(s.charAt(k));
				       
				   }
				   if(innerCount%2!=0){
					   count++;
				   }
			  
			   }
			   System.out.println();
			  }
		return count;
	}
	
	public static String dataToBinaryConvert(BigDecimal bd){
		//BigDecimal bd = new BigDecimal(b);
		  int n = 0;  // constant?
		  BigInteger bi = bd.toBigInteger();
		    StringBuilder str = new StringBuilder(bi.toString(2));
		    while (str.length() < n+1) {  // +1 for leading zero
		        str.insert(0, "0");
		    }
		   // str.insert(str.length()-n, ".");
		    String s=str.toString();
			return s;
	}
	
	// Driver code  
	 /* public static void main(String[] args) { 
		//  String s=Long.toBinaryString(17);
		  BigDecimal bd = new BigDecimal("89999999999994552010883873777737777377879999999898999999999");
		  int n = 0;  // constant?
		  BigInteger bi = bd.toBigInteger();
		    StringBuilder str = new StringBuilder(bi.toString(2));
		    while (str.length() < n+1) {  // +1 for leading zero
		        str.insert(0, "0");
		    }
		    String s=str.toString();
		  System.out.println(s);
		  System.out.println();
		  System.out.println(count(s,0,'0'));
	    } */

	/**
	 * 
	 * @param b1 this is big value
	 * @param b2 this is small value
	 * @return if(b1<b2) --true
	 *         else if b1==b2 && b1>b2 false
	 */
	public static boolean com(BigDecimal b1,BigDecimal b2){
		 
        if ((b1.compareTo(b2) == 0) || (b1.compareTo(b2) == 1)) { 
          //  System.out.println(b1 + " and " + b2 + " are equal."); 
            return false;
        } 
       /* else if (b1.compareTo(b2) == 1) { 
            System.out.println(b1 + " is greater than " + b2 + "."); 
        }*/ 
        else { 
           // System.out.println(b1 + " is lesser than " + b2 + "."); 
            return true;
        } 
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			int T = scanner.nextInt();
			// 1 <= T <= 10
			if (T <= 0 && T > 100) {
				return;
			}
			// System.out.println(T);
			for (int j = 0; j < T; j++) {
				BigDecimal N = scanner.nextBigDecimal();
				// 1 <= N <= 1e+200
				BigDecimal zero=new BigDecimal(0);
				BigDecimal max=new BigDecimal(Math.pow(10, 200));
				if (com(N, zero) && com(max,N)) {
					return;
				} else {
					//String s=Long.toBinaryString(N);
					String s=dataToBinaryConvert(N);
					System.out.println(s);
					System.out.println(count(s,0,'0')+" "+count(s,0,'1'));
				}
				
			}

		} catch (Exception e) {
			System.out.println();
		}

	}

	}
