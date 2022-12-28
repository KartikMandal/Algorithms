package com.kartik.org;

/**
 * 
 * Consider the sorted array of strings A= {“”, “apple”, “”, “”, “ball”, “cat”, “”, “dog”, “”, “”, “”, “egg”, “”}. The array has empty strings interspersed in it. How will you efficiently search for strings in such an array?

We can use binary search to search the array of sorted strings. However since the array has empty strings in it, suppose we hit an empty string during binary search, we won’t know how to continue the search. To solve this problem we slightly modify the binary search and use the following strategy:

1. Binary search will occur between indexes low and high. If A[high] is an empty string, then we go on decrementing high till A[high] is a non-empty string. (Suppose we don’t find a non-empty string and we reach A[low], then all elements between low and high are empty strings. So we simply return indicating the search string was not found.)

2. We then find the mid element between low and high. If A[mid] is a non-empty string, then we proceed with the usual binary search. If A[mid] however is an empty string, then we go on incrementing mid till A[mid] is a non-empty string. Since A[high] already has a non-empty string, we will surely find a non-empty string when we keep incrementing mid.
 * 
 * 
 * @author kmandal
 *
 */

public class StringArrayBinarySearchTree {
	/*
	strings: sorted array of strings in which some of the strings can be empty ("")
	x: string to be searched
	Returns: index of x in the array strings if found, -1 otherwise
	*/
	public static int search(String[] strings, String x) {
	    int low = 0;
	    int high = strings.length - 1;
	 
	    while (low <= high) {
	        /*If we hit an empty string at position high, then keep 
	        decreasing high till we get a non-empty string*/
	        while (low <= high && strings[high] == "") 
	            --high;
	 
	        /*If we have only empty strings between low and high, then return
	         not found*/
	        if (low > high)
	            return -1;
	 
	        int mid = (low + high) / 2;
	        /*If we get an empty element at mid, then keep incrementing mid. 
	        We are guaranteed to find a non-empty string since strings[high]
	        is non-empty*/
	        while (strings[mid] == "")
	            mid = mid + 1; 
	 
	        /*Compare the mid element with the element being searched*/
	        int result = strings[mid].compareTo(x);
	 
	        if (result == 0) {
	            return mid;
	        } else if (result < 0) {
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		String[] a= {"", "apple", "", "","ball", "cat", "", "dog", "","","", "egg", ""};
		System.out.println("index number of cat is "+search(a, "cat"));
		System.out.println("index number of blank is "+search(a, ""));
		System.out.println("index number of egg is "+search(a, "egg"));

	}

}
