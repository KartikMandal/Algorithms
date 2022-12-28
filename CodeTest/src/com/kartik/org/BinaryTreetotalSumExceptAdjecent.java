package com.kartik.org;

/**
 * 
 * Given a BST and a key Node, find the total sum in BST, except those Node which are adjacent to key Node.
 * Binary Tree Example
 *      		  40
               /      \
         	 20       |60|
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


key 60 
addjecent Sum =40+50+70=160
Total Sum = 40+20+60+10+30+50+70+5+55=340
Without Adjecent Sum=340-160=180

 * @author kmandal
 *
 */
public class BinaryTreetotalSumExceptAdjecent {

	// total sum of bst
	static int sum(TreeNode root)
	{
	    if (root == null)
	        return 0;
	 
	    return root.data + sum(root.left) + sum(root.right);
	}
	 
	// sum of all element except those which are adjecent to key TreeNode
	static int adjSum(TreeNode root, int key)
	{
		int parent = 0;
	    if(root!=null)
	    parent = root.data;
	 
	    while (root != null) {
	        if (key < root.data) {
	            parent = root.data; 
	            root = root.left;
	        }
	        else if (root.data == key) // key TreeNode matches
	        {
	            // if the left TreeNode and right TreeNode of key is 
	            // not null then add all adjecent TreeNode and
	            // substract from totalSum
	            if (root.left != null && root.right != null)
	                return (parent + root.left.data + root.right.data);
	 
	            // if key is leaf
	            if (root.left == null && root.right == null)
	                return parent;
	 
	            // If only left child is null
	            if (root.left == null) 
	                return (parent + root.right.data);
	 
	            // If only right child is NULL
	            if (root.right == null) 
	                return (parent + root.left.data);
	        }
	 
	        else {
	            parent = root.data;
	            root = root.right;
	        }
	    }
	 
	    return 0;
	}
	 
	static int findTotalExceptAdjecentKey(TreeNode root, int key)
	{
	    return sum(root) - adjSum(root, key);
	}
	
	
	
	
	// sum of all element except those which are adjecent to key Node 
	static int find_sum(TreeNode root, int key,  boolean incl) 
	{ 
		int sum=0;
	    if (root!=null) { 
	        if (incl) { 
	            sum += root.data; 
	            /*
	             * This  two if and else condition use for subtract the root data if 
	             * it is matching left and right side child 
	             * 
	             */
	            if (root.left!=null && root.left.data == key) { 
	                sum -= root.data; 
	            } 
	            else if (root.right!=null && root.right.data == key) { 
	                sum -= root.data; 
	            } 
	        } 
	        /*
	         * when root is match of key then we do the flip flop for adition of left and right child of the next level 
	         */
	        incl = root.data == key ? false : true; 
	        sum+=find_sum(root.left, key,  incl); 
	       sum+= find_sum(root.right, key,  incl); 
	    }
		return sum; 
	} 
	
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("Simple tree");
		int key = 60;
		System.out.printf("%d ", findTotalExceptAdjecentKey(rootNode, key));
		
		System.out.println();
		int sum = 0;
		sum=find_sum(rootNode, key,  true);
		
		System.out.println(sum);
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
