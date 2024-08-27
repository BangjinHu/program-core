package theory.lists;

public class LastKthDoubleNodeDlt {

    public static class Node {
        public int value;
        public Node next;
        public Node pre;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node lastKthDoubleNodeDlt(Node head, int Kth){
        if (head == null || Kth < 1){
            return head;
        }

        Node cur = head;
        while (cur != null){
            Kth--;
            cur = cur.next;
        }

        if (Kth == 0){
            head = head.next;
            head.pre = null;
        }

        if (Kth < 0){
            cur = head;
            while (++Kth != 0){
                cur = cur.next;
            }
            //找到第K个结点的位置
            Node newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null){
                newNext.pre = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,6,7,8,0};
        int Kth = 3;
        Node head = arrToLinkedList(arr);
        lastKthDoubleNodeDlt(head, Kth);
        while (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node arrToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node curNode = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            curNode.next = temp;
            curNode = temp;
        }
        return head;
    }
}
