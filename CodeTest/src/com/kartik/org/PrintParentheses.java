package com.kartik.org;

public class PrintParentheses {

	public static void main(String[] args) {
		int count =3;
		char[] str=new char[count*2];
		printPar(str,count, count, 0);
	}
	
	public static void printPar(char[] str,int left,int right,int count){
		if(left<0 || right<left) return;
		if(left == 0 && right == 0) {
			System.out.println(str);
		}else{
			if(left>0){
				str[count] ='(';
				printPar(str,left-1, right,  count+1);
			}
			if(right>left){
				str[count] =')';
				printPar(str,left, right-1, count+1);
			}
		}
	}

}
