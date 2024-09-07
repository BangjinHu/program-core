package theory.binarytrees;


import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

public class MinDifference {

    static int ans = Integer.MAX_VALUE;
    static TreeNode pre = null;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 2, 6, 1, 3};
        TreeNode root = BuildBinarayTree.createTree(arr);
        getMinDifference(root);
        System.out.println("binary tree min difference: " + ans);
    }

    private static void getMinDifference(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinDifference(root.left);
        if (pre != null) {
            ans = Math.min(Math.abs(root.val - pre.val), ans);
        }
        pre = root;
        getMinDifference(root.right);
    }

}
