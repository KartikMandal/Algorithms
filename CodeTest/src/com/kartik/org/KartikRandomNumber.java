/**
 * 
 */
package com.kartik.org;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kmandal
 *
 */
public class KartikRandomNumber implements Serializable{

	private static final long serialVersionUID = 1L;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 System.out.println(myRand());

	}

	 public static int myRand()
	 {
	   int next = testSerialversionRead();
	   next = ((next * next * next ) / 100 ) % 10000 ;
	   testSerialversionWrite(next);
	  // next=Math.abs(next);
	   return next ;
	 }
	 
	 /*public static int myRand (int next)  // Generate a 4 digit pseudo-random integer
	 {
	  // int next = 3251 ; 
	   next = ((next * next) / 100 ) % 10000 ;
	   testSerialversionWrite(next);
	   return next ;
	 }
	  
	 public static int myRandInRange ( int min, int max )  // max-min must be <10000!!
	 {
		 int taxn=testSerialversionRead();
		 
	   return myRand(taxn) % (max+1-min) + min;
	 }*/
	 
	 public static void testSerialversionWrite(int txn) {
			 try{
					FileOutputStream fout = new FileOutputStream("d:\\txnsearch1.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fout);   
					oos.writeObject(txn);
					oos.close();
				   }catch(Exception ex){
					   ex.printStackTrace();
				   } 
		}
		
		
		public static int testSerialversionRead() {
			int txn = 200;
		   try{

			   FileInputStream fin = new FileInputStream("d:\\txnsearch1.ser");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   txn = (int) ois.readObject();
			   ois.close();
		   }catch(Exception ex){
			   ex.printStackTrace(); 
		   }
		return txn; 
		}
}
