package LeetCodeProblem.HashTable_Problem;

import java.util.*;

public class SubDomainVisits {
    public static void main(String[] args) {

        String[] cpdomains = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(subDomainVisits(cpdomains));
    }

    public static List<String> subDomainVisits(String[] cpdomains) {

//        List<String> result = new ArrayList<>();
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String s : cpdomains){
//            //以空格划分
//            String split[] = s.split(" ");
//            //出现的次数
//            int times = Integer.valueOf(split[0]);
//            //域名
//            String domain = split[1];
//
//            //将该域名以及其出现的次数put到map中
//            put(map, domain, times);
//
//            //以小数点 . 分割域名
//            split = domain.split("\\.");
//            //二级域名
//            if (split.length == 2){
//                put(map, split[1], times);
//            }else {
//                put(map, split[split.length-1], times);
//            }
//
//            for (int i = 1; i < split.length-1; i++){
//                StringBuilder key = new StringBuilder(split[i]);
//                for (int j = i + 1; j < split.length; j++){
//                    key.append(".");
//                    key.append(split[j]);
//                }
//                put(map, key.toString(), times);
//            }
//        }
//
//        for (String domain : map.keySet()){
//            result.add(map.get(domain) + " " + domain);
//        }
//
//        return result;
//    }

//    private static void put(Map<String, Integer> map, String key, Integer val){
//        if (map.containsKey(key)){
//            map.put(key, map.get(key) + val);
//        }else {
//            map.put(key, val);
//        }
//    }

        List<String> list = new LinkedList<>();
        if (cpdomains == null || cpdomains.length == 0){
            return list;
        }

        //所有域名和出现次数存入hashMap中，域名作为key，访问次数作为value
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++){
            String[] arr = split(cpdomains[i]);
            for (int j = 0; j < arr.length; j++){
                String[] value = arr[j].split(" ");
                if (map.get(value[1]) == null){
                    map.put(value[1], value[0]);
                }else {
                    int sum = Integer.parseInt(value[0]) + Integer.parseInt(map.get(value[1]));
                    map.put(value[1], String.valueOf(sum));
                }
            }
        }

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key) + " " + key;
            list.add(value);
        }
        return list;
    }

    private static String[] split(String str){
        String[] arrOne = str.split(" ");
        String[] arrTwo = str.split("\\.");
        String[] result = new String[arrTwo.length];

        for (int i = 0; i < result.length; i++){
            StringBuilder sb = new StringBuilder(arrOne[0]);
            sb.append(" ");
            for (int j = i; j < arrTwo.length; j++){
                result[i] = String.valueOf(sb.append(arrTwo[j]));
                if (j != arrTwo.length-1){
                    result[i] = String.valueOf(sb.append("."));
                }
            }
        }
        return result;
    }
}
