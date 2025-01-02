package actual.Tencent;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindNumsTarget {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, 6};
        int target = 7;
        List<List<Integer>> ansList = findNumsTarget(nums, target);
        for (List<Integer> list : ansList) {
            list.stream().forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static List<List<Integer>> findNumsTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        dfs(nums, 0, target, deque, ansList);
        return ansList;
    }

    private static void dfs(int[] nums, int index, int target, Deque<Integer> deque, List<List<Integer>> ansList) {
        if (target == 0) {
            ansList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!deque.contains(nums[i])) {
                deque.addLast(nums[i]);
                dfs(nums, index + 1, target - nums[i], deque, ansList);
                deque.removeLast();
            }
        }
    }
}
