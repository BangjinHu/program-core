package LeetCodeProblem.BinaryTree;

import java.util.LinkedList;

public class BinaryTreeNextNode {
    private static LinkedList<Node> linkedList;
    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data){
            this.value = data;
        }
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

    public static Node BinaryTreeNextNode(Node node){
        if (node == null){
            return node;
        }

        //前提：一个node节点的后继节点是二叉树中序遍历的node节点的下一节点

        //1.如果node节点有右子树，那么node节点的后继节点就是右子树最左边的节点
        if (node.right != null){
            return  getLeftMost(node.right);
        }else {
            //2.node节点是右子树，一直向上遍历直到找到左子树，才确认此时的左孩子节点是node节点的后继节点
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    //3.拿到node节点右子树最左边节点
    public static Node getLeftMost(Node node){
        if (node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

        BinaryTreeNextNode binaryTreeNextNode = new BinaryTreeNextNode();
        binaryTreeNextNode.createBinaryTree(arr);
        Node head = linkedList.get(0);
//        System.out.println(Integer.valueOf(head.value));
        System.out.println(BinaryTreeNextNode(head).value);
    }
}
