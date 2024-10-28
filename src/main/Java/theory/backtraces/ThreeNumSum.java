package theory.backtraces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ansList = threeNumSum(nums);
        for (int i = 0; i < ansList.size(); i++) {
            for (int j = 0; j < ansList.get(i).size(); j++) {
                System.out.print(ansList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> threeNumSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sub = nums[left] + nums[right];
                    if (sub == target) {
                        ansList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sub < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sub > target) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }

        }
        return ansList;
    }
}
