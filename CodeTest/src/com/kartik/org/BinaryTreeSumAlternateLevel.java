package com.kartik.org;


/**
 * 
 * Maximum sum from a tree with adjacent levels not allowed
 Given a binary tree with positive integer values. Find the maximum sum of nodes such that 
 we cannot pick two levels for computing sum
 * Binary Tree Example
 *      		  40
               /      \
         	 20        60
           /   \      /  \ 
     	  10    30  50    70
     	 /            \
     	5              55
  


sum=Max{{40+10+30+50+70},{20+60+5+55}}
=Max{205,140}
=205


 * @author kmandal
 *
 */
public class BinaryTreeSumAlternateLevel {
	
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
	


	public static int printGivenlevelOrderLeftToRight(TreeNode root,int level)
	{
		int sum=0;
	   if(root==null)
	   {
	       return 0;
	   }
	   if(level==1)//only level 1 need to print each recursive not other
	   {
	        System.out.printf("%d ",root.data);
	        return sum+=root.data;
	   }
	   else if(level>1)
	   {
		   sum+=printGivenlevelOrderLeftToRight(root.left,level-1);
		   sum+= printGivenlevelOrderLeftToRight(root.right,level-1);
	   }
	return sum;
	}
	
	
	public static void levelOrderTraversalZigZag(TreeNode startNode) {
		 int h,i;
		   h=height(startNode);
		   int left_sum = 0,right_sum = 0;
		   for(i=1;i<=h;i++)
		   {
			   if(i%2==1){
				   left_sum+=printGivenlevelOrderLeftToRight(startNode,i);
			   }else{
				   right_sum+=printGivenlevelOrderLeftToRight(startNode,i);
			   }
		   }
		System.out.println("First Alternet "+left_sum+" Second Alternet "+right_sum);
		System.out.println("Maximum Sumation of alter net level "+Math.max(left_sum, right_sum));
	}
	
	public static void main(String[] args)
	{
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		System.out.println("----------First approach of level wise iterated-----------------");
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
