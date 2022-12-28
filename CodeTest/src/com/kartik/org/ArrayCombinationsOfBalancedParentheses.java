package com.kartik.org;

import java.util.Stack;

/**
 * 
 * 
 * 
 * 
1>Print all combinations of balanced parentheses
Examples:

Input : n=1
Output: {}

Input : n=2
Output: 
{}{}
{{}}


2>Print all combinations of balanced parentheses
Examples:

Input : n=1
Output: {}

Input : n=2
Output: 
{}{}
{{}}

3>Maching parentheses
Examples:

Input: {}
Output:true

Input: 
{}{}
{{}}
Output:true


 * @author kmandal
 *
 */


public class ArrayCombinationsOfBalancedParentheses {

	public static void main(String[] args) {
		int count =3;
		char[] str=new char[count*2];
		System.out.println("This is combination of number of single parenthesis First Approach");
		printPar(str,0,count, count);
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println("This is combination of number of single parenthesis Second Approach");
		printBraces(4);
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		System.out.println("Check below pharenthesis are balanced or not? ");
		char exp[] = {'{','(',')','}','[',']'};
	       if (areParenthesisBalanced(exp))
	         System.out.println("Balanced ");
	       else
	         System.out.println("Not Balanced ");
	       System.out.println("----------------------------------------------------");
			System.out.println();
	}
	
	/**
	 * 	
	 * @param str
	 * @param left
	 * @param right
	 * @param count
	 */
	static void printPar(char[] str,int count,int left,int right){
		if(left<0 || right<left) 
			return;
		if(left == 0 && right == 0) {
			//this is printing of the all combination one by one combination
			System.out.println(str);
		}else{
			if(left>0){
				str[count] ='(';
				printPar(str,count+1,left-1, right);
			}
			if(right>left){
				str[count] =')';
				printPar(str,count+1,left, right-1);
			}
		}
	}
	/**
	 * 
	 * @param count
	 */
	static void printBraces(int count){
		char[] a=new char[count*2];
		if(count > 0)
	        printParenthesis(a, 0, count, 0, 0);
	        return;
	}
	/**
	 * 
	 * @param str
	 * @param pos
	 * @param count 
	 * @param left
	 * @param right
	 */
	static void printParenthesis(char str[], int pos, int count, int left, int right){
		
		if(right == count) 
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(left > right) {
                str[pos] = '}';
                printParenthesis(str, pos+1, count, left, right+1);
            }
            if(left < count) {
                str[pos] = '{';
                printParenthesis(str, pos+1, count, left+1, right);
            }
        }
		
	}
	
	
	/**
	 * Return true if expression has balanced Parenthesis
	 * @param exp
	 * @return
	 */
	static boolean areParenthesisBalanced(char exp[]) {
		/* Declare an empty character stack */
		Stack<Character> stack = new Stack<Character>();

		/*
		 * Traverse the given expression to check matching parenthesis
		 */
		for (int i = 0; i < exp.length; i++) {

			if (!Character.isAlphabetic(exp[i])) {
				/*
				 * If the exp[i] is a starting parenthesis then push it
				 */
				if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
					stack.push(exp[i]);

				/*
				 * If exp[i] is an ending parenthesis then pop from stack and
				 * check if the popped parenthesis is a matching pair
				 */
				if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

					/*
					 * If we see an ending parenthesis without a pair then
					 * return false
					 */
					if (stack.isEmpty()) {
						return false;
					}

					/*
					 * Pop the top element from stack, if it is not a pair
					 * parenthesis of character then there is a mismatch. This
					 * happens for expressions like {(})
					 */
					else if (!isMatchingPair(stack.pop(), exp[i])) {
						return false;
					}
				}

			}
		}

		/*
		 * If there is something left in expression then there is a starting
		 * parenthesis without a closing parenthesis
		 */

		if (stack.isEmpty())
			return true; /* balanced */
		else { /* not balanced */
			return false;
		}
	}
	
	/**
	 * Returns true if character1 and character2
     * are matching left and right Parenthesis
	 * @param character1
	 * @param character2
	 * @return
	 */
 static boolean isMatchingPair(char character1, char character2)
 {
    if ((character1 == '(' && character2 == ')') || (character1 == '{' && character2 == '}') || (character1 == '[' && character2 == ']'))
      return true;
    else
      return false;
 }
  
	
  


}
