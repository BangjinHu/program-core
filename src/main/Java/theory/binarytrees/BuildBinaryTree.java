package theory.binarytrees;

import theory.binarytrees.util.BuildBinarayTree;
import theory.binarytrees.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTree {

    private static final Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildBinaryTree(preorder, inorder);
        BuildBinarayTree.printBinaryTree(root);
    }

    private static TreeNode buildBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = indexMap.get(pre[preStart]);
        int leftSize = index - inStart;
        root.left = buildTree(pre, preStart + 1, preStart + leftSize, inStart);
        root.right = buildTree(pre, preStart + leftSize + 1, preEnd, inStart + leftSize + 1);
        return root;
    }
}
