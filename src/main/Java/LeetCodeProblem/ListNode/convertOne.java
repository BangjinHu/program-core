package LeetCodeProblem.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class convertOne {

    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //二叉树转换为双向链表
    public Node convertOne(Node head){
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()){
            return head;
        }

        head = queue.poll();
        Node pre = head;
        pre.pre = null;
        Node cur = null;
        //队列右移
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
        }

        pre.next = null;
        return head;
    }

    public void inOrderToQueue(Node head, Queue<Node> queue){
        if (head == null){
            return;
        }

        inOrderToQueue(head.pre, queue);
        queue.offer(head);
        inOrderToQueue(head.next, queue);
    }

    public static void main(String[] args) {

    }

}
