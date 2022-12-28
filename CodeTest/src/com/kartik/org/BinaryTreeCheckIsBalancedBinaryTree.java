package com.kartik.org;

/**
 * 
 * Find if a binary tree is symmetric
 * 
 *Find if a binary tree is balanced

A binary tree is balanced if at every node in the tree, the absolute difference between the height of the left-subtree
 and the height of the right sub-tree doesn’t exceed 1. To solve the problem we recursively traverse the tree and 
 calculate the height of the nodes in a bottom up manner. If at any node, the difference between the height of the 
 left and right sub-trees exceeds 1, we report that the tree is unbalanced.
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

	public class BinaryTreeCheckIsBalancedBinaryTree {

			
		/*curNode: node of the binary tree being checked
		height: height of the curNode is returned here
		Return value: true if the tree is balanced, false otherwise
		*/
		public static boolean isBalanced(TreeNode curNode, int height) {
		    int leftHeight,rightHeight;
		 
		    if (curNode == null) {
		        height = 0;
		        return true;
		    }
		 
		    leftHeight=maxDepth(curNode.left);
		    rightHeight=maxDepth(curNode.right);
		    boolean isLeftBalanced = isBalanced(curNode.left, leftHeight);
		    boolean isRightBalanced = isBalanced(curNode.right, rightHeight);
		 
		    if (!isLeftBalanced || !isRightBalanced)
		        return false;
		 
		    /*If the difference between height of left subtree and height of
		    right subtree is more than 1, then the tree is unbalanced*/
		    if (Math.abs(leftHeight - rightHeight) > 1)
		        return false;
		 
		    /*To get the height of the current node, we find the maximum of the  
		    left subtree height and the right subtree height and add 1 to it*/
		    height = Math.max(leftHeight, rightHeight) + 1;
		 
		    return true;    
		}
		
		/* Compute the "maxDepth" of a tree -- the number of  
	       nodes along the longest path from the root node  
	       down to the farthest leaf node.*/
		/**
		 * 
		 *  maxDepth('1') = max(maxDepth('2'), maxDepth('3')) + 1
                               = 2 + 1
                                  /    \
                                /         \
                              /             \
                            /                 \
                          /                     \
               maxDepth('2') = 1                maxDepth('3') = 1
= max(maxDepth('4'), maxDepth('5')) + 1
= 1 + 1   = 2         
                   /    \
                 /        \
               /            \
             /                \
           /                    \
 maxDepth('4') = 1     maxDepth('5') = 1
		 * 
		 * 
		 * @param node
		 * @return
		 */
	    static int maxDepth(TreeNode node)  
	    { 
	        if (node == null){ 
	            return 0; 
	        }else{ 
	            /* compute the depth of each subtree */
	            int lDepth = maxDepth(node.left); 
	            int rDepth = maxDepth(node.right); 
	   
	            /* use the larger one */
	            if (lDepth > rDepth) 
	                return (lDepth + 1); 
	             else 
	                return (rDepth + 1); 
	        } 
	    } 
		
		public static void main(String[] args)
		{
			// Creating a binary tree
			TreeNode rootNode=createBinaryTree();
			System.out.println("Simple tree");
			BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
			btv.refresh();
			System.out.println("\n");
			System.out.println("Is binary tree balanced ");
			System.out.println(isBalanced(rootNode,2));
			
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

