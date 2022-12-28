package com.kartik.org;

/**
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * For every node, data value must be equal to sum of data values in left and right children.
 * Consider data value as 0 for NULL children. Below tree is an example
 * 
 *       		  15
               /      \
         	 8         7
           /   \      /  \ 
     	  3     5    2    5
     	  
     	  means 
     	  
     	   		  15(8+7)
               /      \
         	 8(5+3)    7(2+5)
           /   \      /  \ 
     	  3     5    2    5
     	  
     	  Then it is return 1 else return 0
     	  
 * 
 * @author kmandal
 *
 */
public class BinaryTreeChildrenSumProperty {

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

	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		/*BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();*/
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
