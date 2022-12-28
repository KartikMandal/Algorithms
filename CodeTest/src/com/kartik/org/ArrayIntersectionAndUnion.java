package com.kartik.org;

import java.util.Arrays;
import java.util.HashSet;
/**
 * <code>Method 3 (Use Sorting and Searching)
Union:
1) Initialize union U as empty.
2) Find smaller of m and n and sort the smaller array.
3) Copy the smaller array to U.
4) For every element x of larger array, do following
…….b) Binary Search x in smaller array. If x is not present, then copy it to U.
5) Return U.

Intersection:
1) Initialize intersection I as empty.
2) Find smaller of m and n and sort the smaller array.
3) For every element x of larger array, do following
…….b) Binary Search x in smaller array. If x is present, then copy it to I.
4) Return I.

Time complexity of this method is min(mLogm + nLogm, mLogn + nLogn) which can also be written as O((m+n)Logm, (m+n)Logn). 
This approach works much better than the previous approach when difference between sizes of two arrays is significant.

Thanks to use_the_force for suggesting this method in a comment here.

Below is the implementation of this method.
</code>
 * @author kmandal
 *
 */
public class ArrayIntersectionAndUnion {
	
	public static void main(String[] args)  
    { 
		ArrayIntersectionAndUnion u_i = new ArrayIntersectionAndUnion(); 
        int arr1[] = {7, 1, 5, 2, 3, 6}; 
        int arr2[] = {3, 8, 6, 20, 7}; 
        int m = arr1.length; 
        int n = arr2.length; 
        
        System.out.println("---------------Start First step using Hashing--------------  ");
        System.out.println("------------                                  -----------  ");
        System.out.println("------------Union Time compexity is O(m+n)Logm-----------  ");
        u_i.printUnion(arr1, arr2, m, n);
        System.out.println("------------Intersection Time compexity is O(m+n)Logn----------");
        u_i.printIntersection(arr1, arr2, m, n);
        System.out.println();
        System.out.println("------------                                  -----------  ");
        System.out.println("------------End First step using Hashing--------------------  ");
        System.out.println();
        System.out.println();
        System.out.println("---------------Start Second step using Hashing--------------  ");
        System.out.println("------------                                  -----------  ");
        System.out.println("------------Union Time compexity is Thita(m+n)-----------  ");
        u_i.printUnion(arr1, arr2);
        System.out.println("------------Intersection Time compexity is O(1)----------  ");
        u_i.printIntersection(arr1, arr2);
        System.out.println();
        System.out.println("------------                                  -----------  ");
        System.out.println("------------End Second step using Hashing--------------------  ");
        
    } 
	// Prints union of arr1[0..m-1] and arr2[0..n-1] 
    void printUnion(int arr1[], int arr2[], int m, int n)  
    { 
        // Before finding union, make sure arr1[0..m-1]  
        // is smaller 
        if (m > n)  
        { 
            int tempp[] = arr1; 
            arr1 = arr2; 
            arr2 = tempp; 
  
            int temp = m; 
            m = n; 
            n = temp; 
        } 
  
        // Now arr1[] is smaller 
        // Sort the first array and print its elements (these two 
        // steps can be swapped as order in output is not important) 
        Arrays.sort(arr1); 
        for (int i = 0; i < m; i++) 
            System.out.print(arr1[i] + " "); 
  
        // Search every element of bigger array in smaller array 
        // and print the element if not found 
        for (int i = 0; i < n; i++)  
        { 
            if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1) 
                System.out.print(arr2[i] + " "); 
        } 
    } 
  
    // Prints intersection of arr1[0..m-1] and arr2[0..n-1] 
    void printIntersection(int arr1[], int arr2[], int m, int n)  
    { 
        // Before finding intersection, make sure arr1[0..m-1]  
        // is smaller 
        if (m > n)  
        { 
            int tempp[] = arr1; 
            arr1 = arr2; 
            arr2 = tempp; 
  
            int temp = m; 
            m = n; 
            n = temp; 
        } 
  
        // Now arr1[] is smaller 
        // Sort smaller array arr1[0..m-1] 
        Arrays.sort(arr1); 
  
        // Search every element of bigger array in smaller array 
        // and print the element if found 
        for (int i = 0; i < n; i++)  
        { 
            if (binarySearch(arr1, 0, m - 1, arr2[i]) != -1)  
                System.out.print(arr2[i] + " "); 
        } 
    } 
  
    // A recursive binary search function. It returns location of x in 
    // given array arr[l..r] is present, otherwise -1 
    int binarySearch(int arr[], int l, int r, int x)  
    { 
        if (r >= l)  
        { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then it can only  
            // be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present in array 
        return -1; 
    } 
    
    
 // Prints union of arr1[0..m-1] and arr2[0..n-1] 
     void printUnion(int arr1[], int arr2[]) 
    { 
        HashSet<Integer> hs = new HashSet<>(); 
          
        for (int i = 0; i < arr1.length; i++)  
            hs.add(arr1[i]);         
        for (int i = 0; i < arr2.length; i++)  
            hs.add(arr2[i]); 
        System.out.println(hs);         
    } 
      
    // Prints intersection of arr1[0..m-1] and arr2[0..n-1] 
     void printIntersection(int arr1[], int arr2[]) 
    { 
        HashSet<Integer> hs = new HashSet<>(); 
          
        for (int i = 0; i < arr1.length; i++)  
            hs.add(arr1[i]); 
          
        for (int i = 0; i < arr2.length; i++)  
            if (hs.contains(arr2[i])) 
               System.out.print(arr2[i] + " "); 
    } 
    
}
