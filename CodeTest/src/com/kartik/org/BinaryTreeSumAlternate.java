package com.kartik.org;


/**
 * 
 * Maximum sum from a tree with adjacent levels not allowed
 Given a binary tree with positive integer values. Find the maximum sum of nodes such that 
 we cannot pick two levels for computing sum
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


sum=Max{{40+10+30+50+70},{20+60+5+55}}
=Max{205,140}
=205


 * @author kmandal
 *
 */
public class BinaryTreeSumAlternate {
	
	// Recursive function to find the maximum 
    // sum returned for a root node and its 
    // grandchildren 
    public static int getSumAlternate(TreeNode root) 
    { 
        if (root == null) 
            return 0; 
  
        int sum = root.data; 
        if (root.left != null) { 
            sum += getSum(root.left.left); 
            sum += getSum(root.left.right); 
        } 
  
        if (root.right != null) { 
            sum += getSum(root.right.left); 
            sum += getSum(root.right.right); 
        } 
        return sum; 
    } 
  
    // Returns maximum sum with adjacent 
    // levels not allowed. This function 
    // mainly uses getSumAlternate() 
    public static int getSum(TreeNode root) 
    { 
        if (root == null) 
            return 0; 
  
        // We compute sum of alternate levels 
        // starting first level and from second 
        // level. 
        // And return maximum of two values. 
        return Math.max(getSumAlternate(root), 
                        (getSumAlternate(root.left) + 
                         getSumAlternate(root.right))); 
    } 

	
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println(getSum(rootNode));
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
		node10.left=node5;
		return rootNode;
	}

}
