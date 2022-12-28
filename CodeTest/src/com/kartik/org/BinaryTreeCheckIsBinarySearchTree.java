package com.kartik.org;

/**
 * 
 * Find if a binary tree is a binary search tree



The initial approach that comes to mind is to check if the left child node
 is smaller than the parent node and the right child node is greater than 
 the parent node for all the nodes in the tree. However this solution will 
 not work as shown in the binary tree above. Every node satisfies the condition 
 that the left child is smaller than the parent and the right child is greater
  than the parent. But the tree is still not a binary search tree since node
   9 is incorrect. To correctly find out if a tree is a binary search tree, 
   we should traverse the tree in-order and check if the nodes are present 
   in ascending order
 * 
 * /** Binary tree is binary search tree
 *      		  5
               /      \
         	 3         8
           /   \      /  \ 
     	  1     4    7    9
     	  
Binary tree is non binary search tree

           		  4
               /      \
         	 6         -2
           /   \      /  \ 
     	  5     7    -4   8
 * 
 * @author kmandal
 *
 */

	public class BinaryTreeCheckIsBinarySearchTree {

				
		/* can give min and max value according to your code or 
	    can write a function to find min and max value of tree. */
	  
	    /* returns true if given search tree is binary 
	     search tree (efficient version) */
	    static boolean isBST(TreeNode root)  { 
	        return isBSTUtil(root, Integer.MIN_VALUE, 
	                               Integer.MAX_VALUE); 
	    } 
	  
	    /* Returns true if the given tree is a BST and its 
	      values are >= min and <= max. */
	    static boolean isBSTUtil(TreeNode node, int min, int max) 
	    { 
	        /* an empty tree is BST */
	        if (node == null) 
	            return true; 
	  
	        /* false if this node violates the min/max constraints */
	        if (node.data < min || node.data > max) 
	            return false; 
	  
	        /* otherwise check the subtrees recursively 
	        tightening the min/max constraints */
	        // Allow only distinct values 
	        return (isBSTUtil(node.left, min, node.data-1) && 
	                isBSTUtil(node.right, node.data+1, max)); 
	    } 
		
		
		
	public static void main(String[] args)
		{
			// Creating a binary tree
			TreeNode rootNode=createBinaryTree();
			System.out.println("Simple tree");
			BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
			btv.refresh();
			System.out.println("\n");
			System.out.println("Is binary tree balanced ");
			System.out.println(isBST(rootNode));
			
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

