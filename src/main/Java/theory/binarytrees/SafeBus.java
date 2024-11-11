package theory.binarytrees;

import java.io.*;
import java.util.*;

public class SafeBus {

    // 1. 共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，一个猴子每次拿3个苹果，如果剩余的苹果不够猴子每次拿的数量，则2只猴子停止拿苹果。
    class MonkeyApple {

        public static final String MA = "MonkeyA";
        public static final String MB = "MonkeyB";

        public static void main(String[] args) {
            int appleNum = 9, mA = 2, mB = 3;
            Map<String, List<RNode>> res = mockMonkeyApple(appleNum, mA, mB);
            for (Map.Entry<String, List<RNode>> entry : res.entrySet()) {
                if (MA.equals(entry.getKey())) {
                    System.out.println("monkey A take apple process: ");
                    List<RNode> ans = entry.getValue();
                    ans.stream().forEach(r -> System.out.println("monkey a take apple " + r.getM() + " and appleNum is " + r.getAppleNum()));
                }
                if (MB.equals(entry.getKey())) {
                    System.out.println("monkey B take apple process: ");
                    List<RNode> ans = entry.getValue();
                    ans.stream().forEach(r -> System.out.println("monkey b take apple " + r.getM() + " and appleNum is " + r.getAppleNum()));
                }
            }
        }

        /**
         * 模拟2只猴子拿苹果的场景
         *
         * @param appleNum 苹果数量
         * @param mA       猴子A每次能拿苹果的数量
         * @param mB       猴子B每次能拿苹果的数量
         * @return
         */
        private static Map<String, List<RNode>> mockMonkeyApple(int appleNum, int mA, int mB) {
            Map<String, List<RNode>> ansMap = new HashMap<>() {{
                put(MA, new ArrayList<>());
                put(MB, new ArrayList<>());
            }};
            while (appleNum > 0) {
                if (appleNum >= mA) {
                    appleNum -= mA;
                    ansMap.get(MA).add(new RNode(mA, appleNum));
                } else {
                    break;
                }
                if (appleNum >= mB) {
                    appleNum -= mB;
                    ansMap.get(MB).add(new RNode(mB, appleNum));
                } else {
                    break;
                }
            }
            return ansMap;
        }

        static class RNode {
            private final int appleNum;
            private final int m;

            public RNode(int m, int appleNum) {
                this.m = m;
                this.appleNum = appleNum;
            }

            public int getAppleNum() {
                return appleNum;
            }

            public int getM() {
                return m;
            }
        }
    }

    // 2. 实现一个简单的缓存系统，并实现LRU淘汰算法，缓存大小限制30M。

    /**
     * 不能简单的理解为数量的大小限制，需要容量转换
     *
     * @param <K>
     * @param <V>
     */
    class LRUCache<K, V> {
        // 缓存大小限制，单位为MB
        private final int capacity;
        // 最大缓存容量，单位为字节
        private final int maxCapacityBytes;
        private final LinkedHashMap<K, CacheEntry<K, V>> map;
        // 当前缓存已使用的字节大小
        private int sizeBytes;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            // 转字节
            this.maxCapacityBytes = capacity * 1024 * 1024;
            this.map = new LinkedHashMap<>();
        }

        /**
         * 更新最近使用值情况
         *
         * @param key
         * @return
         */
        public V get(K key) {
            CacheEntry<K, V> entry = map.get(key);
            if (entry != null) {
                map.remove(key);
                map.put(key, entry);
                return entry.getValue();
            }
            return null;
        }

        /**
         * 容量比较 + put新值
         *
         * @param key
         * @param value
         */
        public void put(K key, V value) {
            // 如果key存在，先删除旧的entry，避免sizeBytes计算错误
            if (map.containsKey(key)) {
                sizeBytes -= map.get(key).getSize();
            }
            // 创建新的CacheEntry，并更新sizeBytes
            CacheEntry<K, V> newEntry = new CacheEntry<>(key, value, calculateSize(value));
            map.put(key, newEntry);
            sizeBytes += newEntry.getSize();

            // 如果超过了容量限制，删除最老的entry
            if (sizeBytes > maxCapacityBytes) {
                Map.Entry<K, CacheEntry<K, V>> eldest = map.entrySet().iterator().next();
                sizeBytes -= eldest.getValue().getSize();
                map.remove(eldest.getKey());
            }
        }

        /**
         * 估算对象大小，这里简化处理
         *
         * @param value
         * @return
         */
        private int calculateSize(V value) {
            if (value instanceof String) {
                return ((String) value).length();
            }
            // 对于其他类型的对象，这里简单返回一个固定值，假设每个对象占用1KB
            return 1024;
        }

        static class CacheEntry<K, V> {
            private final K key;
            private final V value;
            private final int size;

            public CacheEntry(K key, V value, int size) {
                this.key = key;
                this.value = value;
                this.size = size;
            }

            public V getValue() {
                return value;
            }

            public int getSize() {
                return size;
            }
        }
    }

    // 3. 目录 /tmp 下，请过滤出所有 "*.txt" 文件，解析文件，以行为单位，全局统计重复次数最多的前10条文本行。
    class FilesFilter {

        public static void main(String[] args) throws FileNotFoundException {

            String directoryPath = "/tmp";
            List<String> files = filesFilter(directoryPath);
            // 打印文件名
            for (String cur : files) {
                System.out.println(cur);
            }
        }

        private static List<String> filesFilter(String directoryPath) throws FileNotFoundException {
            File directory = new File(directoryPath);
            Map<String, Integer> lineCountMap = new HashMap<>();
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            line = line.trim();
                            lineCountMap.put(line, lineCountMap.getOrDefault(line, 0) + 1);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(lineCountMap.entrySet());
            // 排序
            entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
            List<String> res = new ArrayList<>();
            for (int i = 0; i < Math.min(10, entryList.size()); i++) {
                Map.Entry<String, Integer> entry = entryList.get(i);
                res.add(entry.getKey());
            }
            return res;
        }
    }
}
