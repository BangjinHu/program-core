package theory.binarytrees;

public class IsSymmetrics {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        System.out.println(isSymmetrics(root.left, root.right));

    }

    private static boolean isSymmetrics(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetrics(left.left, right.right) && isSymmetrics(left.right, right.left);
        }
    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
