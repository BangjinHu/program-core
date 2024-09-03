package theory.binarytrees.orderTreversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> ansList = inOrder(root);
        ansList.forEach(System.out::println);

    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ansList.add(cur.val);
                cur = cur.right;
            }
        }
        return ansList;
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
