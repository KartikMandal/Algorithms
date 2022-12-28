package com.kartik.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderSearch {
	static class WordNode{
		public String word;
	    public int depth;
	    public WordNode prev;
	 
	    public WordNode(String word, int depth, WordNode prev){
	        this.word=word;
	        this.depth=depth;
	        this.prev=prev;
	    }
	}
	 public static List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordList) {
		 List<List<String>> result = new ArrayList<List<String>>();
		 
	        HashSet<String> unvisited = new HashSet<>();
	        unvisited.addAll(wordList);
	 
	        LinkedList<WordNode> queue = new LinkedList<>();
	        WordNode node = new WordNode(beginWord,0,null);
	        queue.offer(node);
	 
	        int minLen = Integer.MAX_VALUE;
	        while(!queue.isEmpty()){
	        	WordNode top = queue.poll();
	 
	            //top if have shorter result already
	            if(result.size()>0 && top.depth>minLen){
	                return result;
	            }
	 
	            for(int i=0; i<top.word.length(); i++){
	                char c = top.word.charAt(i);
	                char[] arr = top.word.toCharArray();
	                for(char j='z'; j>='a'; j--){
	                    if(j==c){
	                        continue;
	                    }
	                    arr[i]=j;
	                    String t = new String(arr);
	 
	                    if(t.equals(endWord)){
	                        //add to result
	                        List<String> aResult = new ArrayList<>();
	                        aResult.add(endWord);
	                        WordNode p = top;
	                        while(p!=null){
	                            aResult.add(p.word);
	                            p = p.prev;
	                        }
	 
	                        Collections.reverse(aResult);
	                        result.add(aResult);
	 
	                        //stop if get shorter result
	                        if(top.depth<=minLen){
	                            minLen=top.depth;
	                        }else{
	                            return result;
	                        }
	                    }
	 
	                    if(unvisited.contains(t)){
	                    	WordNode n=new WordNode(t,top.depth+1,top);
	                        queue.offer(n);
	                        unvisited.remove(t);
	                    }
	                }
	            }
	        }
	 
	        return result;
	    }
	public static void main(String[] args) {

		String start = "hit", end = "cog";
		Set<String> set= new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength(start, end, set));
	}

}
