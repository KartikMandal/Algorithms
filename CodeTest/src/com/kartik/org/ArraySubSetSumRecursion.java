package com.kartik.org;
//https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
public class ArraySubSetSumRecursion {
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
          solution[index] = 1;// select the element
          currSum += A[index];
          find(A, currSum, index + 1, sum, solution);
          currSum -= A[index];	
          solution[index] = 0;// do not select the element
          find(A, currSum, index + 1, sum, solution);
        }
        return;
      }
      public static void main(String[] args) {
        int[] A = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
                14, 15 };
        /*int[] A = { 1, 3,2};*/
        int[] solution = new int[A.length];
        find(A, 0, 0, 15, solution);
      }
}
