package com.kartik.org;

/**
 * 4 / \ -2 6 / \ / \ 8 -4 7 5 should be same
 * 
 * 4 / \ -2 6 / \ / \ 8 -4 7 5
 * 
 * @author kmandal
 *
 */
public class BinaryTreeChildrenSumProperty {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	/*
	 * returns 1 if children sum property holds for the given node and both of
	 * its children
	 */
	static int isSumProperty(TreeNode node) {

		/*
		 * left_data is left child data and right_data is for right child data
		 */
		int left_data = 0, right_data = 0;

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if (node == null || (node.left == null && node.right == null))
			return 1;
		else {

			/*
			 * If left child is not present then 0 is used as data of left child
			 */
			if (node.left != null)
				left_data = node.left.data;

			/*
			 * If right child is not present then 0 is used as data of right
			 * child
			 */
			if (node.right != null)
				right_data = node.right.data;

			/*
			 * if the node and both of its children satisfy the property return
			 * 1 else 0
			 */
			if ((node.data == left_data + right_data)
					&& (isSumProperty(node.left) != 0)
					&& isSumProperty(node.right) != 0)
				return 1;
			else
				return 0;
		}
	}

	// Utility function to do inorder traversal
	public static void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.printf("%d ", node.data);
		inorder(node.right);
	}

	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		inorder(rootNode);
		System.out.println();
		System.out.println("Convert a given tree to its Sum Tree");
		System.out.println(isSumProperty(rootNode));
	}

	public static TreeNode createBinaryTree() {

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
		node30.left = node5;
		return rootNode;
	}
}
