package LeetCodeProblem.LinkedList;

public class ReverseLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public DoubleNode pre;
        public int value;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseLinkedDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);

        Node pre = reverseLinkedList(head);
        while (pre != null){
            System.out.println(pre.value + " ");
            pre = pre.next;
        }

        System.out.println("这是分割线");

        DoubleNode cur = new DoubleNode(3);
        cur.next = new DoubleNode(5);
        cur.next.next = new DoubleNode(4);
        cur.next.next.next = new DoubleNode(1);
        cur.next.next.next.next = new DoubleNode(6);
        cur.next.next.next.next.next = new DoubleNode(2);

        DoubleNode last = reverseLinkedDoubleList(cur);
        while (last != null){
            System.out.println(last.value + " ");
            last = last.next;
        }
    }
}
