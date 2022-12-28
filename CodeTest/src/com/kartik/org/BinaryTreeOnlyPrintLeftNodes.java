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
  


40 –> 20 –> 10 -> 5
40 –> 20 –> 30
40 –> 60 –> 50 ->50 ->55
40 -> 60 ->70
 * @author kmandal
 *
 */
public class BinaryTreeOnlyPrintLeftNodes {

	 
	    static int  max_level = 0; 
	  
	    // recursive function to print left view 
	    void leftViewUtil(TreeNode node, int level) 
	    { 
	        // Base Case 
	        if (node==null) return; 
	  
	        // If this is the first node of its level 
	        if (max_level < level) 
	        { 
	            System.out.print(" " + node.data); 
	            max_level = level; 
	        } 
	  
	        // Recur for left and right subtrees 
	        leftViewUtil(node.left, level+1); 
	        leftViewUtil(node.right, level+1); 
	    } 
	  
	    // A wrapper over leftViewUtil() 
	    void leftView(TreeNode root) 
	    { 
	        leftViewUtil(root, 1); 
	    } 
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		BinaryTreeOnlyPrintLeftNodes bb=new BinaryTreeOnlyPrintLeftNodes();
		bb.leftView(rootNode);
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
		node50.right=node5;
 
		return rootNode;
	}

}
