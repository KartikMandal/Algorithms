package com.kartik.org;
/**
 * 
 * @author kmandal
 *
 */
public class ArrayIntersection {

	public static void main(String[] args) {
		int a[] ={2,5,6,7,8};//this are sorting 
		int b[]={6,7,9,4};//this are also sorting
		findIntersection(a, a.length, b, b.length);
	}

	public static void findIntersection(int a[], int m, int b[], int n)
	{
	    if(m==0 || n==0)    
	    	return;
	    int i=0,j=0;
	    while(i<m && j<n)
	    {
	        if(a[i]==b[j]){
	               System.out.println(a[i]+" "+b[j]);
	                i++;
	                j++;
	        }
	        else if(a[i]<b[j])
	            i++;
	        else
	            j++;
	    }
	}
}
