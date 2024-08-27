package theory.arrays;

import java.util.Arrays;

public class triangleNums {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNums(nums));
    }

    public static int triangleNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left++;
                } else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }
}
