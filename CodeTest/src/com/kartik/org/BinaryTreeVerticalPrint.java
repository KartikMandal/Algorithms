package com.kartik.org;
/**
 * Given a binary tree, print all vertical sum
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


5
10
20
120(40+30+50)
115(60+55)
70
 * @author kmandal
 *
 */
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class BinaryTreeVerticalPrint {

	// prints vertical sum of binary tree
	public static void printVertivalSumOfBinaryTree(TreeNode root,
			TreeMap<Integer, Vector<Integer>> treeNodeMap, int level) {
		if (root == null) {
			return;
		}
		// get the vector list at 'hd'
		Vector<Integer> vector = treeNodeMap.get(level);

		// Store current node in map 'm'
		if (vector == null) {
			vector = new Vector<>();
			vector.add(root.data);
		} else {
			vector.add(root.data);
		}
		treeNodeMap.put(level, vector);
		// Decrease level by 1 when iterating left child
		printVertivalSumOfBinaryTree(root.left, treeNodeMap, level - 1);
		// Increase level by 1 when iterating left child
		printVertivalSumOfBinaryTree(root.right, treeNodeMap, level + 1);

	}
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("Vertical print of binary tree will be:");
		TreeMap<Integer,Vector<Integer>> treeNodeMap=new TreeMap<Integer,Vector<Integer>>();
		printVertivalSumOfBinaryTree(rootNode, treeNodeMap, 0);
 
		for(Entry<Integer,Vector<Integer>> entry:treeNodeMap.entrySet())
			System.out.println(entry.getValue());
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
		node30.left=node5;
		return rootNode;
	}

}
