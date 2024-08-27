package theory.lists;

public class RemoveMidAndRatioNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }

        if (head.next.next == null){
            return head.next;
        }

        //快慢指针
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        //pre到中间结点的前一个节点，然后删除中间节点
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b){
        if (a < 1 || a > b){//a/b
            return head;
        }

        int n = 0;
        Node cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }

        n = (int) (Math.ceil((double)(a * n)) / (double) b);
        if (n == 1){
            head = head.next;
        }

        if (n > 1){
            cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,4,9,8,1};
        Node head = arrToLinkedList(arr);
        int a = 3;
        int b = 5;
        removeMidNode(head);
//        removeByRatio(head, a, b);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }

    }

    public static Node arrToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

}
