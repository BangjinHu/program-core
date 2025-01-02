package actual.HuaWei;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    // 给定一颗二叉树，树的路径指的是从根节点到叶子节点的一条通路，路径和指的是路径上的节点的value加和，求路径和=N的路径条数，并打印所有路径
    public static void main(String[] args) {
        int target = 1;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ansList = targetPathList(root, target);
        System.out.println("path's sum equals target num: " + ansList.size());
        for (List<Integer> list : ansList) {
            list.stream().forEach(node -> {
                System.out.print(node + " ");
            });
            System.out.println();
        }
    }

    private static List<List<Integer>> targetPathList(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, target, queue, ansList);
        return ansList;
    }

    private static void dfs(TreeNode root, int target, Deque<Integer> queue, List<List<Integer>> ansList) {
        if (root == null) {
            return;
        }
        target -= root.val;
        queue.addLast(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ansList.add(new ArrayList<>(queue));
            return;
        }
        if (root.left != null) {
            dfs(root.left, target, queue, ansList);
        }
        if (root.right != null) {
            dfs(root.right, target, queue, ansList);
        }
        queue.removeLast();
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
