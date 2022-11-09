package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeArrRange {

    public static void main(String[] args) {

    }

    public int[][] megeArrRange(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0 || nums.length <= 1) {
            return nums;
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int start = 0;
        List<int[]> ansList = new ArrayList<>();
        while (start < nums.length) {
            int left = nums[start][0];
            int right = nums[start][1];
            while (start < nums.length - 1 && right > nums[start + 1][0]) {
                right = Math.max(right, nums[start+1][1]);
                start++;
            }
            ansList.add(new int[]{left, right});
            start++;
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }
}
