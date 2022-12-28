package com.kartik.org;

import java.util.Stack;
/**
 * 
 Flatten a binary tree into linked list | Set-2
Given a binary tree, flatten it into a linked list. After flattening, the left of each node 
should point to NULL and right should contain next node in level order.

Example:

Input: 
          1
        /   \
       2     5
      / \     \
     3   4     6

Output:
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

Input:
        1
       / \
      3   4
         /
        2
         \
          5
Output:
     1
      \
       3
        \
         4
          \
           2
            \ 
             5
  
  
  
 * @author kmandal
 *
 */
public class BinaryTreeToLinkedListConvert {

	// To find the inorder traversal 
	static void inorder(TreeNode root) 
	{ 
	    // base condition 
	    if (root == null) 
	        return; 
	    inorder(root.left); 
	    System.out.println(root.data+ " "); 
	    inorder(root.right); 
	} 
	  
	// Function to convert binary tree into 
	// linked list by altering the right node 
	// and making left node point to NULL 
	static TreeNode binaryToLinkedlist(TreeNode node) 
	{ 
	  
	    // Declare a stack 
	    Stack<TreeNode> st = new Stack<TreeNode>(); 
	    TreeNode ans = node; 
	  
	    // Iterate till the stack is not empty 
	    // and till root is Null 
	    while (node != null || st.size() != 0) { 
	  
	        // Check for NULL 
	        if (node.right != null) { 
	            st.push(node.right); 
	        } 
	  
	        // Make the Right Left and 
	        // left NULL 
	        node.right = node.left; 
	        node.left = null; 
	  
	        // Check for NULL 
	        if (node.right == null && st.size() != 0) { 
	            node.right = st.peek(); 
	            st.pop(); 
	        } 
	  
	        // Iterate 
	        node = node.right; 
	    } 
	    return ans; 
	}  
	
	
	static void binaryToLinkedListUsingRecursive(TreeNode root){
		// base condition- return if root is NULL 
	    // or if it is a leaf node 
	    if (root == null || root.left == null && 
	                        root.right == null) { 
	        return; 
	    } 
	  
	    // if root->left exists then we have  
	    // to make it root->right 
	    if (root.left != null) { 
	  
	        // move left recursively 
	    	binaryToLinkedListUsingRecursive(root.left); 
	     
	        // store the node root->right 
	        TreeNode tmpRight = root.right; 
	        root.right = root.left; 
	        root.left = null; 
	  
	        // find the position to insert 
	        // the stored value    
	        TreeNode t = root.right; 
	        while (t.right != null) { 
	            t = t.right; 
	        } 
	  
	        // insert the stored value 
	        t.right = tmpRight; 
	    } 
	  
	    // now call the same function 
	    // for root->right 
	    binaryToLinkedListUsingRecursive(root.right); 
	}
	 public static void main(String[] args) {
			TreeNode t=createBinaryTree();
			BinaryTreeView btv=new BinaryTreeView(t,600,600);
			btv.refresh();
			 t=binaryToLinkedlist(t);
			// binaryToLinkedListUsingRecursive(t);
			inorder(t);

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
