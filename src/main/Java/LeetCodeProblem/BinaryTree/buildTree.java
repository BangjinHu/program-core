package LeetCodeProblem.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class buildTree {

    public static void main(String[] args) {
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
        TreeNode root = buildTree(inOrder, postOrder);
        while (root != null) {
            System.out.print(root.val + " ");
        }
    }

    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {

        if (postOrder == null || postOrder.length == 0) {
            return new TreeNode(-1);
        }
        TreeNode root = new TreeNode(postOrder[postOrder.length - 1]);// 后续遍历数组最后一个元素是根元素
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inIdx = inOrder.length - 1;
        for (int i = postOrder.length - 2; i >= 0; i--) {
            int pV = postOrder[i];
            TreeNode node = stack.peek();
            if (node.val != inOrder[inIdx]) {
                node.right = new TreeNode(pV);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inOrder[inIdx]) {
                    node = stack.pop();
                    inIdx--;
                }
                node.left = new TreeNode(pV);
                stack.push(node.left);
            }
        }
        return root;
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
