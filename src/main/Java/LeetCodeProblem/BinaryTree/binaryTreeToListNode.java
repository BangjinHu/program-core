package LeetCodeProblem.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class binaryTreeToListNode {

    public static void main(String[] args) {

    }

    /**
     * 二叉树转链表
     * @param root
     */
    public void binaryTreeToListNode(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode sNode = node.right;
                node.right = node.left;
                node.left = null;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = sNode;
                root = sNode;
            }
        }

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
