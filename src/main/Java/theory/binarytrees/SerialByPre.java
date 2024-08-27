package theory.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerialByPre {

    private static LinkedList<Node> linkedList;
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        create(arr);
        Node head = linkedList.get(0);

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public String serialByPre(Node head){
        if (head == null){
            return "#!";
        }

        String result = head.value + "!";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    public Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i != values.length; i++){
            queue.offer(values[i]);
        }
        return reconByPreOrder(queue);
    }

    public Node reconByPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = reconByPreOrder(queue);
        head.right = reconByPreOrder(queue);
        return head;
    }

    public static void create(int[] arr){
        linkedList = new LinkedList<>();
//        String[] str = arr.split("!");
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

    //将子树序列化
    public String serialByLevel(Node head){
        //直接返回空树，#空串 !结束
        if (head == null){
            return "#!";
        }

        String result = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            //将左子树添加到queue中
            if (head.left != null){
                result += head.left.value + "!";
                queue.offer(head.left);
            }else {
                result += "#!";
            }

            //将右子树添加到queue中
            if (head.right != null){
                result += head.right.value + "!";
                queue.offer(head.right);
            }else {
                result += "#!";
            }
        }
        //返回最后的连接结果
        return result;
    }

    public Node reconByLevelString(String levelStr){
        //先将序列化的子串以!分割成单个字符，每个节点的字符
        String[] values = levelStr.split("!");
        int index = 0;

        //头节点
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null){
            queue.offer(head);
        }

        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            //然后产生头节点的左右子节点
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    public Node generateNodeByString(String val){
        if (val.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
