package theory.binarytrees;

import java.util.LinkedList;

public class BinaryTreeEdgeOne {

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

        BinaryTreeEdgeOne binaryTreeEdgeOne = new BinaryTreeEdgeOne();
        binaryTreeEdgeOne.createBinaryTree(arr);
        Node head = linkedList.get(0);
        BinaryTreeEdgeOne(head);

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
     * 标准1打印二叉树边界节点
     * @param head
     */
    public static void  BinaryTreeEdgeOne(Node head) {
        if (head == null){
            return;
        }

        int height = getHeight(head, 0);
        //1.edgeMap装填左右边界节点
        Node[][] edgeMap = new Node[height][2];

        setEdgeMap(head, 0, edgeMap);
        //2.打印左边界
        for (int i = 0; i != edgeMap.length; i++){
            System.out.println(edgeMap[i][0].value + "");
        }

        //3.打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);

        //4.打印右边界
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]){
                System.out.println(edgeMap[i][1].value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 打印树的高度
     * @param h
     * @param l
     * @return
     */
    public static int getHeight(Node h, int l){
        if (h == null){
            return l;
        }

        return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
    }

    /**
     * 填充边界节点map
     * @param h
     * @param l
     * @param edgeMap
     */
    public static void setEdgeMap(Node h, int l, Node[][] edgeMap) {
        if (h == null){
            return;
        }

        //3. 首先做的是初始化
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;

        //4. 然后调用自身
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }

    /**
     * 打印叶子节点
     * @param h
     * @param l
     * @param m
     */
    public static void printLeafNotInMap(Node h, int l, Node[][] m){
        if (h == null){
            return;
        }

        //5. 如果该节点的左右子节点都为空切不是左右l层的左右节点
        if (h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
            System.out.println(h.value + "");
        }

        //6. 可能叶子节点不在同一层，所以还要继续向下层遍历并打印叶子节点
        printLeafNotInMap(h.left, l + 1, m);
        printLeafNotInMap(h.right, l + 1, m);
    }
}
