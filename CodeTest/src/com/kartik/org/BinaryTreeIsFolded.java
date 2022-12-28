package com.kartik.org;
/**
 * 
Foldable Binary Trees
Question: Given a binary tree, find out if the tree can be folded or not.

A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11

(b)
        10
       /  \
      7    15
     /      \
    9       11

(c)
        10
       /  \
      7   15
     /    /
    5   11

(d)

         10
       /   \
      7     15
    /  \    /
   9   10  12
 * @author kmandal
 *
 */
public class BinaryTreeIsFolded {

	 /* Returns true if the given tree is foldable */
   static boolean isFoldable(TreeNode node)  
    { 
        boolean res; 
   
        /* base case */
        if (node == null) 
            return true; 
   
        /* convert left subtree to its mirror */
        mirror(node.left); 
   
        /* Compare the structures of the right subtree and mirrored 
         left subtree */
        res = isStructSame(node.left, node.right); 
   
        /* Get the originial tree back */
        mirror(node.left); 
   
        return res; 
    } 
   
   static boolean isStructSame(TreeNode a, TreeNode b)  
    { 
        if (a == null && b == null) 
            return true; 
        if (a != null && b != null
                && isStructSame(a.left, b.left) 
                && isStructSame(a.right, b.right))  
            return true; 
   
        return false; 
    } 
   
    /* UTILITY FUNCTIONS */
      
    /* Change a tree so that the roles of the  left and 
       right pointers are swapped at every node. 
       See https://www.geeksforgeeks.org/?p=662 for details */
   static void mirror(TreeNode node)  
    { 
        if (node == null) 
            return; 
        else 
        { 
        	TreeNode temp;
            /* do the subtrees */
            mirror(node.left); 
            mirror(node.right); 
   
            /* swap the pointers in this node */
            temp = node.left; 
            node.left = node.right; 
            node.right = temp; 
        } 
    } 
    public static void main(String[] args) {
		TreeNode t=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(t,400,400);
		btv.refresh();
		System.out.println(isFoldable(t));

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
