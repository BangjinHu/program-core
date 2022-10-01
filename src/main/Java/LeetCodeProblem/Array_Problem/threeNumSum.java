package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeNumSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeNumSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1, high = nums.length - 1, sum = target - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        ansList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        while (low < high && nums[low] == nums[low+1]) {
                            low++;
                        }
                        low++;
                    } else {
                        while (low < high && nums[high] == nums[high-1]) {
                            high--;
                        }
                        high--;
                    }
                }
            }
        }
        return ansList;
    }


}
