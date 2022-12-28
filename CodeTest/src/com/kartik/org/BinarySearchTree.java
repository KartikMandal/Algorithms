package com.kartik.org;

 /** Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  
*/
public class BinarySearchTree {
	
	// A utility function to search a given key in BST
	public static TreeNode search(TreeNode root, int key)
	{
	    // Base Cases: root is null or key is present at root
	    if (root==null || root.data==key)
	        return root;
	 
	    // val is greater than root's key
	    if (root.data > key)
	        return search(root.left, key);
	 
	    // val is less than root's key
	    return search(root.right, key);
	}
	
	public static void main(String[] args) {
		TreeNode t=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(t,400,400);
		btv.refresh();
		System.out.println(search(t, 23)!=null? "Found":"not found");

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
