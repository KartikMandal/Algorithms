package com.kartik.org;

import java.util.Arrays;
/**
 * 
 * @author kmandal
 *
 */
public class ArrayPuzzelOfTickTacCrossAndNotCount {

	/**
	 * -->03
	 * --> 02 -->13
	 * -->01-->12 -->23
	 * -->00-->11-->22 
	 * -->10-->21
	 * -->20
	 */
	static int mergeDiogonalUperAndLower(char [][]matrix,char ch, int con[], int div){
		int column=matrix[0].length;
		int cross=0;
		cross=cross+zigDiogonalUpper(matrix,column-1,'X',con,0,div);
		cross=cross+zigDiogonalLower(matrix,1,'X',con,0,div);
		return cross;		
	}
	
	
	/**
	 * -->03
	 * --> 02 -->13
	 * -->01-->12 -->23
	 * -->00-->11-->22 
	 */
	static int zigDiogonalUpper(char[][] matrix, int bottom,char ch, int con[],int cross, int div) {
		int column = matrix[0].length, row=matrix.length;
		
		int c = 0;
		int inc = 0;
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int i=0;
		int k=bottom;
		
		if(row>column){
			
		}else if(column>row){
			
		}else{
			
		}
		
		for(int j=bottom;j<=column-1;j++){
			//System.out.print(matrix[i][j] + " ");
			if (matrix[i][j] == ch ) {// ch='X'
				c++;
				con[inc] = c;
				inc = inc + 1;
			} else {
				c = 0;
				con[inc] = c;
				inc = inc + 1;
			}
			i++;
		}
		
		if(k>0){
			
			cross = commonCode(cross, div, con);
			c = 0;
			inc = 0;
			Arrays.fill(con, 0);
			//common code End
			
			
		return zigDiogonalUpper(matrix, k-1,ch, con,cross, div);
		}
		return cross;
	}
	
	/**
	 * -->10-->21
	 * -->20
	 */
	static int zigDiogonalLower(char [][]matrix,int top,char ch, int con[],int cross, int div){
		
		int row = matrix.length;
		int c = 0;
		int inc = 0;
		
		//[0 	0		-->0 	column]
		//[row 	0		-->row 	column]
		int m=0;
		int n=top;
		for(int j=top;j<=row-1;j++){
			//System.out.print(matrix[j][m] + " ");
			if (matrix[j][m] == ch) {// ch='X'
				c++;
				con[inc] = c;
				inc = inc + 1;
			} else {
				c = 0;
				con[inc] = c;
				inc = inc + 1;
			}
			
			m++;
		}
		
		if(n<row-1){
			cross = commonCode(cross, div, con);
			c = 0;
			inc = 0;
			Arrays.fill(con, 0);
			//common code End
			
		return zigDiogonalLower(matrix, n+1,ch, con,cross, div);
		}
		return cross;
	}
	
	
	/**
	 * 
	 * @param matrix
	 * @param bottom
	 * @param top
	 * @param level
	 * @param ch
	 * @param con
	 * @param cross
	 * @param div
	 * @return
	 * 
	 * 
	 * 
	 */
	
	static int zigOnlyLeftToRight(char[][] matrix, int bottom, int top,
				int level,char ch, int con[],int cross, int div) {
			int m = matrix.length, n = matrix[0].length;
			// traversing bottom to top
			int c = 0;
			int inc = 0;
			for (int j = bottom, k = top; j >= 0 && k < n; j--, k++) {
				//System.out.print(matrix[j][k] + " ");
				if (matrix[j][k] == ch) {// ch='X'
					c++;
					con[inc] = c;
					inc = inc + 1;
				} else {
					c = 0;
					con[inc] = c;
					inc = inc + 1;
				}

			}
			// changing the index to traverse from bottom to top
			if (bottom < m - 1) {
				bottom++;
			} else {
				bottom = m - 1;
				top++;
			}

			if (level++ < m + n - 1) {
				cross = commonCode(cross, div, con);
				c = 0;
				inc = 0;
				Arrays.fill(con, 0);
				//common code End
				return zigOnlyLeftToRight(matrix, bottom, top, level++,ch, con,cross, div);
			}
			return cross;
		}
	/**
	 * 
	 * @param arr
	 * @param cross
	 * @param div
	 * @param ch
	 * @return
	 */
	static int getVerticalCount(char[][] arr, int cross, int div,
			char ch) {
		int row = arr.length;
		int col = arr[0].length;
		int con[] = new int[row];
		Arrays.fill(con, 0);
		int c = 0;
		int inc = 0;
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (arr[i][j] == ch) {// ch='X'
					c++;
					con[inc] = c;
					inc = inc + 1;
				} else {
					c = 0;
					con[inc] = c;
					inc = inc + 1;
				}
			}
			cross = commonCode(cross, div, con);
			c = 0;
			inc = 0;
			Arrays.fill(con, 0);
			//common code End
		}
		return cross;
	}
	
	/**
	 * 
	 * @param arr
	 * @param cross
	 * @param div
	 * @param ch
	 * @return
	 */
	static int getHorizontalCount(char[][] arr, int cross, int div,
			char ch) {
		int row = arr.length;
		int col = arr[0].length;
		int con[] = new int[col];
		Arrays.fill(con, 0);
		int c = 0;
		int inc = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == ch) {// ch='X'
					c++;
					con[inc] = c;
					inc = inc + 1;
				} else {
					c = 0;
					con[inc] = c;
					inc = inc + 1;
				}
			}
			//common code start
			cross = commonCode(cross, div, con);
			c = 0;
			inc = 0;
			Arrays.fill(con, 0);
			//common code End
		}
		return cross;
	}

	/**
	 * @param cross
	 * @param div
	 * @param con
	 * @return
	 */
	private static int commonCode(int cross, int div, int[] con) {
		for (int p = con.length - 1; p >= 0; p--) {
			if (p >= 0) {
				if (con[p] > 0 && con[p] >= div) {
					int mod = con[p] % div;
					int data = con[p] / div;
					if (mod >= 0 && data >= 1) {
						cross = cross + (data - 1) * div + mod + 1;
						p = p - div;
					} else {
						cross = cross + mod;

					}
				}
			}

		}
		return cross;
	}

	
	public static void main(String[] args) {
		char[][] abc = new char[][] { 
				{ 'X', 'X', 'O', 'X' },
				{ 'O', 'O', 'X', 'O' }, 
				{ 'O', 'X', 'X', 'O' },
				{ 'X', 'X', 'X', 'O' } };
		int con[] = new int[abc.length*abc[0].length];
		 Arrays.fill(con, 0);
		 int div=3;
		 System.out.println(getVerticalCount(abc,0,div,'X')+getHorizontalCount(abc,0,div,'X')+zigOnlyLeftToRight(abc, 0, 0,0,'X',con,0,div)+mergeDiogonalUperAndLower(abc, 'X', con, div));
		 System.out.println(getVerticalCount(abc,0,div,'O')+getHorizontalCount(abc,0,div,'O')+zigOnlyLeftToRight(abc, 0, 0,0,'O',con,0,div)+mergeDiogonalUperAndLower(abc, 'O', con, div));
		// System.out.println(getHorizontalCount(abc,0,3,'X'));
		// System.out.println(getHorizontalCount(abc,0,3,'O'));
		 
		/* System.out.println(zigOnlyLeftToRight(abc, 0, 0,0,'X',con,0,2));
		 
		 con = new int[abc.length*abc[0].length];
		  Arrays.fill(con, 0);*/
		 
		// System.out.println(zigDiogonalLower(abc,column-1,'X',con,0,2));
		 
		// System.out.println(zigDiogonalUpper(abc,column-1,'X',con,0,2));
		 

	}

}
