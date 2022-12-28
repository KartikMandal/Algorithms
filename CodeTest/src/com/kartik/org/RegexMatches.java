package com.kartik.org;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author kmandal
 *
 */
public class RegexMatches {

	private static final String[] formats = {
			"((1[0-2]|[0-2][1-9]):[0-5][0-9](:[0-5][0-9])?(.[0-9]?[0-9]?[0-9])?(\\s)?(?i)(AM|PM|am|pm))",
			"(([0-1][1-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?(.[0-9]?[0-9]?[0-9])?)",
			"(on|On)?(\\s)?(0?[1-9]|[12][0-9]|3[01])([/-])(0?[1-9]|1[012])([/-])((19|20)\\d\\d)",
			"(on|On)?(\\s)?(0?[1-9]|1[012])([/-])(0?[1-9]|[12][0-9]|3[01])([/-])((19|20)\\d\\d)",
			"(on|On)?(\\s)?(0?[1-9]|[12][0-9]|3[01])([/-])((0?[1-9])|(1[0-2]))([/-])(\\d\\d)?",
			"(on|On)?(\\s)?(0?[1-9]|[12][0-9]|3[01])([/-])([0-9][0-9])(([/-])(\\d\\d))?" };

	public static void main(String args[]) {
		// String to be scanned to find the pattern.
		String line = "This is Kartik Born was 25/02/1986 placed at Saharda for QT3000! OK? and died on 03/24/2015 Mandal Exact time 24-02-1986 10:10:30 AM card number xxxx, $ 00,00, on 05/10 or 11/10/17 02:24:00 . If you don't recognize call 40032 2412. 11/11 22:24:00 AM";
		//line="on";
		// Create a Pattern object
		for (int i = 0; i < formats.length; i++) {
			int k = 0;
			String[] convertArray = new String[100];
			String replaceDate;
			Pattern pattern = Pattern.compile(formats[i]);
			// Now create matcher object.
			Matcher match = pattern.matcher(line);
			while (match.find()) {
				convertArray[k] = match.group();
				k++;
			}

			for (int j = 0; j < k; j++) {
				replaceDate = "++++";
				line = line.replaceAll(convertArray[j], replaceDate);
			}
		}
		System.out.println(line);

	}
}
