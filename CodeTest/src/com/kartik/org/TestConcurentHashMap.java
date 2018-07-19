package com.kartik.org;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestConcurentHashMap {

	public final static int THREAD_POOL_SIZE = 5;

	public static Map<String, Integer> mandalHashTableObject = null;
	public static Map<String, Integer> mandalSynchronizedMapObject = null;
	public static Map<String, Integer> mandalConcurrentHashMapObject = null;

	public static void main(String[] args) throws InterruptedException {

		// Test with Hashtable Object
		mandalHashTableObject = new Hashtable<String, Integer>();
		mandalPerformTest(mandalHashTableObject);

		// Test with synchronizedMap Object
		mandalSynchronizedMapObject = Collections
				.synchronizedMap(new HashMap<String, Integer>());
		mandalPerformTest(mandalSynchronizedMapObject);

		// Test with ConcurrentHashMap Object
		mandalConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		mandalPerformTest(mandalConcurrentHashMapObject);

	}

	public static void mandalPerformTest(
			final Map<String, Integer> mandalThreads)
			throws InterruptedException {

		System.out.println("Test started for: " + mandalThreads.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {

			long startTime = System.nanoTime();
			ExecutorService mandalExServer = Executors
					.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				mandalExServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {

						for (int i = 0; i < 500000; i++) {
							Integer mandalRandomNumber = (int) Math.ceil(Math
									.random() * 550000);

							// Retrieve value. We are not using it anywhere
							Integer mandalValue = mandalThreads.get(String
									.valueOf(mandalRandomNumber));

							// Put value
							mandalThreads.put(
									String.valueOf(mandalRandomNumber),
									mandalRandomNumber);
						}
					}
				});
			}

			// Make sure executor stops
			mandalExServer.shutdown();

			// Blocks until all tasks have completed execution after a shutdown
			// request
			mandalExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime
					+ " ms");
		}
		System.out.println("For " + mandalThreads.getClass()
				+ " the average time is " + averageTime / 5 + " ms\n");
	}

}
