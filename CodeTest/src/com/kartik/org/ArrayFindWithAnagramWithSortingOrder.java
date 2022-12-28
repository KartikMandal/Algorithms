package com.kartik.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * 
 * @author kmandal
 *
 */
public class ArrayFindWithAnagramWithSortingOrder {

	// Generic function to convert array to list 
    public static <T> List<T> convertArrayToList(T array[]) 
    { 
        // create a list from the Array 
        return Arrays 
            .stream(array) 
            .collect(Collectors.toList()); 
    } 
	public static void main(String args[]){
		String[] arr={"TAC","are", "CAT" , "ACT" , "TAC" , "TCA" , "ATC" , "and" ,"CTA"};
		
		List<String> list=new ArrayList<>();
		list=convertArrayToList(arr);
		list.add("doec");
		list.add("code");
		list.add("odce");
		List<String> ss= funWithAnagrams(list);
		for (String string : ss) {
			System.out.println(string);	
		}
		
	}
	 /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY s as parameter.
     */


    public static List<String> funWithAnagrams(List<String> s){
    	Set<String> set=new HashSet<String>();
    	String[] item = s.toArray(new String[s.size()]);
    	for(int i=0;i<item.length;i++){
    		for(int j=i+1;j<item.length;j++){
    		if(item[i]!=null && item[j]!=null){
    		char str1[] = item[i].toCharArray();
    		char str2[] = item[j].toCharArray();
    		boolean flag=areAnagram(str1, str2);
    		if(flag){
    			set.add(item[i]);
    			item[j]=null;
    			}
    		}
    	}
    	}
    	List<String> list = new ArrayList<String>(set);
    	Collections.sort(list);
    	return list;
    // Write your code here

    }
    
/**
 * Sort and Compare so time is order of n
 * @param str1
 * @param str2
 * @return
 */
    static boolean areAnagram(char[] str1, char[] str2) 
    { 
        // Get lenghts of both strings 
        int n1 = str1.length; 
        int n2 = str2.length; 
  
        // If length of both strings is not same, 
        // then they cannot be anagram 
        if (n1 != n2) 
            return false; 
  
        // Sort both strings 
        Arrays.sort(str1); 
        Arrays.sort(str2); 
  
        // Compare sorted strings 
        for (int i = 0; i < n1; i++) 
            if (str1[i] != str2[i]) 
                return false; 
  
        return true; 
    } 

}
