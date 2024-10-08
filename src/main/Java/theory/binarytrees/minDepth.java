package theory.binarytrees;

public class minDepth {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
