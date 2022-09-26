package LeetCodeProblem.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class pathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int sum = 22;
        List<List<Integer>> ansList = pathSum(root, sum);
        for (int i = 0; i < ansList.size(); i++) {
            for (int j = 0; j < ansList.get(i).size(); j++) {
                System.out.print(ansList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        backTrace(root, sum, numsList, ansList);
        return ansList;
    }

    private static void backTrace(TreeNode root, int sum, List<Integer> numsList, List<List<Integer>> ansList) {

        if (root == null) {
            return;
        }
        numsList.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            ansList.add(new ArrayList<>(numsList));
        } else {
            backTrace(root.left, sum, numsList, ansList);
            backTrace(root.right, sum, numsList, ansList);
        }
        numsList.remove(numsList.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
