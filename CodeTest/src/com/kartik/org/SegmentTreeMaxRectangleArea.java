package com.kartik.org;

public class SegmentTreeMaxRectangleArea {

	int max(int x, int y){
		if(x>y) return x;
		else return y;
	}
	// A utility function to find minimum of three integers
	int max(int x, int y, int z)
	{  return max(max(x, y), z); }
	 
	// A utility function to get minimum of two numbers in hist[]
	int minVal(int hist[], int i, int j)
	{
	    if (i == -1) return j;
	    if (j == -1) return i;
	    return (hist[i] < hist[j])? i : j;
	}
	 
	// A utility function to get the middle index from corner indexes.
	int getMid(int s, int e)
	{   return s + (e -s)/2; }
	 
	/*  A recursive function to get the index of minimum value in a given range of
	    indexes. The following are parameters for this function.
	 
	    hist   --> Input array for which segment tree is built
	    st    --> Pointer to segment tree
	    index --> Index of current node in the segment tree. Initially 0 is
	             passed as root is always at index 0
	    ss & se  --> Starting and ending indexes of the segment represented by
	                 current node, i.e., st[index]
	    qs & qe  --> Starting and ending indexes of query range */
	int rangeMinimumQueryUtil(int []hist, int []st, int ss, int se, int qs, int qe, int index)
	{
	    // If segment of this node is a part of given range, then return the
	    // min of the segment
	    if (qs <= ss && qe >= se)
	        return st[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return -1;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = getMid(ss, se);
	    return minVal(hist, rangeMinimumQueryUtil(hist, st, ss, mid, qs, qe, 2*index+1),
	                  rangeMinimumQueryUtil(hist, st, mid+1, se, qs, qe, 2*index+2));
	}
	 
	// Return index of minimum element in range from index qs (quey start) to
	// qe (query end).  It mainly uses RMQUtil()
	int rangeMinimumQuery(int []hist, int []st, int n, int qs, int qe)
	{
	    // Check for erroneous input values
	    if (qs < 0 || qe > n-1 || qs > qe)
	    {
	        System.out.println("Invalid Input");
	        return -1;
	    }
	 
	    return rangeMinimumQueryUtil(hist, st, 0, n-1, qs, qe, 0);
	}
	 
	// A recursive function that constructs Segment Tree for hist[ss..se].
	// si is index of current node in segment tree st
	int buildSegtmentTreeUtil(int hist[], int ss, int se, int []st, int si)
	{
	    // If there is one element in array, store it in current node of
	    // segment tree and return
	    if (ss == se)
	       return (st[si] = ss);
	 
	    // If there are more than one elements, then recur for left and
	    // right subtrees and store the minimum of two values in this node
	    int mid = getMid(ss, se);
	    st[si] =  minVal(hist, buildSegtmentTreeUtil(hist, ss, mid, st, si*2+1),
	                     buildSegtmentTreeUtil(hist, mid+1, se, st, si*2+2));
	    return st[si];
	}
	 
	/* Function to construct segment tree from given array. This function
	   allocates memory for segment tree and calls constructSTUtil() to
	   fill the allocated memory */
	int []buildSegtmentTree(int hist[], int n)
	{
	    // Allocate memory for segment tree
	  //  int x = (int)(Math.ceil(Math.log(n))); //Height of segment tree
	    int max_size = power(2,n) - 1; //Maximum size of segment tree as a binary tree furmula ...
	    int []st = new int[max_size];
	 
	    // Fill the allocated memory st
	    buildSegtmentTreeUtil(hist, 0, n-1, st, 0);
	 
	    // Return the constructed segment tree
	    return st;
	}
	 
	public int power(int base, int powerRaised) {
	    if (powerRaised != 0)
	        return (base * power(base, powerRaised - 1));
	    else
	        return 1;
	}
	// A recursive function to find the maximum rectangular area.
	// It uses segment tree 'st' to find the minimum value in hist[l..r]
	int getMaxAreaRec(int hist[], int []st, int n, int l, int r)
	{
	    // Base cases
	    if (l > r)  return Integer.MIN_VALUE;
	    if (l == r)  return hist[l];
	 
	    // Find index of the minimum value in given range
	    // This takes O(Logn)time
	    int m = rangeMinimumQuery(hist, st, n, l, r);
	 
	    /* Return maximum of following three possible cases
	       a) Maximum area in Left of min value (not including the min)
	       a) Maximum area in right of min value (not including the min)
	       c) Maximum area including min */
	    return max(getMaxAreaRec(hist, st, n, l, m-1),
	               getMaxAreaRec(hist, st, n, m+1, r),
	               (r-l+1)*(hist[m]) );
	}
	 
	// The main function to find max area
	int getMaxArea(int hist[], int n)
	{
	    // Build segment tree from given array. This takes
	    // O(n) time
	    int []st = buildSegtmentTree(hist, n);
	 
	    // Use recursive utility function to find the
	    // maximum area
	    return getMaxAreaRec(hist, st, n, 0, n-1);
	}
	 
	// Driver program to test above functions

	public static void main(String[] args) {
		int hist[] =  {6, 1, 5, 4, 5, 2, 6};
		//int hist[] = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7};
		SegmentTreeMaxRectangleArea mx=new SegmentTreeMaxRectangleArea();
		System.out.println(mx.getMaxArea(hist, hist.length));
	}

}
