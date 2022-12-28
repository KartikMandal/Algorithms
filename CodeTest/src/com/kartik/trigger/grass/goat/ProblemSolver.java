package com.kartik.triger.grass.goat;

import java.util.Scanner;
public class ProblemSolver
{
 static char continueOption;
 static char menuOpion;

 public static void main(String[] args) {
  // Numbers to be adjusted if the debug toggle is present, as components
  // of args will be in different locations if it is.
  // Print out correct usage and end the program if there aren't any
  // parameters
  do {
   System.out
     .println("'B' - To be execute forTiger Goat And Grass problem by Bfs algo running");
   System.out
     .println("'D' - To be execute forTiger Goat And Grass problem by Dfs algo running");
   System.out.println("'N' - To quite running program");
   System.out.println("Please choose your choices");
   Scanner keyboard = new Scanner(System.in);
   String input = keyboard.next();
   menuOpion = input.charAt(0);
   boolean debug = false;
   switch (menuOpion) {
   case 'B':
    BFSearchForBTGG.search(debug);
    break;
   case 'D':
    DFSearchForBTGG.search(debug);
    break;
   default:
    System.out.println("you enter wrong menu option");
   }
   System.out.println();
   System.out.print("Do you want to Continue? Y/N");
   continueOption = keyboard.next().charAt(0);
  } while (continueOption == 'Y' || continueOption == 'y');
 }
}