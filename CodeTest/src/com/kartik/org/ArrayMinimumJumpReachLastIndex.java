package com.kartik.org;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * http://romanenco.com/jumps-problem
 * 
 * https://www.youtube.com/watch?v=jH_5ypQggWg
 * @author kmandal
 * 
 * 
 * Given an array of integers where each element represents the max number of steps 
 * that can be made forward from that element. Write a function to return the minimum 
 * number of jumps to reach the end of the array
 *
 */
public class ArrayMinimumJumpReachLastIndex {
	static class Node {
		LinkedList<Integer> value=new LinkedList<Integer>();
		boolean flag;

		Node() {
		};

		Node(LinkedList<Integer> value,boolean flag) {
			this.value = value;
			this.flag = flag;
		}
	}

	public static Node canJump(int[] array) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Node node = new Node();
		for (int i = 0; i < array.length;) {
			if (i >= array.length - 1) {
				node.flag = true;
				return node;
			}
			if (array[i] == 0) {
				node.value.add(0);
				node.flag = false;
				return node;
			}
			i += array[i];
			node.value.add(i);
		}
		return node;
	}
	
	/**
	 * @param a
	 */
	private static void display(int[] a) {
		Node n = canJump(a);
		if (n.flag) {
			LinkedList<Integer> l = n.value;
			System.out.print("Output " +l.size()+"(");
			for (Integer i : l) {
				System.out.print(i + "->");
			}
			System.out.print(")");
		}else{
			System.out.println("Not get optimal solun");
		}
	}
	
	
	
	
	// Returns minimum number of NumOfJumps to reach end from start
	private static int MinJumps(int array[], int n)
	{
	    int[] jumps_array = new int[n];
	    if (n == 0 || array[0] == 0)
	    {
	        return Integer.MAX_VALUE;
	    }
	    jumps_array[0] = 0;//initializing jumps_array
	    for (int i = 1; i < n; ++i)
	    {
	        jumps_array[i] = Integer.MAX_VALUE;
	    }
	    for (int i = 1; i < n; i++)
	    {
	        for (int j = 0; j < i; j++)
	        {
	            if (i <= j + array[j] && jumps_array[j] != Integer.MAX_VALUE)//minimum number jumps to reach i 
	            {
	                 jumps_array[i] = min(jumps_array[i], jumps_array[j] + 1);//by comparing with previous points
	                 break;
	            }
	        }
	    }
	    return jumps_array[n-1];
	}
	private static int min(int x, int y)
	{
	    if(x < y)
	    {
	        return x;
	    }
	    else
	    {
	        return y;
	    }   
	}

	
	// Returns minimum number of NumOfJumps to reach arr[high] from arr[low]
	public static int MinJumps(int arr[], int low, int high)
	{
	   if (high == low)//source and destination are same.
	   {
	     return 0;
	   }
	   if (arr[low] == 0)//cannot move forward,
	   {
	     return Integer.MAX_VALUE;
	   }
	   int MinNumOfJumps = Integer.MAX_VALUE;//initialize to INT_MAX
	  
	   //Recursively calling for all reacheble points. 
	   for (int i = low+1; i<= high && i <= low + arr[low]; i++)
	   {
	       int NumOfJumps = MinJumps(arr, i, high);
	       if(NumOfJumps != Integer.MAX_VALUE && NumOfJumps + 1 < MinNumOfJumps)
	       {
	           MinNumOfJumps = NumOfJumps + 1;
	       }
	   }
	   return MinNumOfJumps;
	}
	
	
	
	public static int jump(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        final int[] memo = new int[A.length];
        Arrays.fill(memo, -1);
        return jump(A, 0, memo);
    }

    private static int jump(int[] A, int index, int[] memo) {
        if (index >= A.length - 1) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= A[index]; i++) {
            min = Math.min(min, 1 + jump(A, index + i, memo));
        }
        memo[index] = min;
        return min;
    }
	
	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 1, 4 };
		System.out.println("-----------First method --------------------");
		display(a);
		System.out.println();
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		display(arr);
		System.out.println("-----------Second method --------------------");
		System.out.println(MinJumps(a, a.length));
		
		System.out.println("-----------Third method --------------------");
		System.out.println(MinJumps(a,0, a.length-1));
		
		System.out.println("-----------4th method --------------------");
		System.out.println(jump(a));
		
	}

	

}
