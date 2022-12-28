package com.kartik.org;


/**
 * Construct below tree
              1
            /   \
           /     \
          2       3
         / \     / \
        /   \   /   \
       4     5 6     7
should be same

           4  5 are cousine node 6  7
           6  7 are cousine node 4  5
 * @author kmandal
 *
 */
//https://www.geeksforgeeks.org/sum-of-cousin-nodes-of-a-given-node-in-a-bst/
public class BinaryTreeSumOfCusinNodeInSameLevel {

		
	static // Function which calculates the sum of the cousin Node
	int sumOfCousin(TreeNode root, int p,
	                int level1, int level)
	{
	    int sum = 0;
	    if (root == null)
	        return 0;
	 
	    // nodes which has same parent
	    // as the given node will not be
	    // taken to count for calculation
	    if (p == root.data)
	        return 0;
	 
	    // if the level is same
	    // then it is a cousin
	    // as parent checking has been
	    // done above
	    if (level1 == level)
	        return root.data;
	 
	    // traverse in the tree left and right
	    else
	        sum += sumOfCousin(root.left, p, level1 + 1, level) + sumOfCousin(root.right, p, level1 + 1, level);
	 
	    return sum;
	}
	 
	// Function that returns the parent node
	static int parentNode(TreeNode root, int nodeData)
	{
	    int parent = -1;
	 
	    // traverse the full Binary tree
	    while (root != null) {
	 
	        // if node is found
	        if (nodeData == root.data)
	            break;
	 
	        // if less than move to left
	        else if (nodeData < root.data) {
	            parent = root.data;
	            root = root.left;
	        }
	 
	        // if greater than move to rigth
	        else {
	            parent = root.data;
	            root = root.right;
	        }
	    }
	 
	    // Node not found
	    if (root == null)
	        return -1;
	    else
	        return parent;
	}
	 
	// Function to find the level of the given node
	static int levelOfNode(TreeNode root, int nodeData)
	{
	    // calculate the level of node
	    int level = 0;
	    while (root != null) {
	 
	        // if the node is found
	        if (nodeData == root.data)
	            break;
	 
	        // move to the left of the tree
	        if (nodeData < root.data) {
	            root = root.left;
	        }
	 
	        // move to the right of the tree
	        else {
	            root = root.right;
	        }
	 
	        // increase the level after every traversal
	        level++;
	    }
	 
	    // return the level of a given node
	    return level;
	}
	
		// Recursive Solution
		//To get level of node in a binary tree
		public static int getLevelOfNode(TreeNode root,int key,int level)
		{
			if(root==null)
				return 0;
			if(root.data==key)
				return level;
	 
			int result=getLevelOfNode(root.left,key,level+1) ;
			if(result!=0)
			{ 
				// If found in left subtree , return 
				return result;
			}
			result= getLevelOfNode(root.right,key,level+1);
	 
			return result;
		}
	
		
		// Function to find level of given node x
		void Level(TreeNode root, TreeNode x, int index, int level)
		{
			// return if tree is empty or level is already found
			if (root == null)
				return;

			// if given node is found, update its level
			if (root.data == x.data)
				level = index;

			// recurse for left and right subtree
			Level(root.left, x, index + 1, level);
			Level(root.right, x, index + 1, level);
		}

		void printLevel(TreeNode root, TreeNode node, int level)
		{
			// base case
			if (root == null)
				return;

			// print cousins
			if (level == 1)
			{
				System.out.println(root.data);
				return;
			}

			// recurse for left and right subtree if root is not parent of given node
			if (root.left !=null && root.left != node &&
				root.right !=null && root.right != node)
			{
				printLevel(root.left, node, level - 1);
				printLevel(root.right, node, level - 1);
			}
		}

		// Function to print all cousins of given node
		void printAllCousins(TreeNode root, TreeNode node)
		{
			int level = 0;

			// find level of given node
			Level(root, node, 1, level);

			// print all cousins of given node using its level number
			printLevel(root, node, level);
		}
		
		
		
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("Simple tree");
		// Given Node
	    int NodeData = 30;
	    int p, level, sum;
	 
	    // fuction call to find the parent node
	    p = parentNode(rootNode, NodeData);
	 
	    // if given Node is not present then print -1
	    if (p == -1)
	        System.out.println("-1\n");
	 
	    // if present then find the level of the node
	    // and call the sum of cousin function
	    else {
	 
	        // fuction call to find the level of that node
	       // level = levelOfNode(rootNode, NodeData);
	        level=getLevelOfNode(rootNode, NodeData, 1);
	        System.out.println(level);
	        // sum of cousin nodes of the given nodes
	        sum = sumOfCousin(rootNode, p, 0, level);
	 
	        // print the sum
	        System.out.println(sum);
	    }
		
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
