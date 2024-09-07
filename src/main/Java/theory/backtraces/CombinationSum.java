package theory.backtraces;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ansList = combinationSum(candidates, target);
        for (List<Integer> list : ansList) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backTrace(candidates, target, 0, stack, result);
        return result;
    }

    private static void backTrace(int[] candidates, int target, int index, Stack<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                stack.push(candidates[i]);
                backTrace(candidates, target - candidates[i], i, stack, result);
                stack.pop();
            }
        }
    }
}
