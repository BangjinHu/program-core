package LeetCodeProblem.BinaryTree;

public class BinaryTreeStatNodeNum {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public int BinaryTreeNodeNum(Node head) {
        if (head == null){
            return 0;
        }
        return TreeNumStat(head, 1, mostLeftLevel(head, 1));
    }

    public int TreeNumStat(Node node, int l, int h){
        if (l == h){
            return 1;
        }

        if (mostLeftLevel(node.left, l+1) == h){
            return (l << (h+1) + TreeNumStat(node.right, l+1, h));
        }else {
            return (l << (h-1-l)) + TreeNumStat(node.left, l + 1, h);
        }
    }

    public int mostLeftLevel(Node node, int level) {
        while (node != null){
            level++;
            node = node.left;
        }
        return level-1;
    }

}
