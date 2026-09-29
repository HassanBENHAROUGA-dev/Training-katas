package org.example.LruCache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {
    public Map<Integer, Integer> cache = new LinkedHashMap<>();
    public LinkedList<Integer> cacheKeys = new LinkedList<>();
    int capacity;
    LruCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
    }
    Integer get(int key){
        if(!cacheKeys.contains(key)) {
            return null;
        }else{
            int keyIndex = cacheKeys.indexOf(key);
            cacheKeys.add(key);
            cacheKeys.remove(keyIndex);
            return cache.get(key);
        }
    }       // null si la clé est absente
    void put(int key, int value){
        if(cacheKeys.contains(key)){
            int keyIndex = cacheKeys.indexOf(key);
            cacheKeys.add(key);
            cacheKeys.remove(keyIndex);
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if (cache.size()<capacity){
            cache.put(key, value);
            cacheKeys.add(key);
        }else{
            int oldestKey = cacheKeys.getFirst();
            cacheKeys.remove(0);
            cache.remove(oldestKey);
            cacheKeys.add(key);
            cache.put(key, value);
        }
    }
}
