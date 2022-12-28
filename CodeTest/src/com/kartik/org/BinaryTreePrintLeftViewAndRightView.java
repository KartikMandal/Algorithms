package com.kartik.org;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /      /     \
     	5     15       55
  

output:

----------Left View-----------------
40
20
10
5
----------Right View-----------------
40
60
70
55
 * @author kmandal
 *
 */
public class BinaryTreePrintLeftViewAndRightView {

	 
	    // recursive function to print left view 
	    void leftView(TreeNode root, int level, Map<Integer, Integer> map)
	    {
	    	if (root == null)
	    		return;

	    	// insert the current node and level information into the map
	    	map.put(level, root.data);

	    	// recurse for right subtree before left subtree
	    	leftView(root.right, level + 1, map);
	    	leftView(root.left, level + 1, map);
	    }
	  
	 // Function to print left view of given binary tree
	    void leftView(TreeNode root)
	    {
	    	// create an empty map to store first node for each level
	    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();

	    	// traverse the tree and fill map
	    	leftView(root, 1, map);

	    	// iterate through the map and print left view
	    	for(Entry<Integer,Integer> entry:map.entrySet())
				System.out.println(entry.getValue());
	    }
	    
	    
	    // recursive function to print left view 
	    void rightView(TreeNode root, int level, Map<Integer, Integer> map)
	    {
	    	if (root == null)
	    		return;

	    	// insert the current node and level information into the map
	    	map.put(level, root.data);

	    	// recurse for right subtree before left subtree
	    	rightView(root.left, level + 1, map);
	    	rightView(root.right, level + 1, map);
	    }
	  
	 // Function to print left view of given binary tree
	    void rightView(TreeNode root)
	    {
	    	// create an empty map to store first node for each level
	    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();

	    	// traverse the tree and fill map
	    	rightView(root, 1, map);

	    	// iterate through the map and print left view
	    	for(Entry<Integer,Integer> entry:map.entrySet())
				System.out.println(entry.getValue());
	    }
	    
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		BinaryTreePrintLeftViewAndRightView bb=new BinaryTreePrintLeftViewAndRightView();
		System.out.println("----------Left View-----------------");
		bb.leftView(rootNode);
		System.out.println("----------Right View-----------------");
		bb.rightView(rootNode);
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
 
		return rootNode;
	}

}
