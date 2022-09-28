package LeetCodeProblem.Array_Problem;

import static LeetCodeProblem.Else_Problem.RandMOut.swap;

public class sortColor {

    public static void main(String[] args) {

    }

    public void sortColor(int[] nums) {
        int low = 0, high = nums.length - 1;
        for (int i = 0; i <= high; i++) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
            } else if (nums[i] == 2) {
                swap(nums, high, i);
                high--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }


}
