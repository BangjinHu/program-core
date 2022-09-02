package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> ansList = spiralOrder(nums);
        ansList.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ansList = new ArrayList<>();
        int up = 0, down = nums.length - 1, left = 0, right = nums[0].length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                ansList.add(nums[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                ansList.add(nums[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                ansList.add(nums[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                ansList.add(nums[i][left]);
            }
            left++;
        }
        return ansList;
    }
}
