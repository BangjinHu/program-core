package theory.arrays;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSets = new HashSet<>();
        for (int num : nums) {
            numSets.add(num);
        }
        int ans = 0;
        for (int num : numSets) {
            if (!numSets.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (numSets.contains(curNum + 1)) {
                    curLen += 1;
                    curNum += 1;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }
}
