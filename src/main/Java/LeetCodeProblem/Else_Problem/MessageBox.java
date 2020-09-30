package LeetCodeProblem.Else_Problem;

import java.util.HashMap;

public class MessageBox {

    public class Node {
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private HashMap<Integer, Node> headMap;
    private HashMap<Integer, Node> tailMap;
    private int lastPrint;

    public MessageBox() {
        headMap = new HashMap<>();
        tailMap = new HashMap<>();
        lastPrint = 0;
    }

    public void receive(int num){
        if (num < 1){
            return;
        }

        Node cur = new Node(num);
        headMap.put(num, cur);
        tailMap.put(num, cur);
        if (tailMap.containsKey(num-1)){
            //将两个节点连接起来，删除
            tailMap.get(num-1).next = cur;
            tailMap.remove(num-1);
            headMap.remove(num);
        }
        if (headMap.containsKey(num+1)){
            //将两节点连接起来，删除
            cur.next = headMap.get(num+1);
            tailMap.remove(num);
            headMap.remove(num+1);
        }

        if (headMap.containsKey(lastPrint+1)){
            print();
        }
    }

    private void print(){
        //最后打印节点的下一个结点
        Node node = headMap.get(++lastPrint);
        headMap.remove(lastPrint);
        while (node != null){
            System.out.println(node.value + " ");
            node = node.next;
            lastPrint++;
        }

        tailMap.remove(--lastPrint);
        System.out.println();
    }


}
