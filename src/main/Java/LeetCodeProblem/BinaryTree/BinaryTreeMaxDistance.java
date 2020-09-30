package LeetCodeProblem.BinaryTree;

import java.util.LinkedList;

public class BinaryTreeMaxDistance {
    private static LinkedList<Node> linkedList;
    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static class ReturnType {
        public int maxDistance;
        public int height;

        public ReturnType(int maxDistance, int height){
            this.height = height;
            this.maxDistance = maxDistance;
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

    public ReturnType process(Node head){
        if (head == null){
            return new ReturnType(0, 0);
        }

        ReturnType leftData = process(head.left);

        ReturnType rightData = process(head.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(leftData.height + rightData.height + 1, Math.max(leftData.maxDistance, rightData.maxDistance));

        return new ReturnType(maxDistance, height);
    }

    //dp套路问题：前提：最终答案在所有求得的答案之中。
    // 1.考虑所有的可能性。2.列出所有需要信息。3.信息汇总。4.设计递归函数。

    public int BinaryMaxDistace(Node head){
        return process(head).maxDistance;
    }

    public static void main(String[] args) {
        BinaryTreeMaxDistance binaryTreeMaxDistance = new BinaryTreeMaxDistance();
        binaryTreeMaxDistance.createBinaryTree(arr);

        Node head = linkedList.get(0);
        System.out.println(binaryTreeMaxDistance.BinaryMaxDistace(head));

    }
}
