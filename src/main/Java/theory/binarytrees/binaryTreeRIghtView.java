package theory.binarytrees;

import java.util.*;

public class binaryTreeRIghtView {

    public static void main(String[] args) {

    }

    // 二叉树右视图
    public List<Integer> binaryTreeRightView(TreeNode root) {

        // 层序遍历的方式
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ansList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size != 0) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (size == 0) {
                    ansList.add(node.val);
                }
                size--;
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
