package theory.ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeRange {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeRanges(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeRanges(int[][] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int start = 0;
        while (start < nums.length) {
            int left = nums[start][0], right = nums[start][1];
            while (left < nums.length - 1 && right >= nums[start + 1][0]) {
                right = Math.max(right, nums[start + 1][1]);
                start++;
            }
            list.add(new int[]{left, right});
            start++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
