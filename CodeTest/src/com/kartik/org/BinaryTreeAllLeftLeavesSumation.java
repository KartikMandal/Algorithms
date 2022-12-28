package com.kartik.org;


/**
 * Given a Binary Tree, find sum of all left leaves in it. For example, 
 * sum of all left leaves in below Binary Tree is 5+64=79
 * 
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \   /
     	5              55 64
  
 * @author kmandal
 *
 */
public class BinaryTreeAllLeftLeavesSumation {
		
	// A utility function to check if a given node is leaf or not 
    static boolean isLeaf(TreeNode node)  
    { 
        if (node == null) 
            return false; 
        if (node.left == null && node.right == null) 
            return true; 
        return false; 
    } 
   
     // This function returns sum of all left leaves in a given 
     // binary tree 
    static int leftLeavesSum(TreeNode node)  
    { 
        // Initialize result 
        int res = 0; 
   
        // Update result if root is not NULL 
        if (node != null)  
        { 
            // If left of root is NULL, then add key of 
            // left child 
            if (isLeaf(node.left)){ 
                res += node.left.data;
            }
            
            res += leftLeavesSum(node.left); 
            // Recur for right child of root and update res 
            res += leftLeavesSum(node.right); 
        } 
   
        // return result 
        return res; 
    } 
    
    public static void main(String[] args) {
		TreeNode t=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(t,400,400);
		btv.refresh();
		System.out.println(leftLeavesSum(t));

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
