package theory.lists;

public class Relocate {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node relocate(Node head){
        if (head == null || head.next == null){
            return null;
        }

        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
        return head;
    }

    public static void mergeLR(Node left, Node right){
        Node next = null;
        while (left.next != null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }

    public static Node add(int[] arr){
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        Node head = add(arr);
        Node cur = relocate(head);
        while (cur != null){
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
    }
}
