package LeetCodeProblem.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null == root){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
            list.add(0, node.val);
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            this.val = v;
        }
    }
}
