package com.kartik.java.eight;

//Java program to solve fractional Knapsack Problem 
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Comparator; 
import java.util.List;

//Greedy approach 
public class FractionalKnapSack 
{ 
 // Time complexity O(n log n) 
 public static void main(String[] args) 
 { 
     int[] wt = {10, 40, 20, 30}; 
     int[] val = {60, 40, 100, 120}; 
     String[] name = {"Rice","Tomato","Fish","Chicken"};
     int capacity = 50; 

     double maxValue = getMaxValue(wt, val, capacity,name); 
     System.out.println("Maximum value we can obtain = " +  
                         maxValue); 

 } 

 // function to get maximum value 
 private static double getMaxValue(int[] wt, 
                     int[] val, int capacity,String [] name) 
 { 
	 KnapsackItem[] iVal = new KnapsackItem[wt.length]; 

     for(int i = 0; i < wt.length; i++) 
     { 
         iVal[i] = new KnapsackItem(wt[i], val[i], i,name[i]); 
     } 

     //sorting items by value; 
     Arrays.sort(iVal, new Comparator<KnapsackItem>()  
     { 
         @Override
         public int compare(KnapsackItem o1, KnapsackItem o2)  
         { 
             return o2.cost.compareTo(o1.cost) ; 
         } 
     }); 


     double totalValue = 0d; 
     
    List<KnapsackItem> list=new ArrayList<KnapsackItem>();

     for(KnapsackItem i: iVal) 
     { 
    	 KnapsackItem mm=new KnapsackItem();
         int curWt = (int) i.wt; 
         int curVal = (int) i.val; 

         if (capacity - curWt >= 0) 
         { 
             // this weight can be picked while 
             capacity = capacity-curWt; 
             totalValue += curVal; 
             
             mm.setWt(curWt);
             mm.setCost(Double.parseDouble(curVal+""));
             mm.setName(i.getName());
             list.add(mm);
         } 
         else
         { 
             // item cant be picked whole 
             double fraction = ((double)capacity/(double)curWt); 
             totalValue += (curVal*fraction); 
             capacity = (int)(capacity - (curWt*fraction)); 
             mm.setWt(curWt);
             mm.setCost(Double.parseDouble(curVal*fraction+""));
             mm.setName(i.getName());
             list.add(mm);
             break; 
         } 


     } 

     System.out.println("Print Total Item Item :::"+totalValue);
     for (KnapsackItem knapsackItem : list) {
		System.out.println("Item Name: "+knapsackItem.getName()+" Item Cost: "+knapsackItem.getCost()+" Item Wight "+knapsackItem.getWt());
	}
     
     return totalValue; 
 } 
	}

