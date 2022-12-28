package com.kartik.org;

import java.util.HashMap;
import java.util.Map;


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
  

Left To Right
diogonal={{40+60+70},{20+30+50+55},{10},{5}}
={170,155,10,5}

Right To Left
diogonal={{40+20+10+5},{60+50+30},{70+55}}
={75,140,125}

Beter under stand:{@link https://www.techiedelight.com/find-diagonal-sum-given-binary-tree/} 

								40
               			/				\
               		20   		    	 60
            	/		\				/		\
     	  	10			30			50			70
     	 
     			5              55




 * @author kmandal
 *
 */
public class BinaryTreeDiogonalSum {
	
	// Recursive function to do a pre-order traversal of the tree and
	// fill the map with diagonal sum of elements
	static void diagonalSumLeftToRight(TreeNode root, int diagonal, Map<Integer,Integer> map)
	{
	if (root == null)
		return;
	map.put(diagonal, map.get(diagonal)!=null? map.get(diagonal) + root.data:root.data);

	diagonalSumLeftToRight(root.left, diagonal + 1, map);//this is confirm left to right

	diagonalSumLeftToRight(root.right, diagonal, map);
	}


	//Recursive function to do a pre-order traversal of the tree and
	// fill the map with diagonal sum of elements
	static void diagonalSumRightToLeft(TreeNode root, int diagonal, Map<Integer,Integer> map)
	{
	if (root == null)
		return;
	map.put(diagonal, map.get(diagonal)!=null? map.get(diagonal) + root.data:root.data);

	diagonalSumRightToLeft(root.left, diagonal, map);

	diagonalSumRightToLeft(root.right, diagonal+1, map);
	}
	
	// Function to print the diagonal sum of given binary tree
	static void diagonalSum(TreeNode root)
	{
		
	System.out.println("Left to Right");
	Map<Integer, Integer> map=new HashMap<Integer,Integer>();
	diagonalSumLeftToRight(root, 0, map);
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	System.out.println();
	System.out.println("Right to Left");
	map=new HashMap<Integer, Integer>();
	diagonalSumRightToLeft(root, 0, map);
	for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
		System.out.println(entry.getValue());
	}
	}
	

	
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println();
		diagonalSum(rootNode);
		//print2D(rootNode);
		
		
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
