package theory.divide_and_conquer;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        BuildBinarayTree.printBinaryTree(root);

        System.out.println("========other answer===========");
        // [0,-10,5,null,-3,null,9]
        TreeNode otherRoot = BuildBinarayTree.createTree(new Integer[]{0, -10, 5, null, -3, null, 9});
        BuildBinarayTree.printBinaryTree(otherRoot);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        // nums已经排序过了
        return nums.length == 0 ? null : buildBSTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBSTree(int[] nums, int left, int right) {
        //二分构建
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTree(nums, left, mid - 1);
        root.right = buildBSTree(nums, mid + 1, right);
        return root;
    }
}
