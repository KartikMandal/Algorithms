package com.kartik.org;
/**
 * Given a binary tree, print all root-to-leaf paths
 * For the below example tree, all root-to-leaf paths are: 
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


40 –> 20 –> 10 -> 5
40 –> 20 –> 30
40 –> 60 –> 50 ->50 ->55
40 -> 60 ->70
 * @author kmandal
 *
 */
public class BinaryTreePrintAllPaths {
	 
	
	// Prints all paths from root to leaf
	public static void printAllPathsRootToLeaf(TreeNode root, int[] path, int len) {
		if ( root == null )
			return;
 
		// storing data in array
		path[len] = root.data;
		len++;
 
		if(root.left == null && root.right == null) {
			// leaf node is reached
			printArray(path,len);
			return;
		}
 
		printAllPathsRootToLeaf(root.left, path, len);
		printAllPathsRootToLeaf(root.right, path, len);
	}
 
	
	// Prints all paths from leaf to root
		public static void printAllPathsLeafToRoot(TreeNode node, int[] path, int len) {
			if ( node == null )
				return;
	 
			// storing data in array
			path[len] = node.data;
			len++;
	 
			if(node.left == null && node.right == null) {
				// leaf node is reached
				printArrayReverse(path,len);//only this should be changes 
				return;
			}
	 
			printAllPathsLeafToRoot(node.left, path, len);
			printAllPathsLeafToRoot(node.right, path, len);
		}
 
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("Printing all paths from root to leaf :");
		printAllPathsRootToLeaf(rootNode,new int[1000],0);
		System.out.println("\n");
		printAllPathsLeafToRoot(rootNode,new int[1000],0);
	}
 
	public static void  printArray(int[] path,int len)
	{
		for (int i = 0; i < len; i++) {
			System.out.print("--> "+path[i]);
		}
		System.out.println();
	}
	
	public static void  printArrayReverse(int[] path,int len)
	{
		for (int i = len-1; i>=0; --i) {
			System.out.print("-->"+path[i]);
		}
		System.out.println();
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