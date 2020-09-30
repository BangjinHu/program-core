package LeetCodeProblem.LinkedList;

//反转部分单链表
public class ReversePartLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reversePart(Node head, int from, int to){
        int len = 0;
        Node nodeOne = head;
        //from前一个节点
        Node prePos = null;
        //to下一个节点
        Node nextPos = null;
        while (nodeOne != null){
            len++;
            prePos = len == from - 1 ? nodeOne : prePos;
            nextPos = len == to + 1 ? nodeOne : nextPos;
            nodeOne = nodeOne.next;
        }

        //情况不处理
        if (from > to || from < 1 || to > len){
            return head;
        }
        //判断部分反转处是否包括头节点
        nodeOne = prePos == null ? head : prePos.next;
        Node nodeTwo = nodeOne.next;
        nodeOne.next = prePos;
        Node next = null;
        while (nodeTwo != nextPos){
            next = nodeTwo.next;
            nodeTwo.next = nodeOne;
            nodeOne = nodeTwo;
            nodeTwo = next;
        }

        if (prePos != null){
            prePos.next = nodeOne;
            return head;
        }
        return nodeOne;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node cur = reversePart(head, 2, 3);
        while (cur != null){
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
    }
}
