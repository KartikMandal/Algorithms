package com.kartik.org;

import java.util.Arrays;
import java.util.Random;

public class PuzzelTicTacToe {

	static String[] board;
	
	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

	//	System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}
	
	
	static String[][] b;

	static String checkWinnerW() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = b[0][0] + b[0][1] + b[0][2];
				break;
			case 1:
				line = b[1][0] + b[1][1] + b[1][2];
				break;
			case 2:
				line = b[2][0] + b[2][1] + b[2][2];
				break;
			case 3:
				line = b[0][0] + b[1][0] + b[2][0];
				break;
			case 4:
				line = b[0][1] + b[1][1] + b[2][1];
				break;
			case 5:
				line = b[0][2] + b[1][2] + b[2][2];
				break;
			case 6:
				line = b[0][0] + b[1][1] + b[2][2];
				break;
			case 7:
				line = b[0][2] + b[1][1] + b[2][0];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		return null;
	}
	
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	static void display(){
		for (String[] strings : b) {
			for (String string : strings) {
				System.out.printf(string+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		board = new String[9];
		b=new String[3][3];
		for(int i=0;i<9;i++){
			int ran=getRandomNumberInRange(0, 1);
			if(ran==0){
			board[i]="X";
			}else{
			board[i]="O";
			}
			
		}
		System.out.println(checkWinner());
		
		System.out.println("------------------------------");
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int ran=getRandomNumberInRange(0, 1);
				if(ran==0){
				b[i][j]="X";
				}else{
				b[i][j]="O";
				}
			}
		}
		display();
		System.out.println("---------------------output--------------");
		System.out.println(checkWinnerW());
	}

}
