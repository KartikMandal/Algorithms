package com.kartik.org;



public class BinaryTreePrintChildNodeSumationInRoot {

	
	// Recursive function to in-place convert the given binary tree to its
	// sum tree by traversing the tree in postorder manner
	static int convertToSumTree(TreeNode root)
	{
		// base case: tree is empty
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		// stores current value of root node
		int old = root.data;

		// update root to sum of its left and right subtree
		root.data = convertToSumTree(root.left) + convertToSumTree(root.right);

		// return the updated value plus old value. It is equal to 
		// sum of all elements present in sub-tree rooted at root node
		return root.data + old;
	}
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println();
		System.out.println("Printing all paths from root to leaf :");
		convertToSumTree(rootNode);
		System.out.println();
		btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
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
		TreeNode node5=new TreeNode(5);
		TreeNode node55=new TreeNode(55);
 
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
		node10.left=node5;
		node50.right=node55;
 
		return rootNode;
	}
}
