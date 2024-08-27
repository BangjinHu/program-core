package theory.lists;

public class LastKthNodeDlt {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node lastKthNodeDlt(Node head, int Kth){
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
        }

        if (Kth < 0){
            cur = head;
            while (++Kth != 0){
                cur = cur.next;
            }
            //这里找到了倒数第k个结点，cur是倒数第k个结点的前一个结点
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,2,8,4};
        int Kth = 3;//删除arr中的2
        Node head = arrToNodeList(arr);

        lastKthNodeDlt(head, Kth);

        while (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
    }

    //将数组转化为链表
    public static Node arrToNodeList(int[] arr){
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            //指针指向
            cur.next = temp;
            //重新定义cur
            cur = temp;
        }
        return head;
    }
}
