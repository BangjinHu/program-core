package theory.arrays;

import java.util.Arrays;

public class isStraight {

    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int zNum = 0, dNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zNum++;
            } else {
                if (nums[i] + 1 == nums[i+1]) {
                    return false;
                }
                if (nums[i] + 1 != nums[i+1]) {
                    dNum += nums[i+1] - nums[i] - 1;
                }
            }
        }
        return zNum >= dNum;
    }
}
