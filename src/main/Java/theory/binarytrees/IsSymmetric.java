package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BuildBinarayTree.printBinaryTree(root);
        System.out.println("=================");
        boolean symmetric = isSymmetric(root);
        System.out.println("current binary tree is mirror? -> " + symmetric);
        
    }

    //是否对称
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return true;
    }
}
