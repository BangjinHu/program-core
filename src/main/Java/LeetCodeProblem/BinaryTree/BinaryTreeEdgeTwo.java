package LeetCodeProblem.BinaryTree;

import java.util.LinkedList;

public class BinaryTreeEdgeTwo {

    private static LinkedList<Node> linkedList;
    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};

    //打印二叉树边界节点
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeEdgeTwo binaryTreeEdgeTwo = new BinaryTreeEdgeTwo();
        binaryTreeEdgeTwo.createBinaryTree(arr);
        Node head = linkedList.get(0);
        BinaryTreeEdgeTwo(head);
    }

    /**
     * 创建二叉树方法函数
     * @param arr
     */
    public void createBinaryTree(int[] arr) {
        linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++){
            linkedList.add(new Node(i));
        }

        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++){
            //leftChild
            linkedList.get(parentIndex).left = linkedList.get(parentIndex * 2 + 1);

            //rightChild
            linkedList.get(parentIndex).right = linkedList.get(parentIndex * 2 + 2);
        }

        int lastParentIndex = arr.length / 2 - 1;

        linkedList.get(lastParentIndex).left = linkedList.get(lastParentIndex * 2 + 1);

        if (arr.length % 2 == 1){
            linkedList.get(lastParentIndex).right = linkedList.get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 标准2 打印二叉树边界节点
     * @param head
     */
    public static void BinaryTreeEdgeTwo(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.value + " ");
        if (head.left != null && head.right != null){
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        }else {
            // 1.递归调用该方法打印左子树和右子树边界节点
            BinaryTreeEdgeTwo(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    /**
     * 打印左边界节点
     * @param h
     * @param print
     */
    public static void printLeftEdge(Node h, boolean print){
        if (h == null){
            return;
        }

        if (print || (h.left == null && h.right == null)) {
            if (h == null){
                return;
            }

            if (print || (h.left == null && h.right == null)) {
                System.out.println(h.value + " ");
            }
            printLeftEdge(h.left, print);
            printLeftEdge(h.right, print && h.left == null ? true : false);
        }
    }

    /**
     * 打印右边界节点
     * @param h
     * @param print
     */
    public static void printRightEdge(Node h, boolean print){
        if (h == null){
            return;
        }

        printRightEdge(h.left, print && h.right == null ? true : false);
        printRightEdge(h.right, print);

        if (print || (h.left == null && h.right == null)){
            System.out.println(h.value + " ");
        }
    }
}
