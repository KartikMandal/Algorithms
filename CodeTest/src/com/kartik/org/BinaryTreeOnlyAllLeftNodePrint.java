package com.kartik.org;

public class BinaryTreeOnlyAllLeftNodePrint {

    // recursive function to print left view 
    void leftViewUtil(TreeNode node) 
    { 
        // Base Case 
        if (node==null) return; 
        // If this is the first node of its level 
        if(node.left!=null && node.left.data>-1){
            System.out.print(" " + node.data); 
           if(node.left.left==null){
        	   System.out.print(" " + node.left.data);
           }
        } 
        leftViewUtil(node.left);
        leftViewUtil(node.right);
    } 
  
 // recursive function to print left view 
    void rightViewUtil(TreeNode node) 
    { 
        // Base Case 
        if (node==null) return; 
        
     // If this is the first node of its level 
        if(node.right!=null && node.right.data>-1){
            System.out.print(" " + node.data); 
           if(node.right.right==null){
        	   System.out.print(" " + node.right.data);
           }
        } 
       //first right side view  
        rightViewUtil(node.right);
        // second left side view
        rightViewUtil(node.left);
     
        
    } 
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		BinaryTreeView btv=new BinaryTreeView(rootNode,400,400);
		btv.refresh();
		BinaryTreeOnlyAllLeftNodePrint bb=new BinaryTreeOnlyAllLeftNodePrint();
		System.out.println("----------Left View-----------------");
		bb.leftViewUtil(rootNode);
		System.out.println();
		//rootNode=createBinaryTree();
		System.out.println("----------Right View-----------------");
		bb.rightViewUtil(rootNode);
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
		TreeNode node5=new TreeNode(5);
		TreeNode node55=new TreeNode(55);
		TreeNode node45=new TreeNode(45);
		TreeNode node25=new TreeNode(25);
 
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
		node10.left=node5;
		node50.right=node55;
		node50.left=node20;
		node30.left=node45;
		node30.right=node25;
		return rootNode;
	}

}
