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

public class BinaryTreeFloorFindOutInBinarySearchTree {
	
	// A utility function to search a given key in BST
	public static int floor(TreeNode root, int key) 
	{ 
	    if (root ==null) 
	        return Integer.MAX_VALUE; 
	  
	    /* If root->data is equal to key */
	    if (root.data == key) 
	        return root.data; 
	  
	    /* If root->data is greater than the key */
	    if (root.data > key) 
	        return floor(root.left, key); 
	  
	    /* Else, the floor may lie in right subtree 
	      or may be equal to the root*/
	    int floorValue = floor(root.right, key); 
	    return (floorValue <= key) ? floorValue : root.data; 
	} 
	
	public static void main(String[] args) {
		TreeNode t=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(t,400,400);
		btv.refresh();
		int floorVal=floor(t, 24);
		System.out.println("Floor value "+floorVal);

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
