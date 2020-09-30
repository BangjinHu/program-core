package LeetCodeProblem.IEEE;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Demo6 {

    public static void main(String[] args) {
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(2);
        node1.add(new DefaultMutableTreeNode(2));
        DefaultMutableTreeNode node7 = new DefaultMutableTreeNode(3);
        node7.add(new DefaultMutableTreeNode(6));
        node1.add(node7);
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(4);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(1);
        top.add(node1);
        top.add(node2);
        binaryTreePathSum(top,5);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static void binaryTreePathSum(TreeNode root, int target) {
        if (root.getChildCount()!=0) {
            Enumeration nodes = root.children();
            while (nodes.hasMoreElements()) {
                binaryTreePathSum((TreeNode)nodes.nextElement(),5);
            }
        } else {
            addList(root,new ArrayList<Integer>(), 5);
        }
    }

    public static void addList(TreeNode root, List<Integer> temp, int target) {
        List<Integer> list = temp;
        list.add(Integer.parseInt(root.toString()));
        if (root.getParent()!=null) {
            addList(root.getParent(), list, 5);
        } else {
            Collections.sort(list);
            int count = 0;
            for (Integer integer : list) {
                count+=integer;
            }
            if (count==target) {
                result.add(list);
            }
        }
    }
}
