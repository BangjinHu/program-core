package theory.binarytrees;

import java.util.*;

public class CommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode node = commonParentNode(root, p, q);
        System.out.println("tree node q and p common parent node is: " + node.val);
    }

    private static TreeNode commonParentNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        queue.add(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.left != null) {
                queue.add(node.left);
                parentMap.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                parentMap.put(node.right, node);
            }
        }
        Set<TreeNode> duplicate = new HashSet<>();
        while (p != null) {
            duplicate.add(p);
            p = parentMap.get(p);
        }
        while (!duplicate.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
