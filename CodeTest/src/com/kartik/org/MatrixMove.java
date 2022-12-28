package com.kartik.org;


public class MatrixMove {

	  
	
	public static void main(String ...args){
	int[][] mat = { 
			{ 1, 2, 3, 4,17 }, 
			{ 5, 6, 7, 8,18 }, 
			{ 9, 10, 11, 12,19 },
			{ 13, 14, 15, 16,20 } 
			};
	String []dir={"LEFT","RIGHT","DOWN","LEFT","LEFT","LEFT","LEFT","RIGHT","RIGHT","DOWN","DOWN","DOWN","RIGHT","RIGHT","UP","UP","UP","UP","LEFT","LEFT","LEFT","LEFT","LEFT"};
	move(mat, dir);
	
	String []dir1={"UP"};
	
	move(mat, dir1);
	String []dir2={"DOWN","DOWN","DOWN","DOWN","DOWN"};
	move(mat, dir2);
	
	}
	
	private static enum DIRECTION 
	{ 
		LEFT, RIGHT, UP,DOWN; 
	}
	/**
	 * 
	 * @param mat
	 * @param dir
	 */
	private static void move(int [][]mat,String []dir){
		int pontX=0;
		int pontY=0;
		int []pos=new int[2];
		for (String string : dir) {
			pos=move(mat,string,pontX,pontY);
			pontX=pos[0];
			pontY=pos[1];
		}
		//System.out.println(pontX+" "+pontY);
		System.out.println(pontX+" "+pontY+"===="+mat[pontX][pontY]);
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isSafeToGo(int x, int y, int row, int col) {
		// check if x and y are in limits and cell is not blocked
		if (x >= 0 && y >= 0 && x <= row-1  && y <= col-1) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param mat
	 * @param dir
	 * @param x
	 * @param y
	 * @return
	 */
	private static int[] move(int [][]mat,String dir,int x,int y){
		int [] pont=new int[2];
		int row=mat.length;
		int col=mat[0].length;
		if(isSafeToGo(x, y, row,col)){
		if(dir.equalsIgnoreCase(DIRECTION.LEFT.name())){
			pont[0]=x;
			pont[1]=safePoint(y-1,col);
		}else if(dir.equalsIgnoreCase(DIRECTION.RIGHT.name())){
			pont[0]=x;
			pont[1]=safePoint(y+1,col);
		}else if(dir.equalsIgnoreCase(DIRECTION.UP.name())){
			pont[0]=safePoint(x-1,row);
			pont[1]=y;
		}else if(dir.equalsIgnoreCase(DIRECTION.DOWN.name())){
			pont[0]=safePoint(x+1,row);
			pont[1]=y;
		}
		}else{
			pont[0]=x<0?0:x;
			pont[1]=y<0?0:y;
		}
		return pont;
		
	}
	/**
	 * 
	 * @param cur
	 * @param max
	 * @return
	 */
	private static int safePoint(int cur,int max){
		int ret=0;
		if(cur<0){
			ret=0;
		}else if(cur>max-1){
			ret=max-1;
		}else{
			ret=cur;
		}
		return ret;
	}

}