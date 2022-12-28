package com.kartik.org;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
//https://www.geeksforgeeks.org/number-cells-queen-can-move-obstacles-chessborad/
/**
 * Number of cells a queen can move with obstacles on the n queen
Consider a N X N chessboard with a Queen and K obstacles. The Queen cannot pass through obstacles. 
Given the position (x, y) of Queen, the task is to find the number of cells the queen can move.
 * @author kmandal
 *
 */
public class ArrayPuzzelOfNQueen {
	static int[] result; // this array will store the result
	
	// result[i]=j; means queen at i-th row is placed at j-th column.
	// Queens placed at (x1, y1) and (x2,y2)
	// x1==x2 means same rows, y1==y2 means same columns, |x2-x1|==|y2-y1| means
	// they are placed in diagonals.
	public boolean canPlace(int x2, int y2) {
		// This function will check if queen can be placed (x2,y2), or we can
		// say that Can queen at x2 row is placed at y2 column.
		// for finding the column for x2 row, we will check all the columns for
		// all the rows till x2-1.
		for (int i = 0; i < x2; i++) {
			//result[i] == y2 => columns are same
			//|i - x2| == |result[i] - y2| => in diagonals.
			if ((result[i] == y2)
					|| (Math.abs(i - x2) == Math.abs(result[i] - y2))) {
				return false;
			}
		}
		return true;
	}
	public void placeQueens(int x, int size, int xAxis,int yAxis) {
		for (int i = 0; i < size; i++) {
			//check if queen at xth row can be placed at i-th column.
			
			if (canPlace(x, i)) {
				result[x] = i; // place the queen at this position.
				/*if(x!=0 && i!=0){
				ss.add(x+"_"+i);
				}*/
				if (x == size - 1) {
					System.out.println("Order of " + size + " queens"
							+ Arrays.toString(result));
					System.out.println();
					display(size);
					System.out.println();
					System.out.println("Number of obstacles point of that point("+xAxis+","+yAxis +") "+numberofPosition(size,xAxis,yAxis,result));
				}
				
				placeQueens(x + 1, size,xAxis,yAxis);
			}
		}
	}
	
	static void breakLine()  
    { 
        System.out.print("\n---------------------------------\n"); 
    }
	static int no;
	 // Function to display placed queen  
    static void display(int n) 
    { 
        breakLine(); 
        System.out.print("Arrangement No. " + ++no); 
        breakLine(); 
  
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0; j < n; j++)  
            { 
                if (result[i] != j)  
                { 
                    System.out.print("\t_"); 
                } 
                else 
                { 
                    System.out.print("\tQ"); 
                } 
            } 
            System.out.println(""); 
        } 
  
        breakLine(); 
    } 
	
	 static int numberofPosition(int n, int x, int y,int[] re) 
	 { 
		 Set<String> ss=new HashSet<String>();
		 for(int i=0;i<re.length;i++){
			 ss.add(i+"_"+re[i]);
		 }
	      
	    int c=0;
	    //for diogonal SW to NE 
	    for (int i=x-1,j=y+1; i>=0;i--,j++) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	  //for diogonal NE to SW
	    for (int i=x+1,j=y-1; j>=0;i++,j--) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	    
	  //for diogonal SE to NW
	    for (int i=x-1,j=y-1; j>=0;i--,j--) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	  //for diogonal NW to SE
	    for (int i=x+1,j=y+1; i<n;i++,j++) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	    
	  //for vertical N to S
	    for (int i=x+1,j=y; i<n;i++) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	  //for vertical S to N
	    for (int i=x-1,j=y; i>=0;i--) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	    
	    //for Horizontal W to E
	    for (int i=x,j=y+1; j<n;j++) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	  //for vertical S to N
	    for (int i=x,j=y-1; j>=0;j--) {
	    	if(!ss.contains(i+"_"+j))
	 	   c=c+1;
	    }
	    
	   
	    return c;
	 } 
	public static void main(String[] args) {
		int n = 7;
		result = new int[n];
		ArrayPuzzelOfNQueen i = new ArrayPuzzelOfNQueen();
		//i.placeQueens(0, n);
		
		i.placeQueens(0, n,0,5);
	}
//0_2,1_5,2_7,3_0,4_3,5_6,6_4,7_1
}
