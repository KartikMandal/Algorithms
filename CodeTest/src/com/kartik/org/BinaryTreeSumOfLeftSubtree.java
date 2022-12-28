package com.kartik.org;


/**
   
     			  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	       /     \
     	      5      55
     	
     	
     	output:
     	
     	  		  105(40+20+10+30+5)
               /      \
       (20+10)30        165(60+50+55)
           /   \      /  \ 
     	  10    35  50    70
     	       /     \
     	      5      55
  
  
 * 
 * @author kmandal
 *
 */
public class BinaryTreeSumOfLeftSubtree {
	
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
	    return root.data +rightsum;
	}
	
		
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println();
		System.out.println("every node stores sum of all nodes in left subtree");
		updatetree(rootNode);
		btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();;
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
