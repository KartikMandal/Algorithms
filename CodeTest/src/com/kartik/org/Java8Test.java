package com.kartik.java.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

	public static void main(String[] args) {

		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3,
				4, 5));
		
		ArrayList<Integer> numberListtwo = new ArrayList<>(Arrays.asList(8,9,10,11));

		Consumer<Integer> action = System.out::println;
		System.out
				.println("--------------------List Iterator using for each loop --------------");
		numberList.forEach(action);

		System.out
				.println("--------------------List To Stream to for each loop --------------");
		Stream<Integer> stream = numberList.stream();
		stream.forEach(action);

		System.out
				.println("--------------------List To Stream to filter to foreach loop Use consumer --------------");
		Consumer<Integer> action2 = System.out::println;
		// use stream and use filter
		numberList.stream().filter(n -> n % 2 != 0).forEach(action2);
		System.out
				.println("--------------------List To Stream to filter to foreach loop witout consumer--------------");
		// user filter and use System.out::println
		numberList.stream().filter(n -> n % 2 != 0)
				.forEach(System.out::println);

		System.out
				.println("--------------------List To do some Filter List and Store in List--------------");
		//Convert Stream to List – Stream.collect( Collectors.toList() )
		List<Integer> ll = numberList.stream().filter(n -> n % 2 != 0)
				.collect(Collectors.toList());
		ll.forEach(System.out::println);
		
		System.out
		.println("--------------------List To Array Convert and hold the value in Array-----------------");
		//Convert Stream to array – Stream.toArray( EntryType[]::new )
		Integer[] evenNumbersArr = numberList.stream().toArray(Integer[]::new);
		Arrays.stream(evenNumbersArr).forEach(e -> System.out.print(e + " "));
		//either above or below u can print the array
		Arrays.stream(evenNumbersArr).forEach(action2);
		
		System.out
		.println("--------------------List To Summation-----------------");
		 System.out.println(sum(numberList)); 
		//numberList.stream().filter(i -> i > 5).mapToInt(i -> i).sum();
		//numberList.forEach(System.out::println);
		
		System.out
				.println("--------------------List To MAP Convert-----------------------------------");
		numberList.stream().map(Integer::intValue).forEach(System.out::println);

		System.out
				.println("--------------------List To MAP Convert second approach-----------------------------------");
		Map<Integer, Integer> mm = numberList.stream().collect(
				Collectors.toMap(Integer::intValue, Integer::intValue));
		Consumer<Map.Entry<Integer, Integer>> actionCustoma = anyVariable -> {
			System.out.print("Key is : " + anyVariable.getKey());
			System.out.print(" and Value is : " + anyVariable.getValue());
			System.out.println();
		};
		mm.entrySet().forEach(actionCustoma);
		
		
		

		System.out
				.println("--------------------List To MAP Convert second approach for other object-----------------------");
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		Map<Integer, String> result1 = list.stream().collect(
				Collectors.toMap(Hosting::getId, Hosting::getName));
		

		Consumer<Map.Entry<Integer, String>> actionCustomaa = anyVariable -> {
			System.out.print("Key is : " + anyVariable.getKey());
			System.out.print(" and Value is : " + anyVariable.getValue());
			System.out.println();
		};
		result1.entrySet().forEach(actionCustomaa);
		
		System.out
		.println("--------------------List to Sumation of Websites-----------------------");
		 Double totalSalaryPaid = list.stream()
                 .mapToDouble(Hosting::getWebsites)
                 .sum();
		 System.out.println(totalSalaryPaid);
		 
		 
		 DoubleSummaryStatistics stats = list.stream().mapToDouble(Hosting::getWebsites).summaryStatistics();

		 System.out.println("Highest number in List : " + stats.getMax());
		 System.out.println("Lowest number in List : " + stats.getMin());
		 System.out.println("Sum of all numbers : " + stats.getSum());
		 System.out.println("Average of all numbers : " + stats.getAverage());
		 
		 String mergedString ="Kkkk ";
		 // mergedString = numberList.stream().filter(string ->string.intValue()>=0).collect(Collectors.joining(", "));
		  
		 
		System.out
		.println("--------------------List To MAP Convert second approach for remove duplicate key-----------------------");
		result1 = list.stream().collect(
				Collectors.toMap(Hosting::getId, Hosting::getName,(oldValue, newValue) -> oldValue,LinkedHashMap::new));
		//either above and below line do the list to map convert
		Map<Integer, String> result3 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName(),(oldValue, newValue) -> oldValue,LinkedHashMap::new));
		
		result1.entrySet().forEach(actionCustomaa);
		
		
		System.out
		.println("--------------------List To Sorted List using comparator-----------------");
		List<Hosting> sortedList = list.stream()
				.sorted(Comparator.comparingLong(Hosting::getWebsites))
				.collect(Collectors.toList());
	 
	    sortedList.forEach(System.out::println);//this will call to toString menthod
	    
	    
	    System.out
		.println("--------------------List To Multiple Sorted List using comparator-----------------");
		 sortedList = list.stream()
				.sorted(Comparator.comparingLong(Hosting::getWebsites))
				.collect(Collectors.toList());
	 
	    sortedList.forEach(System.out::println);//this will call to toString menthod

		System.out.println();
		System.out
				.println("================================Map Understanding ==============================");

		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		// 1. Map entries
		Consumer<Map.Entry<String, Integer>> actionMap = System.out::println;

		map.entrySet().forEach(actionMap);

		// 2. Map keys
		Consumer<String> actionOnKeys = System.out::println;

		map.keySet().forEach(actionOnKeys);

		// 3. Map values
		Consumer<Integer> actionOnValues = System.out::println;

		map.values().forEach(actionOnValues);

		// Custom Display of Map in Java 8
		Consumer<Map.Entry<String, Integer>> actionCustom = anyVariable -> {
			System.out.println("Key is : " + anyVariable.getKey());
			System.out.println("Value is : " + anyVariable.getValue());
		};

		map.entrySet().forEach(actionCustom);

		// Map<Integer,String> nnn=
		// numberList.stream().map(Integer::intValue).forEach(System.out::println);;
		numberList.stream().map(Integer::intValue).forEach(System.out::println);

		// ////////////////////Use Stream//////////////////////////////
		Stream<Integer> streams = numberList.stream();
		streams.forEach(p -> System.out.println(p));
		// stream.forEach(actionOnValues);//if we open this will give issue
		// means exception java.lang.IllegalStateException: stream has already
		// been operated upon or closed because previous line stream has already
		// been operated upon or closed
		streams = numberList.stream();
		streams.forEach(actionOnValues);

	}
	public static int sum(List<Integer> list) 
    { 
        return list.stream().mapToInt(i -> i).sum(); 
    }
}
