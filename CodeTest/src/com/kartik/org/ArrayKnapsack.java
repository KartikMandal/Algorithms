package com.kartik.org;
/**
 * It should be noted that the above function computes the same subproblems again and again. See the following recursion tree, K(1, 1) is being evaluated twice. Time complexity of this naive recursive solution is exponential (2^n).

In the following recursion tree, K() refers to knapSack().  The two 
parameters indicated in the following recursion tree are n and W.  
The recursion tree is for following sample inputs.
wt[] = {1, 1, 1}, W = 2, val[] = {10, 20, 30}

                       K(3, 2)         ---------> K(n, W)
                   /            \ 
                 /                \               
            K(2,2)                  K(2,1)
          /       \                  /    \ 
        /           \              /        \
       K(1,2)      K(1,1)        K(1,1)     K(1,0)
       /  \         /   \          /   \
     /      \     /       \      /       \
K(0,2)  K(0,1)  K(0,1)  K(0,0)  K(0,1)   K(0,0)
Recursion tree for Knapsack capacity 2 units and 3 items of 1 unit weight.
 * @author kmandal
 *
 */
public class ArrayKnapsack {

      
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int maxWeight, int wt[], int price[], int n) 
    { 
   // Base Case 
   if (n == 0 || maxWeight == 0) 
       return 0; 
      
   // If weight of the nth item is more than Knapsack capacity W, then 
   // this item cannot be included in the optimal solution 
   if (wt[n-1] > maxWeight) 
      return knapSack(maxWeight, wt, price, n-1); 
      
   // Return the maximum of two cases:  
   // (1) nth item included  
   // (2) not included 
   else return Math.max(price[n-1] + knapSack(maxWeight-wt[n-1], wt, price, n-1), knapSack(maxWeight, wt, price, n-1)); 
     } 
 
   
  // Driver program to test above function 
  public static void main(String args[]) 
  { 
       int price[] = new int[]{60, 100, 120}; 
       int wt[] = new int[]{10, 20, 30}; 
   int  W = 65; 
   int n = price.length; 
   System.out.println(knapSack(W, wt, price, n)); 
   } 

}
