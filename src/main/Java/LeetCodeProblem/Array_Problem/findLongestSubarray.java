package LeetCodeProblem.Array_Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findLongestSubarray {

    public static void main(String[] args) {
        String[] arr = new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] result = findLongestSubarray(arr);
        for (String s : result) {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static String[] findLongestSubarray(String[] arr) {
        int start = 0;
        int end = 0;
        Map<Integer, Integer> leftIndexMap = new HashMap<>();
        int preSum = 0;
        leftIndexMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            preSum += Character.isDigit(arr[i].charAt(0)) ? 1 : -1;
            if (!leftIndexMap.containsKey(preSum)) {
                leftIndexMap.put(preSum, i);
            } else {
                int leftIndex = leftIndexMap.get(preSum);
                if (i - leftIndex > end - start) {
                    start = leftIndex;
                    end = i;
                }
            }
        }
        return Arrays.copyOfRange(arr, start + 1, end + 1);
    }
}
