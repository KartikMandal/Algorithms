package com.kartik.org;

/** Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  
*/

public class BinaryTreeMirror {

	
	static TreeNode mirror(TreeNode node)
    {
        if (node == null)
            return node;
 
        /* do the subtrees */
        TreeNode left = mirror(node.left);
        TreeNode right = mirror(node.right);
 
        /* swap the left and right pointers */
        node.left = right;
        node.right = left;
 
        return node;
    }

	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		System.out.println("Simple tree");
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("\n");
		System.out.println("Mirror of Simple tree");
		mirror(rootNode);
		btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		
	}
 
	public static TreeNode createBinaryTree()
	{
 
		TreeNode rootNode =new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		rootNode.left=node3;
		rootNode.right=node2;
		node2.left=node5;
		node2.right=node4;
		return rootNode;
	}

}
