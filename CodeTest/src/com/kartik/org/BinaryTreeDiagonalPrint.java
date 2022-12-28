package com.kartik.demo;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class BinaryTreeDiagonalPrint {

	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();

		System.out.println();
		TreeMap<Integer, Vector<Integer>> treeNodeMap = new TreeMap<Integer, Vector<Integer>>();
		diagonalPrintLeftToRight(rootNode, 0, treeNodeMap);

		for (Entry<Integer, Vector<Integer>> entry : treeNodeMap.entrySet())
			System.out.println(entry.getValue());

	}

	static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node55 = new TreeNode(55);
		TreeNode node5 = new TreeNode(5);
		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		node50.right = node55;
		node10.left = node5;
		return rootNode;
	}

	public static class TreeNode {
		public int data;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

		public TreeNode() {
		}
	}

	// Recursive function to do a pre-order traversal of the tree and
	// fill the map with diagonal sum of elements
	static void diagonalPrintLeftToRight(TreeNode root, int diagonal,
			TreeMap<Integer, Vector<Integer>> treeNodeMap) {
		if (root == null) {
			return;
		}
		// get the vector list at 'hd'
		Vector<Integer> vector = treeNodeMap.get(diagonal);

		// Store current node in map 'm'
		if (vector == null) {
			vector = new Vector<>();
			vector.add(root.data);
		} else {
			vector.add(root.data);
		}
		treeNodeMap.put(diagonal, vector);

		diagonalPrintLeftToRight(root.left, diagonal + 1, treeNodeMap);// this
																		// is
																		// confirm
		// left to right

		diagonalPrintLeftToRight(root.right, diagonal, treeNodeMap);
	}

}
