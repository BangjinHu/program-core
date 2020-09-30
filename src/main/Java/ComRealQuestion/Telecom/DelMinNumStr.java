package ComRealQuestion.Telecom;

import java.util.*;

public class DelMinNumStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            /*Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            int min = 1;
            for (char c : countMap.keySet()) {
                if (countMap.get(c) < min) {
                    min = countMap.get(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            *//*for (char c : countMap.keySet()) {
                if (countMap.get(c) == min) {
                    continue;
                }else {
                    sb.append(c);
                }
            }*//*
            for (int i = 0; i < str.length(); i++){
                if (countMap.get(str.charAt(i)) == min){
                    continue;
                }else {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());*/
            String ans = "";
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++){
                countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            int min = (int) getMinValue(countMap);
            for (int i = 0; i < str.length(); i++){
                if (countMap.get(str.charAt(i)) != min){
                    ans += str.charAt(i);
                }
            }
            System.out.println(ans);
        }
    }

    private static Object getMinValue(Map<Character, Integer> countMap) {
        if (countMap == null){
            return 0;
        }
        Collection<Integer> c = countMap.values();
        Object[] os = c.toArray();
        Arrays.sort(os);
        return os[0];
    }
}
