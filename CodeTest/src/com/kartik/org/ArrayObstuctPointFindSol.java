package com.kartik.org;


/**
 * https://www.geeksforgeeks.org/number-cells-queen-can-move-obstacles-chessborad/
 * @author kmandal
 *
 */
public class ArrayObstuctPointFindSol {

    
 // Driver code 
    public static void main (String[] args) { 
  
    System.out.println(numberPosition(7, 3,2));
    } 
    
  
  @SuppressWarnings("unused")
	static int numberPosition(int n, int x, int y) 
{ 
     
     
   int c=0;
   //for diogonal SW to NE 
   for (int i=x,j=y; i<=0;i--,j++) {
	   c=c+1;
   }
 //for diogonal NE to SW
   for (int i=x,j=y; i<=n;i++,j++) {
	   c=c+1;
   }
   
 //for diogonal SE to NW
   for (int i=x,j=y; j<=0;i--,j--) {
	   c=c+1;
   }
 //for diogonal NW to SE
   for (int i=x,j=y; i<=n;i++,j++) {
	   c=c+1;
   }
   
 //for vertical N to S
   for (int i=x,j=y; i<=n;i++) {
	   c=c+1;
   }
 //for vertical S to N
   for (int i=x,j=y; i<=0;i--) {
	   c=c+1;
   }
   
   //for Horizontal W to E
   for (int i=x,j=y; j<=n;j++) {
	   c=c+1;
   }
 //for vertical S to N
   for (int i=x,j=y; j<=0;j--) {
	   c=c+1;
   }
  
   return c;
} 
    
    
}
