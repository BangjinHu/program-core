package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeValid {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{2, 1, 3};
        Integer[] nums = new Integer[]{5, 1, 4, null, null, 3, 6};
        TreeNode root = BuildBinarayTree.createTree(nums);
        BuildBinarayTree.printBinaryTree(root);
        boolean isValid = isValidBST(root);
        System.out.println("current binary tree is valid? " + isValid);
    }

    private static boolean isValidBST(TreeNode root) {
        // inOrder
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
