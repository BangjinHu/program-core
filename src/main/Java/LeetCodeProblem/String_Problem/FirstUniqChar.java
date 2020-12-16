package LeetCodeProblem.String_Problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqChar {

    //找到字符串中第一个不重复的字符
    public static int firstUniqChar(String s){
        /*Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++){
            if (countMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;*/

        int[] counts = new int[26];
        for (char c : s.toCharArray()){
            counts[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (counts[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(firstUniqChar(s));
        }
    }
}
