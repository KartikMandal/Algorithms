package com.kartik.org;

/**
 * Given a binary tree, print node distance
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


20 <--> 70 = 3

5 <--> 60 = 4

10 <--> 20 = 1


The distance between two nodes can be obtained in terms of lowest common ancestor. Following is the formula.

Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
'n1' and 'n2' are the two given keys
'root' is root of given Binary Tree.
'lca' is lowest common ancestor of n1 and n2
Dist(n1, n2) is the distance between n1 and n2.



 * @author kmandal
 *
 */


public class BinaryTreeTwoNodeDistance {
	
	public static TreeNode LCA(TreeNode root, int n1, int n2) 
	    {
	        if (root == null)
	            return root;
	        if (root.data == n1 || root.data == n2)
	            return root;
	 
	        TreeNode left = LCA(root.left, n1, n2);
	        TreeNode right = LCA(root.right, n1, n2);
	 
	        if (left != null && right != null)
	            return root;
	        if (left != null)
	            return LCA(root.left, n1, n2);
	        else
	            return LCA(root.right, n1, n2);
	    }
	 
	    // Returns level of key k if it is present in
	    // tree, otherwise returns -1
	    public static int findLevel(TreeNode root, int passData, int level)
	    {
	        if (root == null)
	            return -1;
	        if (root.data == passData)
	            return level;
	        int left = findLevel(root.left, passData, level + 1);
	        return (left == -1)?left:findLevel(root.right, passData, level + 1);
	    }
	 
	    public static int findDistance(TreeNode root, int a, int b)
	    {
	    	TreeNode lca = LCA(root, a, b);
	 
	        int d1 = findLevel(lca, a, 0);
	        int d2 = findLevel(lca, b, 0);
	 
	        return d1 + d2;
	    }
	    
	    
	    public static void main(String[] args)
		{
			// Creating a binary tree
			TreeNode rootNode=createBinaryTree();
			BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
			btv.refresh();
			System.out.println("Dist(20, 5) = "
	                + findDistance(rootNode, 20, 70));
			
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
