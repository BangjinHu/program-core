package theory.arrays;

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2};
        System.out.println(candy(nums));
    }

    private static int candy(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += ans[i];
        }
        return res;
    }
}
