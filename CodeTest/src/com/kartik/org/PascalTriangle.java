package com.kartik.org;

public class PascalTriangle {
	 public static void main(String[] args) {
	  PascalTriangle pt = new PascalTriangle();
	  int n = 6;
	  System.out.println("Simple procedure Pascal Triangle Display");
	  pt.pascaleTriangleSimple(n);
	  System.out.println();
	  System.out.println("Binomial procedure Pascal Triangle Display");
	  pt.pascaleTriangleBinomial(n);
	  System.out.println();
	  System.out.println("Recursive procedure Pascal Triangle Display");
	  pt.pascaleTriangleRecursive(n);
	 }
	 private void pascaleTriangleSimple(int n) {
	  int formatSpace = 4;
	  for (int i = 0; i < n; i++) {
	   int number = 1;
	   System.out.format("%" + (n - i) * formatSpace + "s", "");
	   for (int j = 0; j <= i; j++) {
	    System.out.format("%" + formatSpace * 2 + "d", number);
	    number = number * (i - j) / (j + 1);
	   }
	   System.out.println();
	  }
	 }
	 public void pascaleTriangleBinomial(int n) {
	  int formatSpace = 4;
	  for (int i = 0; i < n; i++) {
	   System.out.format("%" + (n - i) * formatSpace + "s", "");
	   for (int j = 0; j <= i; j++) {
	    System.out.format("%" + formatSpace * 2 + "d", nCk(i, j));
	   }
	   System.out.println();
	  }
	 }
	 /**
	  * nCk =!n/!n*!n-k
	  *
	  * @param n
	  * @param k
	  * @return
	  */
	 public long nCk(int n, int k) {
	  long numerator = fact(n);
	  long denominator = fact(k) * fact(n - k);
	  long result = (long) (numerator / denominator);
	  return result;
	 }
	 public long fact(long num) {
	  if (num <= 1)
	   return 1;
	  else
	   return num * fact(num - 1);
	 }
	 public void pascaleTriangleRecursive(int n) {
	  int formatSpace = 4;
	  for (int i = 0; i < n; i++) {
	   System.out.format("%" + (n - i) * formatSpace + "s", "");
	   for (int j = 0; j <= i; j++) {
	    System.out.format("%" + formatSpace * 2 + "d",
	      pascalRecursive(i, j));
	   }
	   System.out.println();
	  }
	 }
	 private int pascalRecursive(int i, int j) {
	  if (j == 0) {
	   return 1;
	  } else if (j == i) {
	   return 1;
	  } else {
	   return pascalRecursive(i - 1, j - 1) + pascalRecursive(i - 1, j);
	  }
	 }
	}
