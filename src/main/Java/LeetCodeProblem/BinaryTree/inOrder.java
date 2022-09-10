package LeetCodeProblem.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrder {

    public static void main(String[] args) {

    }

    public List<Integer> inOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        // 非递归
        List<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur.left != null) {
                cur = cur.left;
                stack.push(cur.left);
            } else {
                cur = stack.pop();
                ansList.add(cur.val);
                cur = cur.right;
            }
        }
        return ansList;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
