package actual.Didi;

import java.util.*;

public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || parentMap.containsKey(q)) {
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

        Set<TreeNode> dupSet = new HashSet<>();
        while (p != null) {
            dupSet.add(p);
            p = parentMap.get(p);
        }
        while (!dupSet.contains(q)) {
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
