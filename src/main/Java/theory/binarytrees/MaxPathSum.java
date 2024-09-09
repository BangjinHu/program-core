package theory.binarytrees;

import theory.binarytrees.util.TreeNode;

public class MaxPathSum {

    private static int maxPathSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int maxPathSum1 = getMaxPathSum(root);
        System.out.println(maxPathSum1);
    }

    private static int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxPathSum;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    private int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }
}
