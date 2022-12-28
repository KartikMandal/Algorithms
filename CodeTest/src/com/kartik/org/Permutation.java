package com.kartik.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Java program to print all permutations of a
//given string.
public class Permutation
{
 public static void main(String[] args)
 {
     String str = "12345";
     int n = str.length();
     Permutation permutation = new Permutation();
     List<String> list=new ArrayList<String>();
     permutation.permute(str, 0, n-1,list);
     System.out.println("Permutation --->>>");
     for (String string : list) {
		System.out.println(string);
	}
     System.out.println("Shuffle --->>>");
     Collections.shuffle(list);
     System.out.println(list.get(0));
     
     System.out.println("Shuffle with --->>>");
     int[] intArray = new int[str.length()];

     for (int i = 0; i < str.length(); i++) {
     	intArray[i] = Character.digit(str.charAt(i), 10);
     }
     int a[]=RandomizeArray(intArray);
     System.out.println(Arrays.toString(a));
 }
 
 public static int[] RandomizeArray(int[] array){
	 Random rgen = new Random(); // Random number generator
	 for (int i=0; i<array.length; i++) {
	 int randomPosition = rgen.nextInt(array.length);
	 int temp = array[i];
	 array[i] = array[randomPosition];
	 array[randomPosition] = temp;
	 }
	 return array;
	 }

 /**
  * permutation function
  * @param str string to calculate permutation for
  * @param l starting index
  * @param r end index
  */
 private List<String> permute(String str, int l, int r,List<String> list)
 {
     if (l == r){
        // System.out.println(str);
      list.add(str);
     } else
     {
         for (int i = l; i <= r; i++)
         {
             str = swap(str,l,i);
             permute(str, l+1, r,list);
             str = swap(str,l,i);
         }
     }
	return list;
 }

 /**
  * Swap Characters at position
  * @param a string value
  * @param i position 1
  * @param j position 2
  * @return swapped string
  */
 public String swap(String a, int i, int j)
 {
     char temp;
     char[] charArray = a.toCharArray();
     temp = charArray[i] ;
     charArray[i] = charArray[j];
     charArray[j] = temp;
     return String.valueOf(charArray);
 }

}
