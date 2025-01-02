package actual.Didi;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, val);
    }
}
