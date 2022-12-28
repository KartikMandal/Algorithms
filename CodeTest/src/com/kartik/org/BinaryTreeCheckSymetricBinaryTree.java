package com.kartik.org;

/**
 * 
 * Find if a binary tree is symmetric
 * 
 * A binary tree is symmetric, if the left sub-tree of each node is a mirror
 * image of the right sub-tree. An example of a symmetric binary tree is given
 * below
 * 
 * /** Symetric Example
 *      		  4
               /      \
         	 6         6
           /   \      /  \ 
     	  8     -4  -4    8
     	  
Non Symetric Example

           		  4
               /      \
         	 6         -2
           /   \      /  \ 
     	  5     7    -4   8
 * 
 * @author kmandal
 *
 */

	public class BinaryTreeCheckSymetricBinaryTree {

	
		public static boolean compareNodes ( TreeNode n1, TreeNode n2) {
		    if (n1 == null && n2 == null)  /*If both the nodes are null */
		        return true;  /* return symmetric*/
		 
		    /*If one node is null and the other is not null*/
		    if ( (n1 != null && n2 == null) || (n1 == null && n2 != null))  
		        return false; /*return not symmetric*/
		 
		    if (n1.data != n2.data) /*If data of two nodes don't match */
		        return false; /* return not symmetric */
		     
		    if (!compareNodes (n1.left, n2.right)) 
		        return false;
		 
		    if (!compareNodes (n1.right, n2.left))
		        return false;
		 
		    return true; /*Return symmetric*/
		}
		 
		/*Returns true if the tree is symmetric, false otherwise*/
		public static boolean isSymmetric(TreeNode root) {
		    if (root == null)
		        return true;
		 
		    return compareNodes(root.left, root.right);
		}
		
		/* Helper function to test mirror(). Given a binary
	    search tree, print out its data elements in
	    increasing sorted order.*/
	 static void inOrder(TreeNode node)
	 {
	     if (node == null)
	         return;

	     	inOrder(node.left);
			//Visit the node by Printing the node data  
			System.out.printf("%d ",node.data);
			inOrder(node.right);

	     
	 }
		
		
		public static void main(String[] args)
		{
			// Creating a binary tree
			TreeNode rootNode=createBinaryTree();
			System.out.println("Simple tree");
			BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
			btv.refresh();
			System.out.println("\n");
			System.out.println("Is binary tree symmetric");
			System.out.println(isSymmetric(rootNode));
			
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

