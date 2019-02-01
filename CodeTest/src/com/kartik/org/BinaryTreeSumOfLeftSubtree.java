package com.kartik.org;



public class BinaryTreeSumOfLeftSubtree {
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
	
	// Function to modify a Binary Tree so that every node
	// stores sum of values in its left child including its
	// own value
	public static int updatetree(TreeNode root)
	{
	    // Base cases
	    if (root == null)
	        return 0;
	    if (root.left == null && root.right == null)
	        return root.data;
	 
	    // Update left and right subtrees
	    int leftsum  = updatetree(root.left);
	    int rightsum = updatetree(root.right);
	 
	    // Add leftsum to current node
	    root.data += leftsum;
	 
	    // Return sum of values under root
	    return root.data + rightsum;
	}
	
	// Utility function to do inorder traversal
	public static void inorder(TreeNode node)
	{
	    if (node == null)
	        return;
	    inorder(node.left);
	    System.out.printf("%d ", node.data);
	    inorder(node.right);
	}
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		inorder(rootNode);
		System.out.println();
		System.out.println("every node stores sum of all nodes in left subtree");
		updatetree(rootNode);
		inorder(rootNode);
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
 
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
		node50.right=node55;
		node30.left=node5;
		return rootNode;
	}
	
}
