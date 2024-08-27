package theory.dynamics;

import java.util.Scanner;

public class LongestSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(longestSubstring(s, k));
        }
    }

    public static int longestSubstring(String s, int k){

        /*Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            //统计每一个字符出现的次数
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (int i : countMap.values()){
            if (i >= k){
                count++;
            }
        }
        if (count == countMap.size()){
            return s.length();
        }
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++){
            if (countMap.get(s.charAt(i)) < k){
                right = i;
                if (left < right){
                    max = Math.max(max, longestSubstring(s.substring(left, right), k));
                }
                left = right + 1;
            }
            if (i == s.length() - 1){
                right = s.length();
                if(left < right){
                    max = Math.max(max, longestSubstring(s.substring(left, right), k));
                }
            }
        }
        return max;*/

        if (s == null || s.length() == 0) {
            return 0;
        }

        // 使用数组存储，效率高
        // 若包含大写字母，可以用128，如果包含其他ASCII码，可用256
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        // 是否整个字符串都符合要求
        boolean fullString = true;
        for (int i = 0; i < s.length(); i++) {
            // 若有字母小于 k 个，则说明整个字符串不符合，需要拆开来判断
            if (hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k) {
                fullString = false;
            }
        }
        if (fullString == true) {
            return s.length();
        }

        // 滑动窗口
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            // 如果遇到 right 所指元素个数小于 k，则需要由此拆开来比较其他位置
            if (hash[s.charAt(right) - 'a'] < k) {
                // aaabcccc
                // l  r     左闭右开，所以取到的是 aaa
                max = Math.max(max, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
            right++;
        }
        // aaabcccc
        //     l   r  即取到的是 cccc
        max = Math.max(max, longestSubstring(s.substring(left), k));
        return max;
    }
}
