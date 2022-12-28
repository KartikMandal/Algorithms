/**
 * 
 */
package com.kartik.org;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kmandal
 *
 */
public class FileJavaCommentRegex {

	public static void main(String[] args) throws Exception {

		String source = getJavaSource();
		Pattern pattern = Pattern.compile("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)");
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	public static String getJavaSource() throws Exception {
		//URL url = Thread.currentThread().getContextClassLoader().getResource("C:\\Users\\kmandal\\workspace\\30Jan2017\\CodeTest\\src\\com\\kartik\\org\\MinHeap.java");
        File file = new File("C:\\Users\\kmandal\\workspace\\30Jan2017\\CodeTest\\src\\com\\kartik\\org\\MinHeap.java");

        System.out.println("1. Absolute file path :"+file.getAbsolutePath());

        //Convert local path to URL
        URL url = file.toURI().toURL();
		return new String(Files.readAllBytes(new File(url.toURI()).toPath()));

	}
}
