package theory.listnodes;

import java.util.Stack;

public class LinkedListAddOperation {
    public static void main(String[] args) {


    }

    public Node addListsOne(Node headOne, Node headTwo) {
        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        //1.将链表1的值压入栈1
        while (headOne != null) {
            stackOne.push(headOne.value);
            headOne = headOne.next;
        }

        while (headTwo != null) {
            stackTwo.push(headTwo.value);
            headTwo = headTwo.next;
        }

        //2.进位
        int ca = 0;

        //3.栈弹出值，由低位到高位
        int nOne = 0;
        int nTwo = 0;

        //4.和
        int n = 0;

        Node node = null;
        Node pre = null;

        while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
            nOne = stackOne.isEmpty() ? 0 : stackOne.pop();
            nTwo = stackTwo.isEmpty() ? 0 : stackTwo.pop();

            n = nOne + nTwo + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }

        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }

        return node;
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
