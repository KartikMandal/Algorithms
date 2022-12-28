package com.kartik.org;

import java.util.Stack;

/**
 * <code>
 * 
 * Infix Expression			Prefix Expression			Postfix Expression<br>
	A+B*C+D						++A*BCD						ABC*+D+<br>
	(A+B)*(C+D)					*+AB+CD						AB+CD+*<br>
	A*B+C*D						+*AB*CD						AB*CD*+<br>
	A+B+C+D						+++ABCD						AB+C+D+
 * </code>
 * @author kmandal
 *
 */
public class StringPostfixToInfixConverter {

	public static void main(String[] args) {
		String postfixExp = "ABC*+D+";
		System.out.println(postfixExp+" ->Post fix to infix conveter -> "+getPostToInfix(postfixExp));
		String prefixExp="++A*BCD";
		System.out.println(prefixExp+" ->Prefix to infix conveter -> "+getPrefixToInfix(prefixExp));
		String infixExp="((A+(B*C))+D)";
		
		System.out.println(infixExp+" ->infix to postfix conveter -> "+infixToPostfix(infixExp));
		
		//System.out.println(infix+" ->infix to prefix conveter -> "+infixToPrefix(infix));
		
	}
	
		
	// function to check if character is operator or not
	static boolean isOperator(char x) {
	  switch (x) {
	  case '+':
	  case '-':
	  case '/':
	  case '*':
	    return true;
	  }
	  return false;
	}
	 
	// Get Infix for a given postfix
	// expression
	static String getPostToInfix(String st)
	{
	   Stack<String> s = new Stack<String>();
	  char[] exp=st.toCharArray();
	    for (int i=0; i<exp.length; i++)
	    {
	        // Push operands
	        if (Character.isAlphabetic(exp[i]))
	        {
	           String op=String.valueOf(exp[i]);
	           s.push(op);
	        }
	 
	        // We assume that input is
	        // a valid postfix and expect
	        // an operator.
	        else
	        {
	            String op1 = s.peek();
	            s.pop();
	            String op2 = s.peek();
	            s.pop();
	            s.push("(" + op2 + exp[i] +
	                   op1 + ")");
	        }
	    }
	 
	    // There must be a single element
	    // in stack now which is the required
	    // infix.
	    return s.peek();
	}
	 
	
	
	static String getPrefixToInfix(String st)
	{
	   Stack<String> s = new Stack<String>();
	  char[] exp=st.toCharArray();
	// reading from right to left
	  for (int i = exp.length - 1; i >= 0; i--) {
	 
	    // check if symbol is operator
	    if (isOperator(exp[i])) {
	    	// Push operands
	            String op1 = s.peek();   
	            s.pop();
	            String op2 = s.peek();   
	            s.pop();
	            // concat the operands and operator
	            String temp = "(" + op1 + exp[i] + op2 + ")";
	       
	            // Push string temp back to stack
	            s.push(temp);
	          }
	       
	          // if symbol is an operand
	          else {
	       
	            // push the operand to the stack
	            s.push(String.valueOf(exp[i]));
	          }
	        }
	        // Stack now contains the Infix expression
	        return s.peek();
	  }
	
	
	
	static boolean isTernaryOperator(char c)
	{
	    return (!Character.isAlphabetic(c) && !Character.isDigit(c));
	}
	 
	static int getPriority(char C)
	{
	    if (C == '-' || C == '+')
	        return 1;
	    else if (C == '*' || C == '/')
	        return 2;
	    else if (C == '^')
	        return 3;
	    return 0;
	}
	 
	static String infixToPostfix(String dd)
	{
		String ss= '(' + dd + ')';
	    char[] infix = ss.toCharArray();
	    
	    int l = infix.length;
	    Stack<Character> stack = new Stack<Character>();
	    String output = "";
	 
	    for (int i = 0; i < l; i++) {
	 
	        // If the scanned character is an 
	        // operand, add it to output.
	        if (Character.isAlphabetic(infix[i]) || Character.isDigit(infix[i]))
	            output += String.valueOf(infix[i]);
	 
	        // If the scanned character is an
	        // ‘(‘, push it to the stack.
	        else if (infix[i] == '(')
	            stack.push('(');
	 
	        // If the scanned character is an
	        // ‘)’, pop and output from the stack 
	        // until an ‘(‘ is encountered.
	        else if (infix[i] == ')') {
	 
	            while (stack.peek() != '(') {
	                output += stack.peek();
	                stack.pop();
	            }
	 
	            // Remove '(' from the stack
	            stack.pop(); 
	        }
	 
	        // Operator found 
	        else {
	             
	            if (isTernaryOperator(stack.peek())) {
	                while (getPriority(infix[i])
	                   <= getPriority(stack.peek())) {
	                    output += stack.peek();
	                    stack.pop();
	                }
	 
	                // Push current Operator on stack
	                stack.push(infix[i]);
	            }
	        }
	    }
	    return output;
	}
	 
	static String infixToPrefix(String dd)
	{
		
	    char[] infix = dd.toCharArray();
	    /* Reverse String
	     * Replace ( with ) and vice versa
	     * Get Postfix
	     * Reverse Postfix  *  */
	    int l = infix.length;
	 
	    // Reverse infix
	   // reverse(infix[0], infix[l-1]);
	 
	    // Replace ( with ) and vice versa
	    for (int i = 0; i < l; i++) {
	 
	        if (infix[i] == '(') {
	            infix[i] = ')';
	            i++;
	        }
	        else if (infix[i] == ')') {
	            infix[i] = '(';
	            i++;
	        }
	    }
	 
	    String prefix = infixToPostfix(String.valueOf(infix));
	 
	    // Reverse postfix
	    //reverse(ss[0], ss[ss.length-1]);
	 
	    return prefix;
	}
}
