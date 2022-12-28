package com.kartik.org;


public class SegmentTreeMatrixChainMultiplication {
	
	static Node tree[];
	
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n 
     int MatrixChainOrder(int p[], int n) 
    { 
        /* For simplicity of the program, one extra row and one 
        extra column are allocated in m[][].  0th row and 0th 
        column of m[][] are not used */
        int m[][] = new int[n][n]; 
  
        int i, j, k, L, q; 
  
        /* m[i,j] = Minimum number of scalar multiplications needed 
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where 
        dimension of A[i] is p[i-1] x p[i] */
  
        // cost is zero when multiplying one matrix. 
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
        // L is chain length. 
        for (L=2; L<n; L++) 
        { 
            for (i=1; i<n-L+1; i++) 
            { 
                j = i+L-1; 
                if(j == n) continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k=i; k<=j-1; k++) 
                { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n-1]; 
    } 
  
    // Driver 
	
	
	
	public static class Node
	{
		int minimum_cost;
	    String multiply_opeartion_with_parenthesis;
	}
	int merge(int a,int b){
		return a+b;
	}
	
	// call this method as buildSegTree(arr, 0, 0, n-1);
		// Here arr[] is input array and n is its size.
		void buildSegTree(int []arr, int treeIndex, int lo, int hi)
		{
			 if (lo == hi) {                 // leaf node. store value in node.
			    	Node n=new Node();
			        n.minimum_cost = arr[lo];
			        n.multiply_opeartion_with_parenthesis = null;
			        tree[treeIndex] = n;
			        return;
			    }

			    int mid = lo + (hi - lo) / 2;   // recurse deeper for children.
			    buildSegTree(arr, 2 * treeIndex + 1, lo, mid);
			    buildSegTree(arr, 2 * treeIndex + 2, mid + 1, hi);
			 // left subtree has the minimum element
			    Node node=new Node();
			   node.minimum_cost=Integer.min(tree[2 * treeIndex + 1].minimum_cost, tree[2 * treeIndex + 2].minimum_cost);
		}
		
		
		
		// call this method as querySegTree(0, 0, n-1, i, j);
		// Here [i,j] is the range/interval you are querying.
		// This method relies on "null" nodes being equivalent to storing zero.
		Node querySegTree(int treeIndex, int lo, int hi, int i, int j)
		{
			 // query for arr[i..j]
			Node dummy = new Node();
		    if (lo > j || hi < i){               // segment completely outside range
		    	dummy.minimum_cost = Integer.MAX_VALUE;
		    	dummy.multiply_opeartion_with_parenthesis = null;
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
//https://www.youtube.com/watch?v=eKkXU3uu2zk
		    Node ans = new Node();
		    ans.minimum_cost = Integer.min(leftQuery.minimum_cost, rightQuery.minimum_cost);
		    ans.multiply_opeartion_with_parenthesis=""; 
		    return ans;
		}
	
	public static void main(String[] args) {
		 int arr[] = {40, 20, 30, 10, 30};
	        int n = arr.length;
	        SegmentTreeMatrixChainMultiplication  t = new SegmentTreeMatrixChainMultiplication();
	        tree = new Node[4*n]; // Memory allocation
	        t.buildSegTree(arr, 0, 0, n-1);
	        System.out.println("\n");
	        for (int i = 0; i < tree.length; i++) {
	        	 System.out.print(tree[i]+" ");
			}
	       System.out.println("\n");
	        System.out.println(t.querySegTree(0, 0, n-1, 0,n-1));
	        System.out.println(t.querySegTree(0, 0, n-1, 2,5));
	        System.out.println(t.querySegTree(0, 0, n-1, 0,1));

	}
	//https://sites.google.com/site/indy256/algo_cpp/segment_tree
}
