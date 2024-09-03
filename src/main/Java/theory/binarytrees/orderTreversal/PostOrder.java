package theory.binarytrees.orderTreversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    
    public static void main(String[] args) {

    }

    private static List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            result.add(0, node.val);
        }
        return result;
    }

    static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
