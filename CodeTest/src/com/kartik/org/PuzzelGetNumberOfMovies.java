/**
 * 
 */
package com.kartik.org;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;

import com.google.gson.*;
/**
 * @author kmandal
 *
 */
public class PuzzelGetNumberOfMovies {
	 static int getNumberOfMovies(String substr) {
	    	String response;
	        int startPage = 1;
	        int totalPages = Integer.MAX_VALUE;
	        List<String> titles = new ArrayList<>();
	        while (startPage <= totalPages) {
	            try {
	                URL obj = new URL(
	                        "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);
	                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	                con.setRequestMethod("GET");
	                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                while ((response = in.readLine()) != null) {
	                    JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
	                    totalPages = convertedObject.get("total_pages").getAsInt();
	                    JsonArray data = convertedObject.getAsJsonArray("data");
	                    for (int i = 0; i < data.size(); i++) {
	                        String title = data.get(i).getAsJsonObject().get("Title").getAsString();
	                        titles.add(title);
	                    }
	                }
	                in.close();
	                startPage++;
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                return -1;
	            }

	        }
	        Collections.sort(titles);
	      //  return titles.toArray(new String[0]);
	        return titles.size();
	    }

	    public static void main(String[] args) throws IOException{
	    	 Scanner in = new Scanner(System.in);
	         final String fileName = System.getenv("OUTPUT_PATH");
	         BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	         int res;
	         String _substr;
	         try {
	             _substr = in.nextLine();
	         } catch (Exception e) {
	             _substr = null;
	         }
	         
	         res = getNumberOfMovies(_substr);
	         bw.write(String.valueOf(res));
	         bw.newLine();
	         
	         bw.close();
	     }
}
