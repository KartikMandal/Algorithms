package com.kartik.org;

public class ArrayToSortedBinaryTreeConvert {

	TreeNode root;
	// This method mainly 
    // calls insertRec() 
    void insert(int key) 
    { 
        root = insertRec(root, key); 
    } 
      
    /* A recursive function to  
    insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key)  
    { 
  
        /* If the tree is empty, 
        return a new node */
        if (root == null)  
        { 
            root = new TreeNode(key); 
            return root; 
        } 
  
        /* Otherwise, recur 
        down the tree */
        if (key < root.data) 
            root.left = insertRec(root.left, key); 
        else if (key > root.data) 
            root.right = insertRec(root.right, key); 
  
        /* return the root */
        return root; 
    } 
      
    // A function to do  
    // inorder traversal of BST 
    void inorderOrSortedTree(TreeNode root)  
    { 
        if (root != null)  
        { 
            inorderOrSortedTree(root.left); 
            System.out.print(root.data + " "); 
            inorderOrSortedTree(root.right); 
        } 
    } 
    void treeInsert(int arr[]) 
    { 
        for(int i = 0; i < arr.length; i++) 
        { 
            insert(arr[i]); 
        } 
          
    } 
	public static void main(String[] args) {
		ArrayToSortedBinaryTreeConvert tree = new ArrayToSortedBinaryTreeConvert(); 
	        int arr[] = {5, 4, 7, 2, 11}; 
	        tree.treeInsert(arr); 
	        tree.inorderOrSortedTree(tree.root); 

	}

}
