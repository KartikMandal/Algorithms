package com.kartik.org;
/**
 * 
 * 
 I was looking at interview questions and I recently came upon one
  that asked you how to reverse a general binary tree, like flip it from right to left.

So for example if we had the binary tree

     6
   /   \
  3     4
 / \   / \
7   3 8   1
Reversing it would create

     6
   /   \
  4     3
 / \   / \
1   8 3   7
I haven't been able to think of a good implementation on how to solve this problem. 
Can anyone offer any good ideas?
 * 
 * @author kmandal
 *
 */
public class BinaryTreeReverse {
	/**
	 * 
	 * @param root
	 * @return
	 */
	TreeNode reverseTree(final TreeNode root) {
	    final TreeNode temp = root.right;
	    root.right = root.left;
	    root.left = temp;

	    if (root.left != null) {
	        reverseTree(root.left);
	    }

	    if (root.right != null) {
	        reverseTree(root.right);
	    }
	    return root;
	}	
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		BinaryTreeReverse bb=new BinaryTreeReverse();
		TreeNode tt=bb.reverseTree(rootNode);
		btv=new BinaryTreeView(tt,400,400);
		btv.refresh();
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
