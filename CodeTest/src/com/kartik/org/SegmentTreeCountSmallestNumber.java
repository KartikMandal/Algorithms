package com.kartik.org;


public class SegmentTreeCountSmallestNumber {

	static Node[] tree;
	
	public static class Node
	{
		int min;
	    int cnt;
		
	}	
	
	 
	int min(int x,int y){
		if(x>y)return y;
		else return x;
	}
	
	// call this method as buildSegTree(arr, 0, 0, n-1);
	// Here arr[] is input array and n is its size.
	void buildSegTree(int []arr, int treeIndex, int lo, int hi)
	{
	    if (lo == hi) {                 // leaf node. store value in node.
	    	Node n=new Node();
	        n.min = arr[lo];
	        n.cnt = 1;
	        tree[treeIndex] = n;
	        return;
	    }

	    int mid = lo + (hi - lo) / 2;   // recurse deeper for children.
	    buildSegTree(arr, 2 * treeIndex + 1, lo, mid);
	    buildSegTree(arr, 2 * treeIndex + 2, mid + 1, hi);
	 // left subtree has the minimum element
	    Node left=null;
	    if (tree[2 * treeIndex + 1].min < tree[2 * treeIndex + 2].min) {
	    	left=new Node();
	        left.min = tree[2 * treeIndex + 1].min;
	        left.cnt = tree[2 * treeIndex + 1].cnt;
	        tree[treeIndex]=left;
	    }
	 
	    // right subtree has the minimum element
	    else if (tree[2 * treeIndex + 1].min > tree[2 * treeIndex + 2].min) {
	    	left=new Node();
	        left.min = tree[2 * treeIndex + 2].min;
	        left.cnt = tree[2 * treeIndex + 2].cnt;
	        tree[treeIndex]=left;
	    }
	 
	    // both subtree has the same minimum element
	    else {
	    	left=new Node();
	        left.min = tree[2 * treeIndex + 1].min;
	        left.cnt = tree[2 * treeIndex + 1].cnt + tree[2 * treeIndex + 2].cnt;
	        tree[treeIndex]=left;
	    }
	}
	
	
	
	// call this method as querySegTree(0, 0, n-1, i, j);
	// Here [i,j] is the range/interval you are querying.
	// This method relies on "null" nodes being equivalent to storing zero.
	Node querySegTree(int treeIndex, int lo, int hi, int i, int j)
	{
	    // query for arr[i..j]
		Node dummy = new Node();
	    if (lo > j || hi < i){               // segment completely outside range
	    	dummy.min = dummy.cnt = Integer.MAX_VALUE;
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
	    ans.min = min(leftQuery.min, rightQuery.min);
	 
	    // add count when min is same of both subtree
	    if (leftQuery.min == rightQuery.min)
	        ans.cnt = rightQuery.cnt + leftQuery.cnt;
	 
	    // store the minimal's count
	    else if (leftQuery.min < rightQuery.min)
	        ans.cnt = leftQuery.cnt;
	 
	    else
	        ans.cnt = rightQuery.cnt;
	 
	    return ans;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		SegmentTreeCountSmallestNumber t=new SegmentTreeCountSmallestNumber();
		int arr[] = { 1, 1, 2, 4, 3, 3 };
		int n = arr.length;
		 tree = new Node[4*n]; // Memory allocation
	        t.buildSegTree(arr, 0, 0, n-1);
	        System.out.println("\n");
	        for (int i = 0; i < tree.length; i++) {
	        	if(tree[i]!=null)
	        	 System.out.print(tree[i].min+" "+tree[i].cnt+"-->");
			}
	       System.out.println("\n");
	       Node node=t.querySegTree(0, 0, n-1, 0,n-1);
	        System.out.println("Minimum Data-"+node.min+" Count "+node.cnt);
	        node=t.querySegTree(0, 0, n-1, 2,5);
	        System.out.println("Minimum Data-"+node.min+" Count "+node.cnt);
	        node =t.querySegTree(0, 0, n-1, 0,1);
	        System.out.println("Minimum Data-"+node.min+" Count "+node.cnt);
	        node =t.querySegTree(0, 0, n-1, 3,5);
	        System.out.println("Minimum Data-"+node.min+" Count "+node.cnt);
	     }

}
