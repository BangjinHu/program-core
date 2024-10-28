package theory.binarytrees;

import theory.binarytrees.util.TreeNode;

import java.util.*;

public class DistanceK {

    private static final Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    private static final Set<TreeNode> isVisList = new HashSet<>();
    private static TreeNode node = null;

    public static void main(String[] args) {

    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findNodeParents(root, null, target);
        List<Integer> ansList = new ArrayList<>();
        dfs(node, k, ansList);
        return ansList;
    }

    private static void findNodeParents(TreeNode root, TreeNode parent, TreeNode target) {
        if (root == null) {
            return;
        }
        if (root.val == target.val) {
            node = root;
        }
        parentMap.put(root, parent);
        findNodeParents(root.left, root, target);
        findNodeParents(root.right, root, target);
    }

    private static void dfs(TreeNode root, int k, List<Integer> ansList) {
        if (root != null) {
            isVisList.add(root);
            if (k <= 0) {
                ansList.add(root.val);
            }
            dfs(root.left, k - 1, ansList);
            dfs(root.right, k - 1, ansList);
            dfs(parentMap.get(root), k - 1, ansList);
        }
    }

}
