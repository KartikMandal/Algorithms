package com.kartik.org;

import java.util.HashMap;
import java.util.Random;

/*
 *https://github.com/romain-warnan/simple-java-bitly
 *https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904
 * https://gist.github.com/TomTasche/1104272
 * https://dzone.com/articles/better-explaining-cap-theorem
 * https://nickhop.wordpress.com/2013/04/11/say-goodbye-to-your-nobel-prize-and-get-a-doctorate-instead-or-frame-your-doctoral-study-around-doctoralness/
 * https://github.com/Dioud/Url-Shortener/tree/master/project/src/com/supinfo/project/servlet
 * URL Shortener: https://gist.github.com/rakeshsingh/64918583972dd5a08012
 * https://namingexception.wordpress.com/2011/10/10/implementing-url-shortener-with-servlet/
 * http://www.srccodes.com/p/article/37/expand-shortened-link-using-java
 * https://github.com/srccodes/tool-url-expander/blob/master/src/main/java/com/srccodes/tools/misc/UrlExpander.java
 * https://gist.github.com/roundrop/1432442/452dc4dafc8a3bc0dd93192047a9a91ce6d4bd21
 * http://tdkhiem.com/2017/06/22/creating-a-url-shortener-with-spring-restful-and-postgresql/
 * https://github.com/edinfazlic/URL-Shortener/tree/master/src/main/java
 */
public class GoogleUrlShortener {
	// storage for generated keys
	private HashMap<String, String> keyMap; // key-url map
	private HashMap<String, String> valueMap;// url-key map to quickly check
												// whether an url is
	// already entered in our system
	private String domain; // Use this attribute to generate urls for a custom
							// domain name defaults to http://fkt.in
	private char myChars[]; // This array is used for character to number
							// mapping
	private Random myRand; // Random object used to generate random integers
	private int keyLength; // the key length in URL defaults to 8

	// Default Constructor
	GoogleUrlShortener() {
		keyMap = new HashMap<String, String>();
		valueMap = new HashMap<String, String>();
		myRand = new Random();
		keyLength = 8;
		myChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			myChars[i] = (char) j;
		}
		domain = "http://kcm.com";
	}

	// Constructor which enables you to define tiny URL key length and base URL
	// name
	GoogleUrlShortener(int length, String newDomain) {
		this();
		this.keyLength = length;
		if (!newDomain.isEmpty()) {
			newDomain = sanitizeURL(newDomain);
			domain = newDomain;
		}
	}

	// shortenURL
	// the public method which can be called to shorten a given URL
	public String shortenURL(String longURL) {
		String shortURL = "";
		if (validateURL(longURL)) {
			longURL = sanitizeURL(longURL);
			if (valueMap.containsKey(longURL)) {
				shortURL = domain + "/tiny?k=" + valueMap.get(longURL);
			} else {
				shortURL = domain + "/tiny?k=" + getKey(longURL);
			}
		}
		// add http part
		return shortURL;
	}

	// expandURL
	// public method which returns back the original URL given the shortened url
	public String expandURL(String shortURL) {
		String longURL = "";
		String key = shortURL.substring(domain.length() + 8);
		longURL = keyMap.get(key);
		return longURL;
	}

	// Validate URL
	// not implemented, but should be implemented to check whether the given URL
	// is valid or not
	boolean validateURL(String url) {
		return true;
	}

	// sanitizeURL
	// This method should take care various issues with a valid url
	// e.g. www.google.com,www.google.com/, http://www.google.com,
	// http://www.google.com/
	// all the above URL should point to same shortened URL
	// There could be several other cases like these.
	String sanitizeURL(String url) {
		if (url.substring(0, 7).equals("http://"))
			url = url.substring(7);

		if (url.substring(0, 8).equals("https://"))
			url = url.substring(8);

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}

	/*
	 * Get Key method
	 */
	private String getKey(String longURL) {
		String key;
		key = generateKey();
		keyMap.put(key, longURL);
		valueMap.put(longURL, key);
		return key;
	}

	// generateKey
	private String generateKey() {
		String key = "";
		boolean flag = true;
		while (flag) {
			key = "";
			for (int i = 0; i <= keyLength; i++) {
				key += myChars[myRand.nextInt(62)];
			}
			// System.out.println("Iteration: "+ counter + "Key: "+ key);
			if (!keyMap.containsKey(key)) {
				flag = false;
			}
		}
		return key;
	}

	// test the code
	public static void main(String args[]) {
		//GoogleUrlShortener u = new GoogleUrlShortener(5, "www.kartik.com");
		GoogleUrlShortener u = new GoogleUrlShortener();
		String urls[] = { "https://www.blogger.com/blogger.g?rinli=1&pli=1&blogID=7240162048710832182#allposts/postNum=0" };

		for (int i = 0; i < urls.length; i++) {
			System.out.println("URL:" + urls[i] + "\tTiny: "
					+ u.shortenURL(urls[i]) + "\tExpanded: "
					+ u.expandURL(u.shortenURL(urls[i])));
		}
	}
}