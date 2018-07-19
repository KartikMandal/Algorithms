package com.kartik.org;

public class Solution {
	public static void main(String args[]){
		/*int[] heights = { 0, 9, 6, -2, 7, 8, 0, -3, 2, 3 };
        int result = solution(heights);
        System.out.println(result);*/
        
        int[] A = {0,1,2,2,3,5};
        int[] B = {500000,500000,0,0,0,2000};
        System.out.println(solution( A,  B));
	}

	
	
	/*private static int solution(int[] A) {
        int initialIndex = 0;
        int withOutPit = -1;
        int dep = 0;
        boolean increasingFlag = false;


        for (int i = 0; i < A.length - 1; i++) {
            int initialHeight = A[i];
            int stepUpHeight = A[i + 1];
            if (!increasingFlag) {
                if (initialHeight < stepUpHeight) {
                    increasingFlag = true;
                    withOutPit = i;
                }
            } else { 
                if (initialHeight > stepUpHeight) {
                    int endIndex = i;
                    int firstDepth = A[initialIndex] - A[withOutPit];
                    int secondDepth = A[endIndex] - A[withOutPit];
                    int minDepth = Math.min(firstDepth, secondDepth);
                    dep = Math.max(dep, minDepth);
                    initialIndex = i;
                    increasingFlag = false;
                }
            }
        }

        int depthA = A[initialIndex] - A[withOutPit];
        int depthB = A[A.length - 1] - A[withOutPit];
        int currDepth = Math.min(depthA, depthB);
        dep = Math.max(dep, currDepth);

        return dep;
    }
	*/
	
	
	
		 public static int solution(int[] A, int[] B) {
		        int length=A.length;
		        if(length==0 || length==1)
		            return 0;
		        if(B.length<=1)
		            return 0;
		        int cnt=0;
		        float[] array = new float[length];
		        for(int iteration=0;iteration<length;iteration++){
		            array[iteration]=A[iteration]+((float)B[iteration]/1000000);
		            }
		        for(int firstIndex=0;firstIndex<length-1;firstIndex++){
		            if(array[firstIndex]>=2.0 && array[firstIndex+1]>=2.0){
		                cnt+=((length-1-firstIndex)*(length-firstIndex))/2;
		                firstIndex=length;
		            }    
		            else{
		                for(int secondIndex=firstIndex+1;secondIndex<length;secondIndex++){
		                    if((array[firstIndex]*array[secondIndex])>=(array[firstIndex]+(array[secondIndex]))){
		                        cnt++;
		                        }
		                    }
		                }
		    }

		    if(cnt>1000000000)
		        return 1000000000;

		    return cnt;    
		    }
		}
