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

	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
	
	// Convert a given tree to a tree where every node contains sum of
    // values of nodes in left and right subtrees in the original tree
   static int toSumTree(TreeNode node) 
    {
        // Base case
        if (node == null)
            return 0;
  
        // Store the old value
        int old_val = node.data;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        node.data = toSumTree(node.left) + toSumTree(node.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return node.data + old_val;
    }
	
	
	// Utility function to do inorder traversal
	 	public static void inorder(TreeNode node)
	 	{
	 	    if (node == null)
	 	        return;
	 	    inorder(node.left);
	 	    System.out.printf("%d ", node.data);
	 	    inorder(node.right);
	 	}
		public static void main(String[] args) {
			// Creating a binary tree
					TreeNode rootNode=createBinaryTree();
					inorder(rootNode);
					System.out.println();
					System.out.println("Convert a given tree to its Sum Tree");
					toSumTree(rootNode);
					inorder(rootNode);
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
