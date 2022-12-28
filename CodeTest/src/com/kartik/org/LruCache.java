package com.kartik.org;

import java.util.LinkedHashMap;
import java.util.Map;
public class LruCache<K,V> extends LinkedHashMap<K, V> {
 private static final long serialVersionUID = 1L;
 private int size;
 private LruCache(int size){
  super(size,0.75f,true);
  this.size=size;
 }
   public static<K, V> LruCache<K, V> newInstance(int size){
    return new LruCache<K, V>(size);
   }
   public void setMaxSize(int size){
   this.size=size;
   }
   @Override
   protected boolean removeEldestEntry(Map.Entry<K, V> eledest){
 return size()>size;
  
   }
 public static void main(String[] args) {
LruCache<String,String> lruCache=LruCache.newInstance(5);//number of cache memory block size
lruCache.put("1", "1");//first 1 is block number and second 1 is page number
System.out.println(lruCache);
lruCache.put("3", "3");//first 3 is block number and second 3 is page number
System.out.println(lruCache);
lruCache.put("2", "2");
System.out.println(lruCache);
lruCache.put("4", "4");
System.out.println(lruCache);
lruCache.put("5", "6");
System.out.println(lruCache);
lruCache.put("4", "1");
System.out.println(lruCache);
lruCache.put("2", "23");
System.out.println(lruCache);
lruCache.put("4", "4");
System.out.println(lruCache);
 }
}
