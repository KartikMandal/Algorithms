package com.kartik.org;

public class BinaryTreeGenarateFromPostAndInOrder {

	// Class Index created to implement pass by reference of Index 
	class Index { 
	    int index; 
	} 
	/* Recursive function to construct binary of size n 
    from  Inorder traversal in[] and Postrder traversal 
    post[].  Initial values of inStrt and inEnd should 
    be 0 and n -1.  The function doesn't do any error 
    checking for cases where inorder and postorder 
    do not form a tree */
	TreeNode buildUtil(int in[], int post[], int inStrt, 
                int inEnd, Index pIndex) 
 { 
     // Base case 
     if (inStrt > inEnd) 
         return null; 

     /* Pick current node from Postrder traversal using 
        postIndex and decrement postIndex */
     TreeNode node = new TreeNode(post[pIndex.index]); 
     (pIndex.index)--; 

     /* If this node has no children then return */
     if (inStrt == inEnd) 
         return node; 

     /* Else find the index of this node in Inorder 
        traversal */
     int iIndex = search(in, inStrt, inEnd, node.data); 

     /* Using index in Inorder traversal, construct left and 
        right subtress */
     node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex); 
     node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex); 

     return node; 
 } 

 // This function mainly initializes index of root 
 // and calls buildUtil() 
 TreeNode buildTree(int in[], int post[], int n) 
 { 
     Index pIndex = new Index(); 
     pIndex.index = n - 1; 
     return buildUtil(in, post, 0, n - 1, pIndex); 
 } 

 /* Function to find index of value in arr[start...end] 
    The function assumes that value is postsent in in[] */
 int search(int arr[], int strt, int end, int value) 
 { 
     int i; 
     for (i = strt; i <= end; i++) { 
         if (arr[i] == value) 
             break; 
     } 
     return i; 
 } 
 
 /* This funtcion is here just to test  */
 void preOrder(TreeNode node) 
 { 
     if (node == null) 
         return; 
     System.out.print(node.data + " "); 
     preOrder(node.left); 
     preOrder(node.right); 
 } 
	
	public static void main(String[] args) {
		BinaryTreeGenarateFromPostAndInOrder tree=new BinaryTreeGenarateFromPostAndInOrder();
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
        int n = in.length; 
        TreeNode root = tree.buildTree(in, post, n); 
        System.out.println("Preorder of the constructed tree : "); 
        tree.preOrder(root); 

	}

}
