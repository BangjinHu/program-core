package theory.binarytrees;

import java.util.LinkedList;

public class StragihtPrintBinaryTree {
    //如何较直观的打印树
    private static LinkedList<Node> linkedList;
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void main(String[] args) {

//        Node root = new Node(0);
//        Node pNode = root;
//        pNode.left = new Node(8);
//        pNode.right = new Node(3);
//
//        pNode = pNode.left;
//        pNode.left = new Node(8);
//        pNode.right = new Node(5);
//
//        pNode = root.right;
//        pNode.left = new Node(9);
//        pNode.left = new Node(9);


        int[] arr = new int[10];
        StragihtPrintBinaryTree binaryTree = new StragihtPrintBinaryTree();
        binaryTree.createBinaryTree(arr);

        Node head = linkedList.get(0);

        printTree(head);

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
     * 打印二叉树方法函数
     * @param head
     */
    public static void printTree(Node head){
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    /**
     * 根据先右子树，再根节点，最后左子树的递归顺序遍历整颗树
     * @param head
     * @param height
     * @param to
     * @param len
     */
    public static void printInOrder(Node head, int height, String to, int len){
        if (head == null){
            return;
        }

        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    /**
     * 根据该树是否左右子树补充左右空格
     * @param num
     * @return
     */
    public static String getSpace(int num){
        String space = " ";
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < num; i++){
            buffer.append(space);
        }
        return buffer.toString();
    }
}
