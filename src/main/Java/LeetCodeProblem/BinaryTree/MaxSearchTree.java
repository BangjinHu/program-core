package LeetCodeProblem.BinaryTree;

import java.util.LinkedList;

public class MaxSearchTree {

    private static LinkedList<Node> linkedList;

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,4,5,6,7,9,8};
        create(arr);
        Node head = linkedList.get(0);
        Node returnNode = proccess(head).maxBSTHead;
        System.out.println(returnNode.value);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //树形dp
    //1.考虑所有可能性
    //2.根据所有可能性的分析，列出所有需要信息
    //3.合并2的信息，写出信息结构
    public static class ReturnType {
        public Node maxBSTHead;
        //最大搜索树长度
        public int maxBSTSize;
        //右子树的最小值
        public int min;
        //左子树的最大值
        public int max;

        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    //4.设计递归函数
    public static ReturnType proccess(Node X) {
        if (X == null){
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        //默认直接得到左树全部信息
        ReturnType lData = proccess(X.left);
        //默认直接得到右树全部信息
        ReturnType rData = proccess(X.right);

        //信息整合
        int min = Math.min(X.value, Math.min(lData.min, rData.min));
        int max = Math.max(X.value, Math.max(lData.max, rData.max));

        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;

        //第三种情况，以X为头节点
        if (lData.maxBSTHead == X.left && rData.maxBSTHead == X.right && X.value > lData.max && X.value < rData.min){
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = X;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    public static void create(int[] arr){
        linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++){
            linkedList.add(new Node(arr[i]));
        }

        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++){
            linkedList.get(parentIndex).left = linkedList.get(parentIndex * 2 + 1);
            linkedList.get(parentIndex).right = linkedList.get(parentIndex * 2 + 2);
        }

        int lastParentIndex = arr.length / 2 - 1;
        linkedList.get(lastParentIndex).left = linkedList.get(lastParentIndex * 2 + 1);
        if (arr.length % 2 == 1){
            linkedList.get(lastParentIndex).right = linkedList.get(lastParentIndex * 2 + 2);
        }
    }
}
