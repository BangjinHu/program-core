package theory.arrays;

import java.util.ArrayList;
import java.util.List;

public class PermuteNums {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ansList = permute(nums);
        for (List<Integer> list : ansList) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        backTrace(resultList, midList, nums);
        return resultList;
    }

    private static void backTrace(List<List<Integer>> resultList, List<Integer> midList, int[] nums) {
        if (nums.length == midList.size()) {
            resultList.add(new ArrayList<>(midList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!midList.contains(nums[i])) {
                midList.add(nums[i]);
                backTrace(resultList, midList, nums);
                midList.remove(midList.size() - 1);
            }
        }
    }
}
