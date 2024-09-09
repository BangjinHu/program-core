package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthPqAncestor {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BuildBinarayTree.printBinaryTree(root);
        TreeNode p = new TreeNode(2), q = new TreeNode(6);
        TreeNode node = maxDepthPq(root, p, q);
        System.out.println("==============binary max depth ancestor===============");
        BuildBinarayTree.printBinaryTree(node);

    }

    //p q节点的最近公共祖先
    private static TreeNode maxDepthPq(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(root, null);
        while (!nodeMap.containsKey(p) || !nodeMap.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nodeMap.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                nodeMap.put(node.right, node);
            }
        }
        HashSet<TreeNode> dupSet = new HashSet<>();
        while (p != null) {
            dupSet.add(p);
            p = nodeMap.get(p);
        }
        while (!dupSet.contains(q)) {
            q = nodeMap.get(q);
        }
        return q;
    }
}
