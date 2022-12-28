package com.kartik.org;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Given m sorted arrays each of which has a size n, merge the arrays in sorted order into a single array of size m*n

To efficiently solve the problem we use a heap which has a maximum size of m (number of sorted arrays). If the arrays are sorted in non-decreasing order, then we maintain a min heap otherwise we maintain a max heap. The algorithm is as follows

1. Pick the first element from each array, add it to the heap and construct the heap using the heapify function

2. Add the topmost element in the heap to the result array. Then replace the topmost element of the heap with the next element from the same array as the topmost element. Re-adjust the heap using the heapify function. Suppose all elements in the same array are over, then add a MAX_INT for non-decreasing order (MIN_INT for non-increasing order) into the root of the heap and re-adjust the heap using heapify. Repeat this step until all elements in all the arrays are processed.

Inserting an element into a heap of size m takes O(logm). Since we have n*m elements, the time complexity of this approach is O(nm * logm).

The code for merging k sorted lists is given below.
 * 
 * 
 * @author kmandal
 *
 */
public class ArrayMergeMSortedArray {
	
	static class Node {
		int value;
		int arrayNo;

		Node() {
		};

		Node(int value,int arrayNo) {
			this.value = value;
			this.arrayNo = arrayNo;
		}
	}
	
	/*
	arrays: the arrays to be merged. arrays[0] has the first array, arrays[1] has
	        the second array and so on
	Return value: the merged results are passed back in this array
	*/
	public static int[] mergeKSortedArrays(int[][] arrays) {
	    int k = arrays.length;  /*number of arrays*/
	    int n = arrays[0].length; /*number of elements in each array*/
	    Node[] heap = new Node[k];
	    int[] arrPos = new int[k];
	    int[] result = new int[k * n];
	 
	    /*Store the first element in each array into the heap*/
	    int i;
	    for (i = 0; i < k; ++i) {
	        heap[i] = new Node();
	        heap[i].value = arrays[i][0];
	        heap[i].arrayNo = i;
	        arrPos[i] = 1;
	    }
	 
	    /*Construct the initial heap using the heapify procedure*/
	    for (i = k - 1; i >= 0; --i)
	        heapify(heap, i, k);
	 
	     
	    /*
	    Process the remaining elements in the arrays. When all elements in the
	    arrays have been processed, MAX_INT will be present at root of heap
	    */
	    int resIndex = 0;
	    while (heap[0].value != Integer.MAX_VALUE) {
	        /*
	        root of the heap will have the lowest value. So store
	        it into the result
	        */
	        result[resIndex++] = heap[0].value;
	 
	        int arrayNo = heap[0].arrayNo;
	        int pos = arrPos[arrayNo];
	 
	        /*
	        If the root belongs to array x, then replace the root with
	        the next element in array x
	        */
	        if (pos >= n) {
	            /*If we have exhausted all elements in the array, 
	            then insert MAX_INT into the heap*/
	            heap[0].value = Integer.MAX_VALUE;
	            heap[0].arrayNo = arrayNo;
	        } else {
	            heap[0].value = arrays[arrayNo][pos];
	            heap[0].arrayNo = arrayNo;
	        }
	 
	        /*Re-adjust the heap after replacing the root*/
	        heapify(heap, 0, k);
	 
	        arrPos[arrayNo]++;
	    }
	 
	    return result;
	}
	 
	/* Helper function to perform heapify
	heap: min heap.  Maximum number of elements in heap is k
	pos: position of the heap that may need to be fixed
	heapSize: current number of nodes in the heap
	*/
	public static void heapify(Node[] heap, int pos, int heapSize) {
	    int left = 2 * pos;
	    int right = (2 * pos) + 1;
	    int ixOfSmallest = pos;
	 
	    /*Find which of the three are the smallest - heap[pos] OR left child
	    OR right child*/
	    if (left < heapSize && heap[pos].value > heap[left].value)
	        ixOfSmallest = left;
	    if (right < heapSize && heap[ixOfSmallest].value > heap[right].value)
	        ixOfSmallest = right;
	 
	 
	    if (ixOfSmallest != pos) {
	        /*
	        If pos doesn't contain the smallest value,
	        then swap the smallest value into pos 
	        */
	        Node temp = heap[pos];
	        heap[pos] = heap[ixOfSmallest];
	        heap[ixOfSmallest] = temp;
	 
	        /*Recursively re-adjust the heap*/
	        heapify(heap, ixOfSmallest, heapSize);
	    }
	}
	
	
	
	public static class ArrayContainer implements Comparable<ArrayContainer> {
		int[] arr;
		int index;
	 
		public ArrayContainer(int[] arr, int index) {
			this.arr = arr;
			this.index = index;
		}
	 
		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[this.index] - o.arr[o.index];
		}
	}
	
	public static int[] mergeKSortedArray(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total=0;
 
		//add arrays to heap
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
		}
 
		int m=0;
		int result[] = new int[total];
 
		//while heap is not empty
		while(!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[m++]=ac.arr[ac.index];
 
			if(ac.index < ac.arr.length-1){
				queue.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}
 
		return result;
	}
	
	
	public static void main(String[] args) {
		int num[][]={{2,3,4,7,8,9},{2,5,6,17,18,19},{22,24,31,71,81,91},{10,20,30,70,80,90}};
		System.out.println("--------------First Approach-------------");
		System.out.println();
		int[] sort=mergeKSortedArrays(num);
		System.out.println(Arrays.toString(sort));
		System.out.println("--------------Second Approach-------------");
		System.out.println();
		int[] sort1 =mergeKSortedArray(num);
		System.out.println(Arrays.toString(sort1));
	}

}
