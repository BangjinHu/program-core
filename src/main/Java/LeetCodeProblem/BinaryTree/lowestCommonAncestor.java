package LeetCodeProblem.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class lowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        // 两节点都找到为止
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> ans = new HashSet<>();
        while (p != null) {
            ans.add(p);
            p = parentMap.get(p);
        }
        while (!ans.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
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
