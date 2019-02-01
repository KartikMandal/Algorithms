package com.kartik.org;
/**
 * 
 * Convert a binary tree into its mirror image

An example of a binary tree and its mirror image is shown below.

/**
 *      		  4
               /      \
         	-2         6
           /   \      /  \ 
     	  8     -4    7    5
     	  
Mirrior of binary tree

           		  4
               /      \
         	 6         -2
           /   \      /  \ 
     	  5     7    -4   8

So to convert the binary tree to its mirror image, the left child and the
 right child of each node in the tree should be swapped
 * 
 * @author kmandal
 *
 */


public class BinaryTreeConvertMirrorBinaryTree {

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
	
	/*
	curNode: current node of the tree whose mirror image should be computed
	*/
	public static void computeMirrorImage(TreeNode curNode) {
	    if (curNode != null) {
	        /*Swap the left child and right child of the current node*/
	        TreeNode tempNode = curNode.left;
	        curNode.left = curNode.right;
	        curNode.right = tempNode;
	 
	        /*Recursively compute the mirror image */
	        computeMirrorImage(curNode.left);
	        computeMirrorImage(curNode.right);
	    }
	}
	
	/* Helper function to test mirror(). Given a binary
    search tree, print out its data elements in
    increasing sorted order.*/
 static void inOrder(TreeNode node)
 {
     if (node == null)
         return;

     	inOrder(node.left);
		//Visit the node by Printing the node data  
		System.out.printf("%d ",node.data);
		inOrder(node.right);

     
 }
	
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		System.out.println("Simple tree");
		inOrder(rootNode);
		System.out.println("\n");
		System.out.println("Mirror of Simple tree");
		computeMirrorImage(rootNode);
		inOrder(rootNode);
		
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
