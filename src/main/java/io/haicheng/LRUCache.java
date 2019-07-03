package io.haicheng;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: LRUCache</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/26 13:57
 */
class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(map.containsKey(key)){
            int result = map.get(key);
            map.remove(key);
            map.put(key, result);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.size() == capacity){
            
        } else {
            map.put(key, value);
            capacity++;
        }
    }
}
