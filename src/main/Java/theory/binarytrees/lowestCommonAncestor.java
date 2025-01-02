package theory.binarytrees;

import java.util.*;

public class lowestCommonAncestor {

    public static void main(String[] args) {
        CommonAncestor.TreeNode root = new CommonAncestor.TreeNode(3);
        root.left = new CommonAncestor.TreeNode(5);
        root.left.left = new CommonAncestor.TreeNode(6);
        root.left.right = new CommonAncestor.TreeNode(2);
        root.left.right.left = new CommonAncestor.TreeNode(7);
        root.left.right.right = new CommonAncestor.TreeNode(4);
        root.right = new CommonAncestor.TreeNode(1);
        root.right.left = new CommonAncestor.TreeNode(0);
        root.right.right = new CommonAncestor.TreeNode(8);


        CommonAncestor.TreeNode p = new CommonAncestor.TreeNode(5);
        CommonAncestor.TreeNode q = new CommonAncestor.TreeNode(1);

        CommonAncestor.TreeNode node = lowestCommonAncestor(root, p, q);
        System.out.println("tree node q and p common parent node is: " + node.val);
    }

    public static CommonAncestor.TreeNode lowestCommonAncestor(CommonAncestor.TreeNode root, CommonAncestor.TreeNode p, CommonAncestor.TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        Map<CommonAncestor.TreeNode, CommonAncestor.TreeNode> parentMap = new HashMap<>();
        Queue<CommonAncestor.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        // 两节点都找到为止
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            CommonAncestor.TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<CommonAncestor.TreeNode> ans = new HashSet<>();
        while (p != null) {
            ans.add(p);
            p = parentMap.get(p);
        }
        while (!ans.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
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
