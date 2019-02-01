package com.kartik.org;

/**
 *      		  4
               /      \
         	-2         6
           /   \      /  \ 
     	  8     -4    7    5
should be same

                  4
               /      \
         	-2         6
           /   \      /  \ 
     	  8     -4    7    5
 * @author kmandal
 *
 */
//https://www.geeksforgeeks.org/total-sum-except-adjacent-of-a-given-node-in-bst/
public class BinaryTreetotalSumExceptAdjecent {

	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
	
	// total sum of bst
	static int sum(TreeNode root)
	{
	    if (root == null)
	        return 0;
	 
	    return root.data + sum(root.left) + sum(root.right);
	}
	 
	// sum of all element except those which are adjecent to key TreeNode
	static int adjSum(TreeNode root, int key)
	{
	 
	    int parent = root.data;
	 
	    while (root != null) {
	        if (key < root.data) {
	            parent = root.data; 
	            root = root.left;
	        }
	        else if (root.data == key) // key TreeNode matches
	        {
	            // if the left TreeNode and right TreeNode of key is 
	            // not null then add all adjecent TreeNode and
	            // substract from totalSum
	            if (root.left != null && root.right != null)
	                return (parent + root.left.data + root.right.data);
	 
	            // if key is leaf
	            if (root.left == null && root.right == null)
	                return parent;
	 
	            // If only left child is null
	            if (root.left == null) 
	                return (parent + root.right.data);
	 
	            // If only right child is NULL
	            if (root.right == null) 
	                return (parent + root.left.data);
	        }
	 
	        else {
	            parent = root.data;
	            root = root.right;
	        }
	    }
	 
	    return 0;
	}
	 
	static int findTotalExceptKey(TreeNode root, int key)
	{
	    return sum(root) - adjSum(root, key);
	}
	
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		System.out.println("Simple tree");
		int key = 3;
		System.out.printf("%d ", findTotalExceptKey(rootNode, key));
		
	}
 
	public static TreeNode createBinaryTree()
	{
 
		TreeNode rootNode =new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		rootNode.left=node3;
		rootNode.right=node2;
		node2.left=node5;
		node2.right=node4;
		return rootNode;
	}

}
