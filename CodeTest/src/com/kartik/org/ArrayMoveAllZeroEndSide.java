package com.kartik.org;

/**
 * Move all the zeroes in an array to the right end of the array

We can move all the zeroes to one end of the array (in this case, the right end) in O(n) using the following technique:

1. Scan for the first zero from the left side of the array.

2. Scan for the first non-zero from the right side of the array.

3. Swap the zero and non-zero provided that the zero appears to the left of the non-zero

Input: 2 0 4 0 3 0 0 7 1 10 0 8 9 
Output:2 9 4 8 3 10 1 7 0 0 0 0 0 
 * @author kmandal
 *
 */
public class ArrayMoveAllZeroEndSide {

	/*
	a: input array in which the zeroes should be moved to one end
	*/
	public static int[] moveZeroes(int[] a) {
	    int length = a.length;
	 
	    int left = 0;
	    int right = length - 1;
	 
	    while (left < right) {
	        /*Locate the first zero from the left*/
	        while (left < length && a[left] != 0)
	            left++;
	 
	        /*Locate first non-zero from the right*/
	        while (right >= 0 && a[right] == 0)
	            right--;
	 
	        if (left < right) {
	            /*Swap a[left] and a[right]*/
	            int temp = a[left];
	            a[left] = a[right];
	            a[right] = temp;
	        }
	    }
	    return a;
	}
	
	/**
	 * With best case time complexity is O(n)
	 * @param arr
	 * @param n
	 * arr[]={2,0,4,0,3,0,0,7,1,10,0,8,9}
	 * 
	 * count	i	conditionarr[i]!=0	temp=arr[count]	arr[count]=arr[i]	arr[i]=temp
	 * 0	 	0	2!=0				2				arr[0]=2			arr[0]=2
	 * 1		1	0!=0													
	 * 1		2	4!=0				0				arr[1]=4			arr[2]=0
	 * 2		3	0!=0
	 * 2		4	3!=0				0				arr[2]=3			arr[3]=0
	 * 3		5	0!=0
	 * 3		6	0!=0
	 * 3		7	7!=0				0				arr[3]=7			arr[7]=0
	 * 4		8	1!=0				0				arr[4]=1			arr[8]=0
	 * 5		9	10!=0				0				arr[5]=10			arr[9]=0
	 * 6		10	0!=0				
	 * 6		11	8!=0				0				arr[6]=8			arr[11]=0
	 * 7		12	9!=0				0				arr[7]=9			arr[12]=0				
	 * 
	 */
	// function to move all zeroes at 
	// the end of array 
	static void moveZerosToEnd(int arr[], int n) { 
	      
	    // Count of non-zero elements 
	    int count = 0; 
	    int temp; 
	  
	    // Traverse the array. If arr[i] is  
	    // non-zero, then swap the element at  
	    // index 'count' with the element at  
	    // index 'i' 
	    for (int i = 0; i < n; i++) { 
	    if (arr[i] != 0) { 
	    	//Swap start
	        temp = arr[count]; 
	        arr[count] = arr[i]; 
	        arr[i] = temp; 
	        //swap end
	        count = count + 1; 
	    } 
	    } 
	} 
	
	  
	// function to print the array elements 
	static void printArray(int arr[]) { 
		for (int i : arr) {
			System.out.print(i+" ");
		}
	   
	} 
	
	
	public static void main(String[] args) {
		int num[]={2,0,4,0,3,0,0,7,1,10,0,8,9};
		/*for (int i : num) {
			System.out.print(i+" ");
		}
		System.out.println();
		int a[]=moveZeroes(num);
		for (int i : a) {
			System.out.print(i+" ");
		}*/
		
		int num1[]={2,0,4,0,3,0,0,7,1,10,0,8,9};
		System.out.println("Original array: "); 
		 printArray(num1); 
		moveZerosToEnd(num1, num1.length);
		System.out.print("\nModified array: "); 
	    printArray(num1); 

	}

}
