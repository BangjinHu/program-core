package theory.binarytrees;

public class BstTopoSize {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

//    public int bstTopoSize(Node head){
//        if (head == null){
//            return 0;
//        }
//
//        int max = maxTopo(head, head);
//        max = Math.max(bstTopoSize(head.left), max);
//        max = Math.max(bstTopoSize(head.right), max);
//        return max;
//    }

//    public int maxTopo(Node h, Node n){
//        if (h != null && n != null && isBSTNode(h, n, n.value)){
//            //表示左子树和右子树的值+头节点的长度
//            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
//        }
//        return 0;
//    }

}
