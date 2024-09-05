package theory.hashs;

import java.util.HashSet;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueSet.add(nums[i]);
        }
        for (Integer num : uniqueSet) {
            if (!uniqueSet.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (uniqueSet.contains(curNum + 1)) {
                    curNum += 1;
                    curLen += 1;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }
}
