package com.kartik.org;

public class BinaryTreeLevelOrder {
 
		
	// prints in level order
		/*public static boolean levelOrderTraversalLeftToRight(TreeNode startNode,int level) {
			if(null == startNode){
				return false;
			}
			if(level == 1){
				System.out.println(startNode.data+" ");
				return true;
			}
			boolean left =levelOrderTraversalLeftToRight(startNode.left, level-1);
			boolean right =levelOrderTraversalLeftToRight(startNode.right, level-1);
			
			return left || right;
			
		}
			
		
		public static boolean levelOrderTraversalRightToLeft(TreeNode startNode,int level) {
			if(null == startNode){
				return false;
			}
			if(level == 1){
				System.out.println(startNode.data+" ");
				return true;
			}
			boolean right =levelOrderTraversalRightToLeft(startNode.right, level-1);
			boolean left =levelOrderTraversalRightToLeft(startNode.left, level-1);
			
			
			return right || left;
			
		}
		
		public static void levelOrderTraversalLeftToRight(TreeNode startNode) {
			if(null == startNode){
				return;
			}
			int level=1;
			while(levelOrderTraversalLeftToRight(startNode, level++)){
				
			}
			
		}
		
		public static void levelOrderTraversalRightToLeft(TreeNode startNode) {
			if(null == startNode){
				return;
			}
			int level=1;
			while(levelOrderTraversalRightToLeft(startNode, level++)){
				
			}
			
		}
		
		public static void levelOrderTraversalZigZagBinaryTree(TreeNode startNode) {
			if(null == startNode){
				return;
			}
			int level=1;
			while(levelOrderTraversalLeftToRight(startNode, level++) && levelOrderTraversalRightToLeft(startNode, level++)){
				
			}
			
		}*/
		
		public static int height(TreeNode root)
		{
		   int rightHeight,leftHeight;
		   if(root==null)
		   {
		       return 0;
		   }
		   leftHeight=height(root.left);
		   rightHeight=height(root.right);
		   if(leftHeight>rightHeight)
		   {
		        return leftHeight+1;
		   }
		   else
		   {
		        return rightHeight+1;
		   }
		}
		
		public static void levelOrderTraversalLeft(TreeNode root)
		{
		   int h,i;
		   h=height(root);
		   for(i=1;i<=h;i++)
		   {
		        printGivenlevelOrderLeftToRight(root,i);
		   }
		}
	
		public static void printGivenlevelOrderLeftToRight(TreeNode root,int level)
		{
		   if(root==null)
		   {
		       return;
		   }
		   if(level==1)//only level 1 need to print each recursive not other
		   {
		        System.out.printf("%d ",root.data);
		   }
		   else if(level>1)
		   {
		          printGivenlevelOrderLeftToRight(root.left,level-1);
		          printGivenlevelOrderLeftToRight(root.right,level-1);
		   }
		}
		
		
		public static void levelOrderTraversalRight(TreeNode root)
		{
		   int h,i;
		   h=height(root);
		   for(i=1;i<=h;i++)
		   {
			   printGivenlevelOrderRightToLeft(root,i);
		   }
		}
	
		public static void printGivenlevelOrderRightToLeft(TreeNode root,int level)
		{
		   if(root==null)
		   {
		       return;
		   }
		   if(level==1)//only level 1 need to print each recursive not other
		   {
		        System.out.printf("%d ",root.data);
		   }
		   else if(level>1)
		   {
			   printGivenlevelOrderRightToLeft(root.right,level-1);
			   printGivenlevelOrderRightToLeft(root.left,level-1);
			  
		   }
		}
		
		public static void levelOrderTraversalZigZag(TreeNode startNode) {
			 int h,i;
			   h=height(startNode);
			   for(i=1;i<=h;i++)
			   {
				   if(i%2==1){
					   printGivenlevelOrderLeftToRight(startNode,i);
				   }else{
					   printGivenlevelOrderRightToLeft(startNode,i);
				   }
			   }
			
		}
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		/*System.out.println("Level Order traversal in Zig zag left to right binary tree will be -->:");
		levelOrderTraversalLeftToRight(rootNode);
		System.out.println("Level Order traversal in Zig zag right to left  binary tree will be -->:");
		levelOrderTraversalRightToLeft(rootNode);
		System.out.println("Level Order traversal in Zig zag binary tree will be -->:");
		levelOrderTraversalZigZagBinaryTree(rootNode);*/
		
		System.out.println("Level Order traversal in Zig zag left to right binary tree will be -->:");
		levelOrderTraversalLeft(rootNode);
		System.out.println();
		System.out.println("Level Order traversal in Zig zag right to left  binary tree will be -->:");
		levelOrderTraversalRight(rootNode);
		System.out.println();
		System.out.println("Level Order traversal in Zig zag binary tree will be -->:");
		levelOrderTraversalZigZag(rootNode);
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
		node10.left=node5;
		return rootNode;
	}
}
