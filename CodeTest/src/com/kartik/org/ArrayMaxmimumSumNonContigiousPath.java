package com.kartik.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrayMaxmimumSumNonContigiousPath {
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static String sumNonAdjacent(int[] arr)
	{
		int[] sum = new int[arr.length]; // store the max sum upto particular element
		Map<Long,Long> path=new LinkedHashMap<>();
		sum[0] = arr[0];
		sum[1] = Math.max(arr[0],arr[1]);
		if(arr[0]>arr[1]){
		path.put(Long.valueOf(sum[0]),Long.valueOf(sum[0]));
		}else{
			path.put(Long.valueOf(sum[0]),Long.valueOf(sum[0]));
			path.put(Long.valueOf(sum[1]),Long.valueOf(sum[1]));
		}
		for(int i=2; i<arr.length; i++)
		{
			int temp = Math.max(arr[i], arr[i] + sum[i-2]);
			sum[i] = Math.max(temp, sum[i-1]);
			if(temp>sum[i-1]){
				if(arr[i]>arr[i] + sum[i-2]){
				path.put(Long.valueOf(arr[i]),Long.valueOf(arr[i]));
				}else{
					path.put(Long.valueOf(arr[i] + sum[i-2]),Long.valueOf(arr[i]));
				}
			  }else{
				  path.put(Long.valueOf(arr[i]),Long.valueOf(arr[i]));
			  }
		}
		
		Map<Long, Long> reverseSortedMap = new TreeMap<Long, Long>(Collections.reverseOrder());
		reverseSortedMap.putAll(path);
		List<Long> list=new ArrayList<Long>();
		long tempKey=Integer.MIN_VALUE;
		int count=0;
		 for(Map.Entry<Long, Long> entry:reverseSortedMap.entrySet()){
			 long key = entry.getKey();
			 long value = entry.getValue();
			 if(count==0 || key==tempKey){
			 list.add(value);
			 tempKey=key-value;
			 }
			 
			 count++;
		 }
		 String rev="";
		 System.out.print("Print in reverse path ");
		 for (Long integer : list) {
			 if(integer!=0)
			rev=rev+"-->"+integer;
		}
		 //System.out.println(rev);
		 return rev;
		 
		//return sum[arr.length-1];
		
	}
	public static void main(String[] args) 
	{
		//int[] arr = {10, 5, 3, -3, -2, 6, 10};
		//int arr[] =new int[]{4, 5, 4, 3};
		//int arr[] = new int[]{5, 5, 10, 100, 10, 5};
		int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
 				//int arr[] =new int[]{-1, 7, 8, -5, 4};
 				//int arr[] =new int[]{3, 2, 1, -1};
 				//int arr[] =new int[]{4, 5, 4, 3};
 				//int arr[] =new int[]{5, 10, 4, -1};
 				//int arr[] =new int[]{11, 12, -2, -1};
 				//int arr[] =new int[]{-4, -2, -9, -10};
 				System.out.println("max Sum with Non Adjacent element : "+sumNonAdjacent(arr));
		
	}
}