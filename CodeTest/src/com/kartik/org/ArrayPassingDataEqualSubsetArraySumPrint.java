package com.kartik.org;

import java.util.Vector;

//https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
public class ArrayPassingDataEqualSubsetArraySumPrint {
    public static void find(int[] A, int currSum, int index, int sum,
          int[] solution) {
        if (currSum == sum) {
          System.out.println("\nSum found");
          for (int i = 0; i < solution.length; i++) {
            if (solution[i] == 1) {
              System.out.print("  " + A[i]);
            }
          }

        } else if (index == A.length) {
          return;
        } else {
          solution[index] = 1;// select the element place 1
          currSum += A[index];
          find(A, currSum, index + 1, sum, solution);
          currSum -= A[index];	
          solution[index] = 0;// select the element place of array 1
          find(A, currSum, index + 1, sum, solution);
        }
        return;
      }
    
 // Returns true if there is a subset 
    // of set[] with sum equal to given sum 
    static boolean isSubsetSum(int set[], 
                            int n, int sum) 
    { 
        // Base Cases 
        if (sum == 0) 
            return true; 
        if (n == 0 && sum != 0) 
            return false; 
          
        // If last element is greater than  
        // sum, then ignore it 
        if (set[n-1] > sum) 
            return isSubsetSum(set, n-1, sum); 
          
        /* else, check if sum can be obtained  
        by any of the following 
            (a) including the last element 
            (b) excluding the last element */
        return isSubsetSum(set, n-1, sum) ||  
            isSubsetSum(set, n-1, sum-set[n-1]); 
    } 
    
    
  //Time Complexity : O(2n)
 // The vector v stores current subset.  
    static void printAllSubsetsRec(int arr[], int n, int sum,Vector<Integer> v)  
    {  
        // If remaining sum is 0, then print all  
        // elements of current subset.  
        if (sum == 0) {  
            for (int i=0;i<v.size();i++)  
                System.out.print( v.get(i) + " ");  
            System.out.println(); 
            return;  
        }  
      
        // If no remaining elements,  
        if (n == 0)  
            return;  
      
        // We consider two cases for every element.  
        // a) We do not include last element.  
        // b) We include last element in current subset.  
        printAllSubsetsRec(arr, n - 1, sum,v);  
        Vector<Integer> v1=new Vector<Integer>(v); 
        v1.add(arr[n - 1]);  
        printAllSubsetsRec(arr, n - 1,  sum - arr[n - 1], v1);  
    }  
      
    // Wrapper over printAllSubsetsRec()  
    static void printAllSubsets(int arr[], int n, int sum)  
    {  
        Vector<Integer> v= new Vector<Integer>();  
        printAllSubsetsRec(arr, n, sum, v);  
    }
    
    
    
    
      public static void main(String[] args) {
        int[] A = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
                14, 15 };
        /*int[] A = { 1, 3,2};*/
       /* int[] solution = new int[A.length];
        find(A, 0, 0, 15, solution);
        
        System.out.println();
        if (isSubsetSum(A, A.length, 9) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum");
        
        System.out.println();*/
        
        printAllSubsets(A, A.length, 15);
      }
}
