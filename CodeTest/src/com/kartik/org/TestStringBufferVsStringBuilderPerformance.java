package com.kartik.org;

import java.util.GregorianCalendar;

public class TestStringBufferVsStringBuilderPerformance {

	public static void main(String[] args) {

		TestStringBufferVsStringBuilderPerformance tt=new TestStringBufferVsStringBuilderPerformance();
		tt.stringBuffer();
		tt.stringBuilder();
	}

	public void stringBuffer(){
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<1000000; i++){
			sb.append(":").append(i);
		}
		long end=new GregorianCalendar().getTimeInMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:"+(end-start));
		System.out.println("Memory used:"+(startMemory-endMemory));
	}
	
	public void stringBuilder(){
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<1000000; i++){
			sb.append(":").append(i);
		}
		long end=new GregorianCalendar().getTimeInMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:"+(end-start));
		System.out.println("Memory used:"+(startMemory-endMemory));
	}
}
