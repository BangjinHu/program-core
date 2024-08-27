package theory.arrays;

import java.util.ArrayList;
import java.util.List;

public class permute {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            for (int j = 0; j < permute.get(i).size(); j++) {
                System.out.print(permute.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }


    }

    // 数组全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        // 1、回溯
        backTrace(nums, ansList, numsList);
        return ansList;

        // 2、暴力
//        int length = nums.length;
//        List<List<Integer>> ansList = new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            List<Integer> numsList = new ArrayList<>();
//            for (int j = 0; j < length && j != i; j++) {
//                numsList.add(nums[i]);
//                numsList.add(nums[j]);
//            }
//            ansList.add(new ArrayList<>(numsList));
//        }
//        return ansList;
    }

    private static void backTrace(int[] nums, List<List<Integer>> ansList, List<Integer> numsList) {

        if (numsList.size() == nums.length) {
            ansList.add(new ArrayList<>(numsList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!numsList.contains(nums[i])) {
                numsList.add(nums[i]);
                backTrace(nums, ansList, numsList);
                numsList.remove(numsList.size() - 1);
            }
        }
    }

}
