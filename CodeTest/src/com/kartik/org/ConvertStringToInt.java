package com.kartik.org;

public class ConvertStringToInt {

	public static int convertStringToInt(String s) throws NumberFormatException
	{
	    int num =0;
	    for(int i =0; i<s.length();i++)
	    {
	        if(((int)s.charAt(i)>=48)&&((int)s.charAt(i)<=57))
	        {
	            num = num*10+ ((int)s.charAt(i)-48);
	        }
	        else
	        {
	            throw new NumberFormatException();
	        }

	    }
	    return num; 
	}
	public static void main(String[] args) {
		int x=convertStringToInt("2000");
		System.out.println(x);

	}

}
