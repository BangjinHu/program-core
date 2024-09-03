package theory.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumThreeNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ansList = sumThreeNumbers(nums);
        for (List<Integer> list : ansList) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static List<List<Integer>> sumThreeNumbers(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, sum = -nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (nums[left] == nums[left + 1] && left < right) {
                            left++;
                        }
                        while (nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        while (nums[left] == nums[left + 1] && left < right) {
                            left++;
                        }
                        left++;
                    } else if (nums[left] + nums[right] > sum) {
                        while (nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
