package com.kartik.org;

import java.util.Stack;

public class ArrayCombinationsOfBalancedParentheses {

	public static void main(String[] args) {
		System.out.println("This is combination of number of single parenthesis ");
		printBraces(3);
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		System.out.println("This is all pharenthesis are balanced ");
		char exp[] = {'{','(',')','}','[',']'};
	       if (areParenthesisBalanced(exp))
	         System.out.println("Balanced ");
	       else
	         System.out.println("Not Balanced ");
	       System.out.println("----------------------------------------------------");
			System.out.println();
	}
	
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
	 * @param open
	 * @param close
	 */
	static void printParenthesis(char str[], int pos, int count, int open, int close){
		
		if(close == count) 
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                printParenthesis(str, pos+1, count, open, close+1);
            }
            if(open < count) {
                str[pos] = '{';
                printParenthesis(str, pos+1, count, open+1, close);
            }
        }
		
	}
	
	
	/* Returns true if character1 and character2
    are matching left and right Parenthesis */
 static boolean isMatchingPair(char character1, char character2)
 {
    if ((character1 == '(' && character2 == ')') || (character1 == '{' && character2 == '}') || (character1 == '[' && character2 == ']'))
      return true;
    else
      return false;
 }
  
 /* Return true if expression has balanced 
    Parenthesis */
 static boolean areParenthesisBalanced(char exp[])
 {
    /* Declare an empty character stack */
    Stack<Character> st=new Stack<Character>();
   
    /* Traverse the given expression to 
       check matching parenthesis */
    for(int i=0;i<exp.length;i++)
    {
        
    	if (!Character.isAlphabetic(exp[i]))
        {	
       /*If the exp[i] is a starting 
         parenthesis then push it*/
       if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
         st.push(exp[i]);
   
       /* If exp[i] is an ending parenthesis 
          then pop from stack and check if the 
          popped parenthesis is a matching pair*/
       if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
       {
               
           /* If we see an ending parenthesis without 
              a pair then return false*/
          if (st.isEmpty())
            {
                return false;
            } 
   
          /* Pop the top element from stack, if 
             it is not a pair parenthesis of character 
             then there is a mismatch. This happens for 
             expressions like {(}) */
          else if ( !isMatchingPair(st.pop(), exp[i]) )
            {
                return false;
            }
       }
        
    }
    }
      
    /* If there is something left in expression 
       then there is a starting parenthesis without 
       a closing parenthesis */
    
    if (st.isEmpty())
      return true; /*balanced*/
    else
      {   /*not balanced*/
          return false;
      } 
 } 
  


}
