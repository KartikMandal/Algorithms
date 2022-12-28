package com.kartik.org;
/**
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 * @author kmandal
 *
 */
public class BinaryTreeToDoublyLinkListConvert {

	
	// 'head' - reference to head node of created 
    //double linked list 
    static TreeNode head; 
  
    // A simple recursive function to convert a given 
    // Binary tree to Doubly Linked List 
    static void BToDLL(TreeNode root)  
    { 
        // Base cases 
        if (root == null) 
            return; 
  
        // Recursively convert right subtree 
        BToDLL(root.right); 
  
        // insert root into DLL 
        root.right = head; 
  
        // Change left pointer of previous head 
        if (head != null) 
            (head).left = root; 
  
        // Change head of Doubly linked list 
        head = root; 
  
        // Recursively convert left subtree 
        BToDLL(root.left); 
    } 
  
    // Utility function for printing double linked list. 
   static void printList(TreeNode head)  
    { 
        System.out.println("Extracted Double Linked List is : "); 
        while (head != null)  
        { 
            System.out.print(head.data + " "); 
            head = head.right; 
        } 
    } 
	
	public static void main(String[] args) {
		TreeNode t=createBinaryTree();
		/*BinaryTreeView btv=new BinaryTreeView(t,200,200);
		btv.refresh();*/
		
		BToDLL(t); 
        printList(t); 
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
