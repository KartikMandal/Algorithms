package com.kartik.org;

import java.util.Arrays;
/**
 * Rotate an array by k times

Consider the array {10, 20, 30, 40, 50}. Suppose we rotate the array once, we have to move the elements 10, 20, 30, 40 right by 1 position and move the last element 50 to the beginning to get {50, 10, 20, 30, 40}. So if we have an array of size n, then for 1 rotate operation we will need n moves. If we rotate the array k times then there will be k*n moves. There is a faster method for rotating an array. Let the array be A = {10, 20, 30, 40, 50} and the number of rotations k = 2. The procedure is:
<code>
1. number of sets will be depend on the value of n and k where n is the length of array and k is the position,

2. number of sets= gcd(n,k) where gcd is greatest common divisor 

3. outer loop i=0 to i<sets

4. nums[j]=nums[(j+k)%n];

5. inner loop end when d==i

6. increment next set 

7. Time Complexity= o(n) and space Complexity= o(n)

	_____________________________________________________
	|	i	|	j	|	d=(j+k)%n	|	nums[j]=nums[d]	|
	_____________________________________________________
	|	0	|	0	|	(0+3)%9=3	|	nums[0]=nums[3]	|
	|	0	|	3	|	(3+3)%9=6	|	nums[3]=nums[6]	|
	|	0	|	6	|	(6+3)%9=0	|	nums[6]=nums[0]	|
	_____________________________________________________
	|	1	|	1	|	(1+3)%9=4	|	nums[1]=nums[4]	|
	|	1	|	4	|	(4+3)%9=7	|	nums[4]=nums[7]	|
	|	1	|	7	|	(7+3)%9=1	|	nums[7]=nums[1]	|
	_____________________________________________________
	|	2	|	2	|	(2+3)%9=5	|	nums[2]=nums[5]	|
	|	2	|	5	|	(5+3)%9=8	|	nums[5]=nums[8]	|
	|	2	|	8	|	(8+3)%9=2	|	nums[8]=nums[2]	|
	_____________________________________________________

</code>
 * @author kmandal
 *
 */
public class ArrayInplaceRotateByJugglingAlgo {

	static int gcd(int a,int b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	} 
	
	static int[] rotate(int []nums,int k){
		int d=-1,i,j,n=nums.length,temp;
		for(i=0;i<gcd(n,k);i++){
			j=i;
			temp=nums[i];
			while(true){
				d=(j+k)%n;
				if(d==i)
					break;
				nums[j]=nums[d];
				j=d;
			}
			nums[j]=temp;
		}
		return nums;
	}
		
		public static void main(String[] args) {
			int num[]={2,4,3,7,8,9,1,5,6};
			System.out.println(Arrays.toString(num));
			rotate(num,4);
			System.out.println(Arrays.toString(num));

		}
}
