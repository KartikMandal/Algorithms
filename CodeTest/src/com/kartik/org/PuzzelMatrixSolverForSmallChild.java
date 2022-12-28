package com.kartik.org;

public class PuzzelMatrixSolverForSmallChild {

	// A utility function to count inversions in given 
	// array 'arr[]'. Note that this function can be 
	// optimized to work in O(n Log n) time. The idea 
	// here is to keep code small and simple. 
	static int getInvCount(int arr[][]) 
	{ 
		int N=arr.length;
	    int inv_count = 0; 
	    for (int i = 0; i < N * N - 1; i++) 
	    { 
	        for (int j = i + 1; j < N * N; j++) 
	        { 
	            // count pairs(i, j) such that i appears 
	            // before j, but i > j. 
	            if (arr[j][i]> arr[i][j]) 
	                inv_count++; 
	        } 
	    } 
	    return inv_count; 
	} 
	  
	// find Position of blank from bottom 
	static int findXPosition(int puzzle[][]) 
	{ 
		int N=puzzle.length;
	    // start from bottom-right corner of matrix 
	    for (int i = N - 1; i >= 0; i--) 
	        for (int j = N - 1; j >= 0; j--) 
	            if (puzzle[i][j] == 0) 
	                return N - i;
		return N; 
	} 
	  
	// This function returns true if given 
	// instance of N*N - 1 puzzle is solvable 
	static boolean isSolvable(int puzzle[][]) 
	{ 
		int N=puzzle.length;
	    // Count inversions in given puzzle 
	    int invCount = getInvCount(puzzle); 
	    // If grid is odd, return true if inversion 
	    // count is even. 
	    if ((N & 1) ==1) {
	        return !((invCount & 1)==1); 
	    }	  
	    else     // grid is even 
	    { 
	        int pos = findXPosition(puzzle); 
	        if ((pos & 1)==1) 
	            return !((invCount & 1)==1);  
	        else
	            return ((invCount & 1)==1); 
	    } 
	} 
	public static void main(String[] args) {
		int a[][]={{12, 1, 10, 2}, 
		        {7, 11, 4, 14}, 
		        {5, 0, 9, 15}, // Value 0 is used for empty space 
		        {8, 13, 6, 3}
		        };
		isSolvable(a);
	}

}
