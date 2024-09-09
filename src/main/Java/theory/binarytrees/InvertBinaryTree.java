package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.Stack;

public class InvertBinaryTree {

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BuildBinarayTree.printBinaryTree(root);

        invertBinaryTree(root);

        System.out.println("================invert tree node==================");

        BuildBinarayTree.printBinaryTree(root);
    }

    private static TreeNode invertBinaryTree(TreeNode root) {

        //中序遍历
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                TreeNode left = root.left;
                root.left = root.right;
                root.right = left;

                root = root.left;
            }

        }
        return root;
    }

//    static class TreeNode {
//        private final int val;
//        private TreeNode left;
//        private TreeNode right;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }

}
