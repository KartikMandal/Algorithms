package com.kartik.org;

/**
 * You are given an array of n+2 elements. All elements of the array are in
 * range 1 to n. And all elements occur once except two numbers which occur
 * twice. Find the two repeating numbers. For example, array = {4, 2, 4, 5, 2,
 * 3, 1} and n = 5
 * 
 * The above array has n + 2 = 7 elements with all elements occurring once
 * except 2 and 4 which occur twice. So the output should be 4 2.
 * 
 * @author kmandal
 *
 */
public class ArrayFindTwoRepeatingElements {

	void printRepeating(int arr[], int size)  
    { 
        int count[] = new int[size]; 
        int i; 
  
        System.out.println("Repeated elements are : "); 
        for (i = 0; i < size; i++)  
        { 
            if (count[arr[i]] == 1) 
                System.out.print(arr[i] + " "); 
            else
                count[arr[i]]++; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
    	ArrayFindTwoRepeatingElements repeat = new ArrayFindTwoRepeatingElements(); 
        int arr[] = {4, 2, 4, 5, 2, 3, 1}; 
        int arr_size = arr.length; 
        repeat.printRepeating(arr, arr_size); 
    } 

}
