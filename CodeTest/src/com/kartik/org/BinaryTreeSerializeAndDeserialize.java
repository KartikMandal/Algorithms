package com.kartik.org;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author kmandal
 * 
 * https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
 * 
 * Following are some simpler versions of the problem:

If given Tree is Binary Search Tree?
If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder traversal. In case of Binary Search Trees, only preorder or postorder traversal is sufficient to store structure information.

If given Binary Tree is Complete Tree?
A Binary Tree is complete if all levels are completely filled except possibly the last level and all nodes of last level are as left as possible (Binary Heaps are complete Binary Tree). For a complete Binary Tree, level order traversal is sufficient to store the tree. We know that the first node is root, next two nodes are nodes of next level, next four nodes are nodes of 2nd level and so on.

If given Binary Tree is Full Tree?
A full Binary is a Binary Tree where every node has either 0 or 2 children. It is easy to serialize such trees as every internal node has 2 children. We can simply store preorder traversal and store a bit with every node to indicate whether the node is an internal node or a leaf node.

How to store a general Binary Tree?
A simple solution is to store both Inorder and Preorder traversals. This solution requires requires space twice the size of Binary Tree.
We can save space by storing Preorder traversal and a marker for NULL pointers.

Let the marker for NULL pointers be '-1'
Input:
     12
    /
  13
Output: 12 13 -1 -1 -1

Input:
      20
    /   \
   8     22 
Output: 20 8 -1 -1 22 -1 -1 

Input:
         20
       /    
      8     
     / \
    4  12 
      /  \
     10  14
Output: 20 8 4 -1 -1 12 10 -1 -1 14 -1 -1 -1 

Input:
          20
         /    
        8     
      /
    10
    /
   5
Output: 20 8 10 5 -1 -1 -1 -1 -1 

Input:
          20
            \
             8
              \   
               10
                 \
                  5   
Output: 20 -1 8 -1 10 -1 5 -1 -1 
Deserialization can be done by simply reading data from file one by one.
 *
 */
public class BinaryTreeSerializeAndDeserialize {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
	    //corner case
	    if(root == null) return "";
	    StringBuilder sb = new StringBuilder();
	    helper(root, sb);
	    sb.deleteCharAt(sb.length() - 1);
	    return sb.toString();
	}

	private void helper(TreeNode root, StringBuilder sb){
	    if(root == null){
	        sb.append("n").append(",");
	        return;
	    }
	    sb.append(root.data).append(",");
	    helper(root.left, sb);
	    helper(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data == null || data.length() == 0) return null;
	    Queue<String> queue = new LinkedList<>();
	    queue.addAll(Arrays.asList(data.split(",")));
	    return helper(queue);
	}

	private TreeNode helper(Queue<String> queue){
	    //base case
	    String val = queue.poll();
	    if(val.equals("n")) return null;
	    TreeNode root = new TreeNode(Integer.valueOf(val));
	    root.left = helper(queue);
	    root.right = helper(queue);
	    return root;
	}
	
	private void preOrder(TreeNode root){
		if(root!=null){
		System.out.printf(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		}
	}
	
	private TreeNode createBinaryTree()
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
	
	public static void main(String[] args) {
		BinaryTreeSerializeAndDeserialize bb=new BinaryTreeSerializeAndDeserialize();
		TreeNode root=bb.createBinaryTree();
		String data=bb.serialize(root);
		System.out.println(data);
		System.out.println();
		TreeNode afterDes=bb.deserialize(data);
		bb.preOrder(afterDes);
		System.out.println();
	}

}
