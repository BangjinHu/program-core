package theory.dps;

import java.util.ArrayList;
import java.util.List;

public class PrintNums {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> resList = printNums(nums);
        for (int i = 0; i < resList.size(); i++) {
            for (int j = 0; j < resList.get(i).size(); j++) {
                System.out.print(resList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> printNums(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> queue = new ArrayList<>();
        backTrace(nums, queue, res);
        return res;
    }

    private static void backTrace(int[] nums, List<Integer> queue, List<List<Integer>> res) {
        if (queue.size() == nums.length) {
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!queue.contains(nums[i])) {
                queue.add(nums[i]);
                backTrace(nums, queue, res);
                queue.remove(queue.size() - 1);
            }
        }
    }
}
