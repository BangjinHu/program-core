package LeetCodeProblem.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class binarySearchKthNum {

    public static void main(String[] args) {

    }

    public int binarySearchKthNum(TreeNode root, int k) {
        // 中序遍历
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return 0;
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
