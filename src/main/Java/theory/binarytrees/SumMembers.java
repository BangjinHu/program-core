package theory.binarytrees;

public class SumMembers {

    private static int sum = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(10);
        root.right.right.right.right.right = new TreeNode(11);

        System.out.println(sumMembers(root));

    }

    private static int sumMembers(TreeNode root) {
        sumMembers(0, root);
        return sum;
    }

    private static void sumMembers(int subSum, TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        subSum = subSum * 10 + curNode.val;
        if (curNode.left == null && curNode.right == null) {
            sum += subSum;
        }
        sumMembers(subSum, curNode.left);
        sumMembers(subSum, curNode.right);
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
