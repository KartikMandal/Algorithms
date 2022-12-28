package com.kartik.org;
/**
 Count the Number of Binary Search Trees present in a Binary Tree
Given a binary tree, the task is to count the number of Binary Search Trees present in it.

Examples:

Input: 
     1
   /  \
  2    3
 / \  / \
4   5 6  7 
Output: 7
Here each node represents a binary search tree and there are total 7 nodes.

Input:

      11
     /  \
    8    10
   /    /  \
  5    9    8
 / \
4   6
Output: 10
We know that a single node represents a BST and since here 8
nodes are present they all are BSTs.Also a subtree rooted under node 5 is a BST

   5
  / \
 4   6
Another BST we have is rooted under the node 8
 
        8    
       /    
      5    
     / \
    4   6
Thus total 10 BSTs are present.
 
 * @author kmandal
 *
 */
public class BinaryTreeCountNumberOfBinarySearchTree {

	// Information stored in every 
	// node during bottom up traversal 
	static class Info 
	{ 
	  
	    // Stores the number of BSTs present 
	    int num_BST; 
	  
	    // Max Value in the subtree 
	    int max; 
	  
	    // Min value in the subtree 
	    int min; 
	  
	    // If subtree is BST 
	    boolean isBST; 
	      
	    Info(int a,int b,int c,boolean d) 
	    { 
	        num_BST = a; 
	        max = b; 
	        min = c; 
	        isBST = d; 
	    } 
	    Info() 
	    {} 
	}; 
	  
	// Returns information about subtree such as 
	// number of BST's it has 
	static Info NumberOfBST( TreeNode root) 
	{ 
	    // Base case 
	    if (root == null) 
	        return new Info( 0, Integer.MIN_VALUE, 
	                        Integer.MAX_VALUE, true ); 
	  
	    // If leaf node then return  
	    // from function and store 
	    // information about the leaf node 
	    if (root.left == null && root.right == null) 
	        return new Info( 1, root.data, root.data, true ); 
	  
	    // Store information about the left subtree 
	    Info left = NumberOfBST(root.left); 
	  
	    // Store information about the right subtree 
	    Info right = NumberOfBST(root.right); 
	  
	    // Create a node that has to be returned 
	    Info bst= new Info(); 
	  
	    // If whole tree routed under the current root 
	    // is BST 
	    if (left.isBST && right.isBST &&  
	        root.data > left.max &&  
	        root.data < right.min)  
	    { 
	        bst.min = Math.min(root.data, (Math.min(left.min, right.min))); 
	        bst.max = Math.max(root.data, (Math.max(left.max, right.max))); 
	  
	        // Update the number of BSTs 
	        bst.num_BST = 2 + left.num_BST + right.num_BST; 
	  
	        return bst; 
	    } 
	  
	    // If the whole tree is not a BST, 
	    // update the number of BSTs 
	    bst.isBST = false; 
	    bst.num_BST = 1 + left.num_BST + right.num_BST; 
	  
	    return bst; 
	} 
	 public static void main(String[] args) {
			TreeNode t=createBinaryTree();
			BinaryTreeView btv=new BinaryTreeView(t,400,400);
			btv.refresh();
			System.out.println(NumberOfBST(t).num_BST);

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
