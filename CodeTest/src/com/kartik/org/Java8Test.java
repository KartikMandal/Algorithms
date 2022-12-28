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
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://www.javatpoint.com/java-8-functional-interfaces
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
		//Sorting via lamda expression wise
		 //lambda
        list.sort((Hosting o1, Hosting o2)->String.valueOf(o1.getWebsites()).compareTo(String.valueOf(o2.getWebsites())));
    	//lambda
        list.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
        list.forEach(n->System.out.print(n+" "));
        
		
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

		//map.forEach((k,v)->System.out.println("Country:" + k + " Capital : " + v));
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
		
		
	    System.out.println("<<-------------------Map to List Convert ---------------------------->>>");
		
		Map<Integer, String> mapNew = new HashMap<>();
        mapNew.put(10, "apple");
        mapNew.put(20, "orange");
        mapNew.put(30, "banana");
        mapNew.put(40, "watermelon");
        mapNew.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
		
        List<Integer> result = new ArrayList(mapNew.keySet());
		
        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
		
        List<String> result2 = new ArrayList(mapNew.values());
		
        result2.forEach(System.out::println);
        
        System.out.println("<<-------------------Map to Set Convert ---------------------------->>>");
        Set<Integer> keySet=mapNew.keySet().stream().collect(Collectors.toSet());
        keySet.forEach(key-> System.out.println(key));

        Set<String> valueSet=mapNew.values().stream().collect(Collectors.toSet());
        valueSet.forEach(value-> System.out.println(value));
		
        System.out.println("<<-------------------Array summation ---------------------------->>>");
        int []myIntArray={1,4,5,7,10,20};
        
        int sum =  Arrays.stream(myIntArray).sum();
        System.out.println(" "+sum);
        IntSummaryStatistics sumSumation=Arrays.stream(myIntArray).summaryStatistics();
        
        System.out.println("<<-----------Two array to convert one Array ---------------------------->>>");
        
        int []a={1,4,5,7,10,20};
        int []b={1,4,5,7,10,20};
        
        int[] resultArr = IntStream.range(0, a.length).map(i -> a[i] * b[i]).toArray();
        
        Arrays.stream(resultArr).forEach(x->System.out.print(x+" "));
        
     // HashMap with Country as key and capital as value
        HashMap<String,String> countryCapitalMap=new HashMap<String,String>();
        countryCapitalMap.put("India","Delhi");
        countryCapitalMap.put("Japan","Tokyo");
        countryCapitalMap.put("France","Paris");
        countryCapitalMap.put("Russia","Moscow");
       
       
        // Iterating Using Java 8
        System.out.println("Iterating Using Java 8");
        System.out.println("-----------------------------");
        
        countryCapitalMap.forEach((k,v)->System.out.println("Country:" + k + " Capital : " + v));
        
        System.out.println("-----------------------------");
        
        
        ArrayList<String> nameList=new ArrayList<String> ();//creating arraylist  
        nameList.add("Arpit");//adding object in arraylist  
        nameList.add("John");  
        nameList.add("Martin");  
        nameList.add("Adam"); 
        // Iterating list using foreach method
        nameList.forEach(n->System.out.print(n+" "));
        
        System.out.println("------------Map striming-----------------");
        Map<Integer, String> map4 = new HashMap<>();
        map4.put(1, "linode.com");
        map4.put(2, "heroku.com");
    	
    	//Map -> Stream -> Filter -> String
    	String result4 = map4.entrySet().stream()
    		.filter(x -> "something".equals(x.getValue()))
    		.map(x->x.getValue())
    		.collect(Collectors.joining());

    	//Map -> Stream -> Filter -> MAP
    	Map<Integer, String> collect = map4.entrySet().stream()
    		.filter(x -> x.getKey() == 2)
    		.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    		
    	// or like this
    	Map<Integer, String> collect1 = map4.entrySet().stream()
    		.filter(x -> x.getKey() == 3)
    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    	System.out.println("------------Map striming End-----------------");
    	
    	
    	Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortMap);

     // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
        Map<String, Integer> result7 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        // Not Recommend, but it works.
        //Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result8 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result8.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result7);
        System.out.println(result8);

        
        
        //sort by values, and reserve it, 10,9,8,7,6...
        Map<String, Integer> result5 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

						
        //Alternative way
        Map<String, Integer> result6 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result6.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result5);
        System.out.println(result6);
    	
     
	}
	public static int sum(List<Integer> list) 
    { 
        return list.stream().mapToInt(i -> i).sum(); 
    }
	
	/**
() -> {}                     // No parameters; void result

() -> 42                     // No parameters, expression body
() -> null                   // No parameters, expression body
() -> { return 42; }         // No parameters, block body with return
() -> { System.gc(); }       // No parameters, void block body

// Complex block body with multiple returns
() -> {
  if (true) return 10;
  else {
    int result = 15;
    for (int i = 1; i < 10; i++)
      result *= i;
    return result;
  }
}                          

(int x) -> x+1             // Single declared-type argument
(int x) -> { return x+1; } // same as above
(x) -> x+1                 // Single inferred-type argument, same as below
x -> x+1                   // Parenthesis optional for single inferred-type case

(String s) -> s.length()   // Single declared-type argument
(Thread t) -> { t.start(); } // Single declared-type argument
s -> s.length()              // Single inferred-type argument
t -> { t.start(); }          // Single inferred-type argument

(int x, int y) -> x+y      // Multiple declared-type parameters
(x,y) -> x+y               // Multiple inferred-type parameters
(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
(x, int y) -> x+y          // Illegal: can't mix inferred and declared types
	 */
}
