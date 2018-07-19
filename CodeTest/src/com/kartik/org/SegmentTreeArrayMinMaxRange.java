package com.kartik.org;



public class SegmentTreeArrayMinMaxRange {

static Node[] tree;
	
	public static class Node
	{
		int minimum;
	    int maximum;
	}	
	
	// call this method as buildSegTree(arr, 0, 0, n-1);
	// Here arr[] is input array and n is its size.
	void buildSegTree(int []arr, int treeIndex, int lo, int hi)
	{
	    if (lo == hi) {                 // leaf node. store value in node.
	    	Node n=new Node();
	        n.minimum = arr[lo];
	        n.maximum = arr[hi];
	        tree[treeIndex] = n;
	        return;
	    }

	    int mid = lo + (hi - lo) / 2;   // recurse deeper for children.
	    buildSegTree(arr, 2 * treeIndex + 1, lo, mid);
	    buildSegTree(arr, 2 * treeIndex + 2, mid + 1, hi);
	 // left subtree has the minimum element
	    Node node=new Node();
	   node.minimum=Integer.min(tree[2 * treeIndex + 1].minimum, tree[2 * treeIndex + 2].minimum);
	   node.maximum=Integer.max(tree[2 * treeIndex + 1].maximum, tree[2 * treeIndex + 2].maximum);
	   tree[treeIndex]=node;
	}
	
	
	
	// call this method as querySegTree(0, 0, n-1, i, j);
	// Here [i,j] is the range/interval you are querying.
	// This method relies on "null" nodes being equivalent to storing zero.
	Node querySegTree(int treeIndex, int lo, int hi, int i, int j)
	{
	    // query for arr[i..j]
		Node dummy = new Node();
	    if (lo > j || hi < i){               // segment completely outside range
	    	dummy.minimum = dummy.maximum = Integer.MAX_VALUE;
	        return dummy;                       // represents a null node
	    }
	    if (i <= lo && j >= hi)             // segment completely inside range
	        return tree[treeIndex];

	    int mid = lo + (hi - lo) / 2;       // partial overlap of current segment and queried range. Recurse deeper.

	    if (i > mid)
	        return querySegTree(2 * treeIndex + 2, mid + 1, hi, i, j);
	    else if (j <= mid)
	        return querySegTree(2 * treeIndex + 1, lo, mid, i, j);

	    Node leftQuery = querySegTree(2 * treeIndex + 1, lo, mid, i, mid);
	    Node rightQuery = querySegTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);

	    Node ans = new Node();
	    ans.minimum = Integer.min(leftQuery.minimum, rightQuery.minimum);
	    ans.maximum=Integer.max(leftQuery.maximum,rightQuery.maximum); 
	    return ans;
	}
	
	
	
	public static void main(String[] args) {
		SegmentTreeArrayMinMaxRange t=new SegmentTreeArrayMinMaxRange();
		int arr[] = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7};
		int n = arr.length;
		 tree = new Node[4*n]; // Memory allocation
	        t.buildSegTree(arr, 0, 0, n-1);
	        System.out.println("\n");
	        for (int i = 0; i < tree.length; i++) {
	        	if(tree[i]!=null)
	        	 System.out.print(tree[i].minimum+" "+tree[i].maximum+"-->");
			}
	       System.out.println("\n");
	       Node node=t.querySegTree(0, 0, n-1, 0,n-1);
	        System.out.println("Minimum Data "+node.minimum+" maximum "+node.maximum);
	        node=t.querySegTree(0, 0, n-1, 2,5);
	        System.out.println("Minimum Data "+node.minimum+" maximum "+node.maximum);
	        node =t.querySegTree(0, 0, n-1, 0,1);
	        System.out.println("Minimum Data "+node.minimum+" maximum "+node.maximum);
	        node =t.querySegTree(0, 0, n-1, 3,5);
	        System.out.println("Minimum Data "+node.minimum+" maximum "+node.maximum);
	     }
}
