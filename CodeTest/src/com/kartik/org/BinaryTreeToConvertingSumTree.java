package com.kartik.org;

/**
 *      		  10
               /      \
         	-2         6
           /   \      /  \ 
     	  8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
       		4(8-4)     12(7+5)
           /   \      /  \ 
     	  0      0    0    0
 * @author kmandal
 *
 */
public class BinaryTreeToConvertingSumTree {

	// Convert a given tree to a tree where every node contains sum of
    // values of nodes in left and right subtrees in the original tree
   static int toConvertingSumTree(TreeNode root) 
    {
        // Base case
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
			return root.data;
        // Store the old value
        int old = root.data;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        root.data = toConvertingSumTree(root.left) + toConvertingSumTree(root.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return root.data + old;
    }
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		BinaryTreeView btv = new BinaryTreeView(rootNode, 400, 400);
		btv.refresh();
		System.out.println();
		System.out.println("Convert a given tree to its Sum Tree");
		toConvertingSumTree(rootNode);
		btv = new BinaryTreeView(rootNode, 400, 400);
		btv.refresh();
	}

	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(20);
		TreeNode node20 = new TreeNode(-2);
		TreeNode node10 = new TreeNode(8);
		TreeNode node30 = new TreeNode(-4);
		TreeNode node60 = new TreeNode(6);
		TreeNode node50 = new TreeNode(5);
		TreeNode node70 = new TreeNode(7);
		//TreeNode node55 = new TreeNode(55);
		//TreeNode node5 = new TreeNode(5);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		//node50.right = node55;
		//node30.left = node5;
		return rootNode;
	}
}
