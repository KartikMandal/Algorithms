package com.kartik.org;
/**
 
 Check whether a given binary tree is skewed binary tree or not?
Given a Binary Tree check whether it is skewed binary tree or not. A skewed tree is a tree where each node has only one child node or none.

Examples:

Input :         5
             /   
            4
              \
               3
             /
           2
Output : Yes

Input :       5
            /
           4
            \
             3
           /  \
          2    4
Output : No

 * @author kmandal
 *
 */
public class BinaryTreeIsSkewed {
	/**
	 * 
	 * @param root
	 * @return
	 */
	static boolean isSkewedBT(TreeNode root)  
	{  
	    // check if node is null or is a leaf node  
	    if (root == null || (root.left == null &&  
	                        root.right == null))  
	        return true;  
	  
	    // check if node has two children if  
	    // yes, return false  
	    if (root.left!=null && root.right!=null)  
	        return false;  
	    if (root.left!=null)  
	        return isSkewedBT(root.left);  
	    return isSkewedBT(root.right);  
	    
	}  
	 public static void main(String[] args) {
			TreeNode t=createBinaryTree();
			BinaryTreeView btv=new BinaryTreeView(t,400,400);
			btv.refresh();
			System.out.println(isSkewedBT(t));

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
			TreeNode node64=new TreeNode(64);
			rootNode.left=node20;
			rootNode.right=node60;
	 
			node20.left=node10;
			node20.right=node30;
	 
			node60.left=node50;
			node60.right=node70;
			node50.right=node55;
			node10.left=node5;
			node70.left=node64;
			return rootNode;
		}

}
