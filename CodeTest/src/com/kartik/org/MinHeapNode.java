/**
 * 
 */
package com.kartik.org;

/**
 * @author kmandal
 *
 */
public class MinHeapNode {
	 int element; // The element to be stored 
     
     // index of the array from  
     // which the element is taken 
    int i; 
      
    // index of the next element  
    // to be picked from array 
    int j;  
  
    public MinHeapNode(int element, int i, int j) 
    { 
        this.element = element; 
        this.i = i; 
        this.j = j; 
    }
}
