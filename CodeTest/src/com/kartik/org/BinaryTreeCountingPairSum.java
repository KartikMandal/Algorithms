package com.kartik.org;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 *Find a pair with given sum in BST
Given a BST and a sum, find if there is a pair with given sum.
Input: 
     1
   /  \
  2    3
 / \  / \
4   5 6  7 
Input : sum = 10
        Root of below tree

Output : Pair is found (4, 6)
Pair is found (3, 7)
 * 
 * @author kmandal
 *
 */
public class BinaryTreeCountingPairSum {
	/**
	 * 
	 * @param root
	 * @param sum
	 * @param set
	 * @return
	 */
	/*static boolean findpairUtil(TreeNode root, int sum, Set<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set)){
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data) + ", "
					+ root.data + ")");
			return true;
		} else{
			set.add(root.data);
		}
		return findpairUtil(root.right, sum, set);
	}*/

	
	/**
	 * 
	 * @param root
	 * @param sum
	 * @param set
	 * @return
	 */
	static void findpairUtil(TreeNode root, int sum, Set<Integer> set) {
		if (root == null)
			return ;
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data) + ", "
					+ root.data + ")");
		} else{
			set.add(root.data);
		}
		findpairUtil(root.left, sum, set);
		
		findpairUtil(root.right, sum, set);
	}
	/**
	 * 
	 * @param root
	 * @param sum
	 */
	static void findPair(TreeNode root, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		findpairUtil(root, sum, set);
		/*if (!findpairUtil(root, sum, set))
			System.out.println("Pairs do not exit");*/
	}

	public static void main(String[] args) {
		TreeNode t = createBinaryTree();
		BinaryTreeView btv = new BinaryTreeView(t, 400, 400);
		btv.refresh();
		int x = 120;
		findPair(t, x);
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
		TreeNode node5 = new TreeNode(90);
		TreeNode node64 = new TreeNode(64);
		rootNode.left = node20;
		rootNode.right = node60;
		node20.left = node10;
		node20.right = node30;
		node60.left = node50;
		node60.right = node70;
		node50.right = node55;
		node10.left = node5;
		node70.left = node64;
		return rootNode;
	}

}
