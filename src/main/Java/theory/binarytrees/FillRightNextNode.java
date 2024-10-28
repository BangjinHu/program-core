package theory.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class FillRightNextNode {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> tmp = queue;
            queue = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                Node node = tmp.get(i);
                if (i > 0) {
                    tmp.get(i - 1).next = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
