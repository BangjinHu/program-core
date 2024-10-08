package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = BuildBinarayTree.createTree(new Integer[]{2, 1, 3});
        BuildBinarayTree.prePrinTree(root);

        boolean isValid = isValidBST(root);
        System.out.println("current binary tree is valid? " + isValid);
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ansList.add(root.val);
                root = root.right;
            }
        }
        for (int i = 1; i < ansList.size(); i++) {
            if (ansList.get(i) <= ansList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
