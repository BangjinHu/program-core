package actual.Tencent;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> map = new LinkedHashMap<>();
    private int capacity;

    public static void main(String[] args) {

    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Integer val = map.get(key);
            map.remove(key);
            map.put(key, val);
        }
        return -1;
    }

    private void put(int key, int val) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> it =
                    map.entrySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, val);
    }
}
