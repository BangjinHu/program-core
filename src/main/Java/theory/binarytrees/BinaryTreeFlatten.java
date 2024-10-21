package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.Stack;

public class BinaryTreeFlatten {

    public static void main(String[] args) {
        TreeNode root = BuildBinarayTree.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        BuildBinarayTree.printBinaryTree(root);
        System.out.println("=========flatten============");
        flattenTree(root);
        BuildBinarayTree.printBinaryTree(root);
    }

    private static void flattenTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;
                // 加入左树上所有节点
                while (node.right != null) {
                    node = node.right;
                }
                node.right = tmp;
                root = tmp;
            }
        }
    }
}
