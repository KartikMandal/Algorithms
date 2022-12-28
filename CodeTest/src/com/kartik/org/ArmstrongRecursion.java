package com.kartik.org;

public class ArmstrongRecursion {

	int x;
	int findArmstrong(int number,int result,int digits)
	{
	if(number!=0)
	{
		x=number%10;
		result+=Math.pow(x, digits);
		number/=10 ;
		return findArmstrong(number,result,digits);
	}
	return result;
	}
	
	
	public static void main(String[] arg)
	{
		int low = 152, high = 9999999;
		ArmstrongRecursion ar=new ArmstrongRecursion();
        for(int number = low ; number < high; ++number) {
            int digits = 0;
            int result = 0;
            int originalNumber = number;
            // number of digits calculation
            while (originalNumber != 0) {
                originalNumber /= 10;
                ++digits;
            }
            result=ar.findArmstrong(number,0,digits);
            if (result == number)
                System.out.print(number + " ");
        }
	}
}