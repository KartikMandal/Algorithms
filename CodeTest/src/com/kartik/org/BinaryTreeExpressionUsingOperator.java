package com.kartik.org;

import java.util.Stack;

public class BinaryTreeExpressionUsingOperator {
	public class TreeNode {
		public char data;//this is required for operator
		public TreeNode left;
		public TreeNode right;
		public TreeNode(char data)
		{
			this.data=data;
		}
		public TreeNode()
		{
		}
	}
	
	
	// A utility function to check if 'c' 
    // is an operator 
  
    boolean isOperator(char c) { 
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') { 
            return true; 
        } 
        return false; 
    } 
  
    // Utility function to do inorder traversal 
    void inorder(TreeNode t) { 
        if (t != null) { 
            inorder(t.left); 
            System.out.print(t.data + " "); 
            inorder(t.right); 
        } 
    } 
  
    // Returns root of constructed tree for given 
    // postfix expression 
    TreeNode constructTree(char postfix[]) { 
        Stack<TreeNode> st = new Stack<>(); 
        TreeNode t, t1, t2; 
  
        // Traverse through every character of 
        // input expression 
        for (int i = 0; i < postfix.length; i++) { 
  
            // If operand, simply push into stack 
            if (!isOperator(postfix[i])) { 
                t = new TreeNode(postfix[i]); 
                st.push(t); 
            } else // operator 
            { 
                t = new TreeNode(postfix[i]); 
  
                // Pop two top nodes 
                // Store top 
                t1 = st.pop();      // Remove top 
                t2 = st.pop(); 
  
                //  make them children 
                t.right = t1; 
                t.left = t2; 
  
                // System.out.println(t1 + "" + t2); 
                // Add this subexpression to stack 
                st.push(t); 
            } 
        } 
  
        //  only element will be root of expression 
        // tree 
        t = st.peek(); 
        st.pop(); 
  
        return t; 
    } 
	  
	// Function to print the infix expression for the tree 
	private void inr(TreeNode p) // recursion 
	{ 
	    if (p == null) { 
	        return; 
	    } 
	    else { 
	        inr(p.left); 
	        System.out.printf(p.data+" "); 
	        inr(p.right); 
	    } 
	} 
	  
	// Function to print the postfix expression for the tree 
	void postr(TreeNode p) 
	{ 
	    if (p == null) { 
	        return; 
	    } 
	    else { 
	        postr(p.left); 
	        postr(p.right); 
	        System.out.printf(p.data+" "); 
	    } 
	}
	// Function to print the postfix expression for the tree 
		void preFix(TreeNode p) 
		{ 
		    if (p == null) { 
		        return; 
		    } 
		    else {
		    	System.out.printf(p.data+" "); 
		        postr(p.left); 
		        postr(p.right); 
		       
		    } 
		}
	public static void main(String[] args) {
		 BinaryTreeExpressionUsingOperator bb=new BinaryTreeExpressionUsingOperator();
		    /*char a[] = {'*','+','a','b','-','c','d'};//"*+ab-cd"; 
		    for (int i = 0; i < a.length; i++) {
		    	bb.add(s, a[i]); 
			}*/
		    
		    String postfix = "ab+ef*g*-"; 
	        char[] charArray = postfix.toCharArray(); 
	        TreeNode root = bb.constructTree(charArray); 
		    System.out.printf("The Infix expression is:\n "); 
		    bb.inr(root); 
		   System.out.println();
		   System.out.println("The Postfix expression is:\n "); 
		    bb.postr(root); 
		   System.out.println();
		   bb.preFix(root);

	}

}
