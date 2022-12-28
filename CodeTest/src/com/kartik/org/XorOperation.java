package com.kartik.org;

public class XorOperation {

	void encryptDecrypt(String data,char xorKey) 
	{ 
		char[] inpString = data. toCharArray();
	    // Define XOR key 
	    // Any character value will work 
	   // char xorKey = 'P'; 
	  
	    // calculate length of input string 
	    int len = inpString.length; 
	  
	    // perform XOR operation of key 
	    // with every caracter in string 
	    for (int i = 0; i < len; i++) 
	    { 
	        inpString[i] = (char) (inpString[i] ^ xorKey); 
	        System.out.printf("%c",inpString[i]); 
	    } 
	} 
	public static void main(String[] args) {
		XorOperation xor=new XorOperation();
		String data="Kartik Chandra Mandal";
		char xorKey = 'P';
		xor.encryptDecrypt(data, xorKey);

	}

}
