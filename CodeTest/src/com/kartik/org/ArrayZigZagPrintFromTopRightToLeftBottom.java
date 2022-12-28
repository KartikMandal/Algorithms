package com.kartik.org;

/**
 * 
 * @author kmandal
 *
 */
public class ArrayZigZagPrintFromTopRightToLeftBottom {
	/**
	 * -->03
	 * --> 02 -->13
	 * -->01-->12 -->23
	 * -->00-->11-->22 
	 * -->10-->21
	 * -->20
	 * 
	 * 4--> 3--> 8--> 2--> 7--> 12--> 1--> 6--> 11--> 16--> 5--> 10--> 15--> 9--> 14--> 13
	 */
	static void mergeDiogonalUperAndLower(int [][]matrix){
		int column=matrix[0].length;
		zigDiogonalUpper(matrix,column-1);
		zigDiogonalLower(matrix,1);
	}
	
	
	/**
	 * -->03
	 * --> 02 -->13
	 * -->01-->12 -->23
	 * -->00-->11-->22 
	 */
	static void zigDiogonalUpper(int[][] matrix, int bottom) {
		int column = matrix[0].length;
		
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int i=0;
		int k=bottom;
		
		
		for(int j=bottom;j<=column-1;j++){
			System.out.print(matrix[i][j] +  "--> ");
			i++;
		}
		
		if(k>0){
		 zigDiogonalUpper(matrix, k-1);
		}
	}
	
	/**
	 * -->10-->21
	 * -->20
	 */
	static void zigDiogonalLower(int [][]matrix,int top){
		int row = matrix.length;
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int m=0;
		int n=top;
		for(int j=top;j<=row-1;j++){
			System.out.print(matrix[j][m] + "--> ");
			m++;
		}
		
		if(n<row-1){
		 zigDiogonalLower(matrix, n+1);
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } 
				};
		mergeDiogonalUperAndLower(matrix);
	}
}
