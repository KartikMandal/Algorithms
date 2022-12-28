package com.kartik.org;

public class SegmentTreeArrayQueryLcm {

static int tree[];
	
//Function to return gcd of a and b
		int gcd(int a, int b)
		{
		    
		    /*if(b==0 && a == 0)
		    	return 1;*/
		    if (a == 0)
		        return b;
		    return gcd(b%a, a);
		}
		 
		//utility function to find lcm
		int lcm(int a, int b)
		{
		    return a*b/gcd(a,b);
		}
	
	// call this method as buildSegTree(arr, 0, 0, n-1);
	// Here arr[] is input array and n is its size.
	void buildSegTree(int []arr, int treeIndex, int lo, int hi)
	{
	    if (lo == hi) {                 // leaf node. store value in node.
	        tree[treeIndex] = arr[lo];
	        return;
	    }

	    int mid = lo + (hi - lo) / 2;   // recurse deeper for children.
	    buildSegTree(arr, 2 * treeIndex + 1, lo, mid);
	    buildSegTree(arr, 2 * treeIndex + 2, mid + 1, hi);

	    // merge build results
	    tree[treeIndex] = lcm(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
	}
	
	
	
	// call this method as querySegTree(0, 0, n-1, i, j);
	// Here [i,j] is the range/interval you are querying.
	// This method relies on "null" nodes being equivalent to storing zero.
	int querySegTree(int treeIndex, int lo, int hi, int i, int j)
	{
	    // query for arr[i..j]

	    if (lo > j || hi < i)               // segment completely outside range
	        return 0;                       // represents a null node

	    if (i <= lo && j >= hi)             // segment completely inside range
	        return tree[treeIndex];

	    int mid = lo + (hi - lo) / 2;       // partial overlap of current segment and queried range. Recurse deeper.

	    if (i > mid)
	        return querySegTree(2 * treeIndex + 2, mid + 1, hi, i, j);
	    else if (j <= mid)
	        return querySegTree(2 * treeIndex + 1, lo, mid, i, j);

	    int leftQuery = querySegTree(2 * treeIndex + 1, lo, mid, i, mid);
	    int rightQuery = querySegTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);

	    // merge query results
	    return lcm(leftQuery, rightQuery);
	}

	
	public static void main(String[] args) {
		 int arr[] = {5, 7, 5, 2,10,12,11,17,14,1,44};
		int n = arr.length;
        SegmentTreeArrayQueryLcm  t = new SegmentTreeArrayQueryLcm();
        tree = new int[4*n]; // Memory allocation
        t.buildSegTree(arr, 0, 0, n-1);
        System.out.println("\n");
        for (int i = 0; i < tree.length; i++) {
        	 System.out.print(tree[i]+" ");
		}
       System.out.println("\n");
        System.out.println(t.querySegTree(0, 0, n-1, 0,n-1));
        System.out.println(t.querySegTree(0, 0, n-1, 5,10));
        System.out.println(t.querySegTree(0, 0, n-1, 2,5));

	}

}