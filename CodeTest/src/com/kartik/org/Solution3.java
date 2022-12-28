package com.kartik.org;

import java.util.Scanner;

public class Solution3 {
	
	
	public static void main(String[] args){
		
		   @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);  
		   System.out.println("First line of input contains an Integer K");  
		   @SuppressWarnings("unused")
		int k=sc.nextInt();  
		   System.out.println("Second line of input contains an Integer N"); 
		   int N=sc.nextInt();
		   int a[] = new int[N];
		   for (int i = 0; i < N; i++) {
			   int data=sc.nextInt();
			   a[i]=data;
		   }
		   
		   
		   
		   
	}
	
	static void function(int a[], int k){
		int c[] =new int[a.length];
		for(int j=0;j<a.length;j++){
			if(isPrime(a[j], 2)){
				c[0]=a[j];
			}else{
				for (int i = 0; i <a.length; i++) {
					if ((i + k) == j) {

						k++;
					}

				}
			}
		}
	}
	static int[] move(int a[]){
		
		return a;
		
	}

	// Returns true if n is prime, else
    // return false.
    // i is current divisor to check.
    static boolean isPrime(int n, int i)
    {
        // Base cases
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        // Check for next divisor
        return isPrime(n, i + 1);
    }
}
