package com.kartik.org;
/**
 * https://www.geeksforgeeks.org/sparse-matrix-representation/
 * @author kmandal
 * <p>
 *<b>Why to use Sparse Matrix instead of simple matrix ?</b>
 *<u><b>Storage:</b></u> There are lesser non-zero elements than zeros and thus lesser memory can be used to store only those elements.
 *<b>Computing time:</b> Computing time can be saved by logically designing a data structure traversing only non-zero elements..
 *</p>
 */
public class MatrixToConvertSparseMatrix {

	
	public static void main(String[] args) {
	        int sparseMatrix[][] 
	                = { 
	                    {0, 0, 3, 0, 4}, 
	                    {0, 0, 5, 7, 0}, 
	                    {0, 0, 0, 0, 0}, 
	                    {0, 2, 6, 0, 0} 
	                }; 
	  
	        simpleMetrixToArraySparseMetrixCreate(sparseMatrix); 
	        System.out.println("==============================");
	        simpleMetrixToLinkedSparseMetrixCreate(sparseMatrix); 
	    }
	
	private static void simpleMetrixToLinkedSparseMetrixCreate(
			int[][] sparseMatrix) {
		Node start = null; 
		
		for (int i = 0; i < sparseMatrix.length; i++) 
		    for (int j = 0; j < sparseMatrix[0].length; j++) 
     
		        // Pass only those values which are non - zero 
		        if (sparseMatrix[i][j] != 0){ 
		        	start= create_new_node(start, sparseMatrix[i][j], i, j); 
		        }
     
		PrintList(start);
	}
	/**
	 * 
	 * @param sparseMatrix
	 */
	private static void simpleMetrixToArraySparseMetrixCreate(
			int[][] sparseMatrix) {
		int size = 0; 
		for (int i = 0; i < sparseMatrix.length; i++)  
		{ 
		    for (int j = 0; j < sparseMatrix[0].length; j++)  
		    { 
		        if (sparseMatrix[i][j] != 0)  
		        { 
		            size++; 
		        } 
		    } 
		} 
  
		// number of columns in compactMatrix (size) must be 
		// equal to number of non - zero elements in 
		// sparseMatrix 
		//3 because one for row,two for col and three for value holding
		int compactMatrix[][] = new int[3][size]; 
  
		// Making of new matrix 
		int k = 0; 
		for (int i = 0; i < sparseMatrix.length; i++)  
		{ 
		    for (int j = 0; j <sparseMatrix[0].length; j++) 
		    { 
		        if (sparseMatrix[i][j] != 0)  
		        { 
		            compactMatrix[0][k] = i; 
		            compactMatrix[1][k] = j; 
		            compactMatrix[2][k] = sparseMatrix[i][j]; 
		            k++; 
		        } 
		    } 
		} 
  
		/*for (int i = 0; i < 3; i++)  
		{ 
		    for (int j = 0; j < size; j++)  
		    { 
		        System.out.printf("%d ", compactMatrix[i][j]); 
		    } 
		    System.out.printf("\n"); 
		}*/
		
		PrintArray(compactMatrix);
	} 
	
	
	
	static class Node 
	{ 
	    int value; 
	    int row_position; 
	    int column_postion; 
	    Node next; 
	}
	
	
	
	// Function to create new node 
	static Node create_new_node(Node start, int non_zero_element, 
	                     int row_index, int column_index ) 
	{ 
	    Node temp, r; 
	    temp = start; 
	    if (temp == null) 
	    { 
	        // Create new node dynamically 
	        temp = new Node();
	        temp.value = non_zero_element; 
	        temp.row_position = row_index; 
	        temp.column_postion = column_index; 
	        temp.next = null; 
	        start = temp; 
	        return temp;
	    } 
	    else
	    { 
	    	Node t=null;
	        while (start != null) {
	        t=start;
	        start = start.next; 
	        }
	        // Create new node dynamically 
	        r = new Node(); 
	        r.value = non_zero_element; 
	        r.row_position = row_index; 
	        r.column_postion = column_index; 
	        r.next = null; 
	        t.next = r;
	       // start.next=temp;
	        return temp;
	        }
	    
	} 
	
	// This function prints contents of linked list 
		// starting from start 
		static void PrintArray(int compactMatrix[][]) 
		{ 
		    int size=compactMatrix[0].length;
		  
		    System.out.printf("row: "); 
		    
			    for (int j = 0; j < size; j++)  
			    { 
			        System.out.printf("%d ", compactMatrix[0][j]); 
			    } 
			    System.out.printf("\n"); 
			
		  
		    System.out.printf("col: "); 
		    for (int j = 0; j < size; j++)  
		    { 
		        System.out.printf("%d ", compactMatrix[1][j]); 
		    } 
		    System.out.printf("\n");
		    System.out.printf("val: "); 
		    for (int j = 0; j < size; j++)  
		    { 
		        System.out.printf("%d ", compactMatrix[2][j]); 
		    } 
		    System.out.printf("\n");
		} 
	  
	// This function prints contents of linked list 
	// starting from start 
	static void PrintList(Node start) 
	{ 
	    Node temp, r, s; 
	    temp = r = s = start; 
	  
	    System.out.printf("row: "); 
	    while(temp != null) 
	    { 
	  
	    	System.out.printf("%d ", temp.row_position); 
	        temp = temp.next; 
	    } 
	    System.out.printf("\n"); 
	  
	    System.out.printf("col: "); 
	    while(r != null) 
	    { 
	    	System.out.printf("%d ", r.column_postion); 
	        r = r.next; 
	    } 
	    System.out.printf("\n"); 
	    System.out.printf("val: "); 
	    while(s != null) 
	    { 
	    	System.out.printf("%d ", s.value); 
	        s = s.next; 
	    } 
	    System.out.printf("\n"); 
	} 
	}