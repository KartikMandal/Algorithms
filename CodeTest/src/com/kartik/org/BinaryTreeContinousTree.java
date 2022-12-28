package com.kartik.org;
/**
 
 Continuous Tree
A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1.
 We are given a binary tree, we need to check if tree is continuous or not.

Examples:

Input :              3
                    / \
                   2   4
                  / \   \
                 1   3   5
Output: "Yes"

// 3->2->1 every two adjacent node's absolute difference is 1
// 3->2->3 every two adjacent node's absolute difference is 1
// 3->4->5 every two adjacent node's absolute difference is 1

Input :              7
                    / \
                   5   8
                  / \   \
                 6   4   10
Output: "No"

// 7->5->6 here absolute difference of 7 and 5 is not 1.
// 7->5->4 here absolute difference of 7 and 5 is not 1.
// 7->8->10 here absolute difference of 8 and 10 is not 1.
 
 
 
 * @author kmandal
 *
 */
public class BinaryTreeContinousTree {

	
	// Function to check tree is continuous or not 
	  
	static boolean treeContinuous( TreeNode node) 
	{ 
	    // if next node is empty then return true 
	    if (node == null) 
	        return true; 
	  
	    // if current node is leaf node then return true 
	    // because it is end of root to leaf path 
	    if (node.left == null && node.right == null) 
	        return true; 
	  
	    // If left subtree is empty, then only check right 
	    if (node.right!= null) 
	    return (Math.abs(node.data - node.right.data) == 1) && 
	            treeContinuous(node.right); 
	  
	    // If right subtree is empty, then only check left 
	    if (node.left != null) 
	    return (Math.abs(node.data - node.left.data) == 1) && 
	            treeContinuous(node.left); 
	  
	    // If both left and right subtrees are not empty, check 
	    // everything 
	    return Math.abs(node.data - node.left.data)==1 && 
	            Math.abs(node.data - node.right.data)==1 && 
	            treeContinuous(node.left) && 
	            treeContinuous(node.right); 
	}
	 public static void main(String[] args) {
			TreeNode t=createBinaryTree();
			BinaryTreeView btv=new BinaryTreeView(t,400,400);
			btv.refresh();
			System.out.println(treeContinuous(t));

		}
		public static TreeNode createBinaryTree()
		{
	 
			TreeNode rootNode =new TreeNode(40);
			TreeNode node20=new TreeNode(20);
			TreeNode node10=new TreeNode(10);
			TreeNode node30=new TreeNode(30);
			TreeNode node60=new TreeNode(60);
			TreeNode node50=new TreeNode(50);
			TreeNode node70=new TreeNode(70);
			TreeNode node55=new TreeNode(55);
			TreeNode node5=new TreeNode(5);
			TreeNode node64=new TreeNode(64);
			rootNode.left=node20;
			rootNode.right=node60;
	 
			node20.left=node10;
			node20.right=node30;
	 
			node60.left=node50;
			node60.right=node70;
			node50.right=node55;
			node10.left=node5;
			node70.left=node64;
			return rootNode;
		}
}
