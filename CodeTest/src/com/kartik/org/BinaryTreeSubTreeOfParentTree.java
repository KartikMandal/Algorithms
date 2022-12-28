package com.kartik.org;
/**
 * A subtree of a tree T is a tree consisting of a node in T and all
of its descendants in T.Nodes thus correspond to subtrees (each
node corresponds to the subtree of itself and all its descendants)
 – the subtree corresponding to the root node is the entire tree,
and each node is the root node of the subtree it. When you create 
a menu bar and if we use sub list of the menu bar then basically 
we use subtree


/**
 *      		  4
               /      \
         	-2         6
           /   \      /  \ 
     	  8     -4    7    5
should be sub tree

                  
         	-2
           /   \
     	  8     -4 

 * @author kmandal
 *
 */
public class BinaryTreeSubTreeOfParentTree {
	
	public static String inOrder(TreeNode root) {
		if (root != null) {
			return inOrder(root.left) + "  " + root.data + "  "
					+ inOrder(root.right);
		}
		return "";

	}

	public static String postOrder(TreeNode root) {
		if (root != null) {
			return postOrder(root.left) + "  " + postOrder(root.right)
					+ "  " + root.data;
		}
		return "";
	}

	public static boolean checkSubtree(TreeNode rootA, TreeNode rootB) {

		String inOrderA = inOrder(rootA);

		String inOrderB = inOrder(rootB);

		String postOrderA = postOrder(rootA);

		String postOrderB = postOrder(rootB);

		return (inOrderA.toLowerCase().contains(inOrderB.toLowerCase()) && postOrderA
				.toLowerCase().contains(postOrderB.toLowerCase()));

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

	public static TreeNode createBinarySubTree() {
		TreeNode rootNode = new TreeNode(30);
		TreeNode node5 = new TreeNode(5);
		rootNode.left = node5;
		return rootNode;
	}

	public static void main(String[] args) {
		TreeNode t1 = createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(t1,400,400);
		btv.refresh();
		TreeNode t2 = createBinarySubTree();
		btv=new BinaryTreeView(t2,400,400);
		btv.refresh();
		System.out.println(checkSubtree(t1, t2));
	}
}
