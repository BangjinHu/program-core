package theory.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> ansList = new ArrayList<>();
        List<Integer> ans = inOrder(root, ansList);
        for (int i = 0; i < ansList.size(); i++) {
            System.out.println(ansList.get(i));
        }

        System.out.println(inOrderCp(root));
    }

    public boolean isBinaryTree(TreeNode root) {

        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ansList = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                ansList.add(stack.pop().val);

                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }
            }
        }
        for (int i = 1; i < ansList.size(); i++) {
            if (ansList.get(i) < ansList.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inOrder(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left != null) {
            inOrder(root.left, ansList);
        }

        ansList.add(root.val);
        if (root.right != null) {
            inOrder(root.right, ansList);
        }
        return ansList;
    }

    static int pre = -1;
    public static boolean inOrderCp(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean flag1v = true;
        boolean flag2v = true;
        if (root.left != null) {
            flag1v = inOrderCp(root.left);
        }
        if (pre > root.val) {
            return false;
        }
        pre = root.val;
        if (root.right != null) {
            flag2v = inOrderCp(root.right);
        }
        return flag2v && flag1v;
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
