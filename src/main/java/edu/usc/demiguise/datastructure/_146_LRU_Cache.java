package edu.usc.demiguise.datastructure;

import java.util.LinkedHashMap;

public class _146_LRU_Cache {

    private LinkedHashMap<Integer, Integer> cache;
    private int cap;

    public _146_LRU_Cache(int capacity) {
        cache = new LinkedHashMap<>();
        this.cap= capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        if (cache.size() == cap) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }

        cache.put(key, value);
    }

}
