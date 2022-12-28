package com.kartik.org;

import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeTopView {

	static class PairNode{
		int first, second; 
	      
		PairNode(){} 
		PairNode(int i, int j) 
	    { 
	        first = i; 
	        second = j; 
	    } 
	}
	// map to store the pair of node value and  
	// its level with respect to the vertical  
	// distance from root.  
	static TreeMap<Integer,  
	PairNode> m= new TreeMap<>(); 
	  
		  
	// function to fill the map 
	static void fillMap(TreeNode root, int d, int l) 
	{ 
	    if(root == null) return; 
	  
	    if(m.get(d) == null) 
	    { 
	        m.put(d, new PairNode(root.data, l)); 
	    }  
	    else if(m.get(d).second>l) 
	    { 
	        m.put(d, new PairNode(root.data, l)); 
	    } 
	  
	    fillMap(root.left, d - 1, l + 1); 
	    fillMap(root.right, d + 1, l + 1); 
	} 
	  
	// function should print the topView of 
	// the binary tree 
	static void topView(TreeNode root) 
	{ 
	    fillMap(root, 0, 0); 
	      
	    for (Map.Entry<Integer,  
	    		PairNode> entry : m.entrySet()) 
	    { 
	        System.out.print(entry.getValue().first + " "); 
	    } 
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
	public static void main(String[] args) {
		
		TreeNode t=createBinaryTree();
		topView(t);
		

	}

}
