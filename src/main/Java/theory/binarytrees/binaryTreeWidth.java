package theory.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeWidth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(binarySearchTreeMaxWidth(root));

    }

    public static int binarySearchTreeMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> numsList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                numsList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ansList.add(numsList);
        }
        int ans = 0, idx = 0;
        while (!ansList.isEmpty() && idx < ansList.size()) {
            ans = Math.max(ans, ansList.get(idx++).size());
        }
        return ans;
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
