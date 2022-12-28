package com.kartik.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringToIpAddressFindout {

	// Function to restore Ip Addresses 
    public static ArrayList<String> restoreIpAddresses(String A)  
    { 
        if (A.length() < 3 || A.length() > 12) 
            return new ArrayList<>(); 
        return convert(A); 
    } 
  
    private static ArrayList<String> convert(String s)  
    { 
        ArrayList<String> l =  
                  new ArrayList<>(); 
        int size = s.length(); 
  
        String snew = s; 
  
        for (int i = 1; i < size - 2;  
                               i++) 
        { 
            for (int j = i + 1;  
                 j < size - 1; j++)  
            { 
                for (int k = j + 1;  
                     k < size; k++)  
                { 
                    snew = snew.substring(0, k) + 
                           "." + snew.substring(k); 
                    snew = snew.substring(0, j) +  
                           "." + snew.substring(j); 
                    snew = snew.substring(0, i) +  
                           "." + snew.substring(i);  
                             
                    if (isValid(snew)) 
                    { 
                        l.add(snew); 
                    } 
                    snew = s; 
                } 
            } 
        } 
  
        Collections.sort(l, new Comparator<String>()  
        { 
            public int compare(String o1, String o2) 
            { 
                String a1[] = o1.split("[.]"); 
                String a2[] = o2.split("[.]"); 
  
                int result = -1; 
                for (int i = 0; i < 4 &&  
                     result != 0; i++)  
                { 
                    result = a1[i].compareTo(a2[i]); 
                } 
                return result; 
            } 
        }); 
        return l; 
  
    } 
  
    private static boolean isValid(String ip)  
    { 
        String a[] = ip.split("[.]"); 
        for (String s : a) { 
            int i = Integer.parseInt(s); 
            if (s.length() > 3 || i < 0 || i > 255)  
            { 
                return false; 
            } 
            if (s.length() > 1 && i == 0) 
                return false; 
            if (s.length() > 1 && i != 0 && 
                        s.charAt(0) == '0') 
                return false; 
        } 
  
        return true; 
    } 
  
    
    
    
    public List<String> restoreIpAddressesUsingDfs(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> t = new ArrayList<String>();
        dfs(result, s, 0, t);
     
        ArrayList<String> finalResult = new ArrayList<String>();
     
        for(ArrayList<String> l: result){
            StringBuilder sb = new StringBuilder();
            for(String str: l){
                sb.append(str+".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }
     
        return finalResult;
    }
     
    public void dfs(ArrayList<ArrayList<String>> result, String s, int start, ArrayList<String> t){
        //if already get 4 numbers, but s is not consumed, return
        if(t.size()>=4 && start!=s.length()) 
            return;
     
        //make sure t's size + remaining string's length >=4
        if((t.size()+s.length()-start+1)<4) 
            return;
     
        //t's size is 4 and no remaining part that is not consumed.
        if(t.size()==4 && start==s.length()){
            ArrayList<String> temp = new ArrayList<String>(t);
            result.add(temp);
            return;
        }
     
        for(int i=1; i<=3; i++){
            //make sure the index is within the boundary
            if(start+i>s.length()) 
                break;
     
            String sub = s.substring(start, start+i);
            //handle case like 001. i.e., if length > 1 and first char is 0, ignore the case.
            if(i>1 && s.charAt(start)=='0'){
                break;    
            }
     
            //make sure each number <= 255
            if(Integer.valueOf(sub)>255)
                break;
     
            t.add(sub);
            dfs(result, s, start+i, t);
            t.remove(t.size()-1);
        }
    }
// Driver Code 
public static void main(String[] args)  
{ 
    System.out.println(restoreIpAddresses 
              ("25525511135").toString()); 
    StringToIpAddressFindout ss=new StringToIpAddressFindout();
   List<String> ip= ss.restoreIpAddressesUsingDfs("25525511135");
   ip.stream().forEach(System.out::println);
} 

}
