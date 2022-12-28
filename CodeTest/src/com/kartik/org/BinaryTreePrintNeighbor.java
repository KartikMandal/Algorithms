package com.kartik.org;

/**
 * Given a binary tree, print all root-to-leaf paths
 * For the below example tree, all root-to-leaf paths are: 
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


40 –> null
20 –> 60 -> null
10 –> 30 ->50 ->70 ->null
5 ->null -> 55 ->null

 * @author kmandal
 *
 */
public class BinaryTreePrintNeighbor {
	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode neighbor;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
	

	 /*
	  * Set next right of all descendents of p. Assumption: node is a compete
	  * binary tree
	  */
	public static void getNeighbor(TreeNode node) {

	  /*
	   * Constructed binary tree is 
	         40
	      /     \
	     20      60
	    /  \    / \
	  10   30  50  70
	 / \         \
	5  45        55
	   */
	  // Base case
	  if (node == null)
	   return;
	  // Set the nextRight pointer for p's left child
	  if (node.left != null)
	   node.left.neighbor = node.right;

	  // Set the nextRight pointer for p's right child
	  // p.nextRight will be NULL if p is the right most child
	  // at its level
	  if (node.right != null)
	   node.right.neighbor = (node.neighbor != null) ? node.neighbor.left
	     : null;

	  String a = node.neighbor != null ? String.valueOf(node.neighbor.data)
	    : null;
	  System.out.printf(" " + node.data + " -> " + a);
	  
	  // Set nextRight for other nodes in pre order fashion
	  getNeighbor(node.left);
	  getNeighbor(node.right);
	  System.out.println();
	 }

	 

	 // Driver program to test above functions
	 public static void main(String args[]) {
		 // Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		getNeighbor(rootNode);
	  
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
			TreeNode node45=new TreeNode(45);
			TreeNode node55=new TreeNode(55);
	 
			rootNode.left=node20;
			rootNode.right=node60;
	 
			node20.left=node10;
			node20.right=node30;
	 
			node60.left=node50;
			node60.right=node70;
	 
			node10.left=node5;
			node10.right=node45;
			node50.right=node55;
			return rootNode;
		}
}
