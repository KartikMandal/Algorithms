package com.kartik.org;

/**
 * Input: 
     Tree 1            Tree 2                  
       2                 3                             
      / \               / \                            
     1   4             6   1                        
    /                   \   \                      
   5                     2   7                  

Output: Merged tree:
         5 (=3+2)
        / \
(1+6=) 7   5 (=4+1)
      / \   \ 
(5)=5  (2=)2   7(=7)
 * 
 * @author kmandal
 *
 */
public class BinaryTreeMergeOfTwoTree {

	
	/* Method to merge given two binary trees */
	static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.data += t2.data;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println();
		TreeNode root3 = mergeTrees(rootNode, rootNode);
		System.out.printf("The Merged Binary Tree is:\n");
		 btv=new BinaryTreeView(root3,400,400);
		btv.refresh();
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
