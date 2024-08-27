package theory.lists;

//有序循环链表中插入指定节点
public class InsertNum {
    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node insertNum(Node head, int num){
        Node node = new Node(num);
        if (head == null){
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        //循环链表
        while (cur != head){
            if (pre.value <= num && cur.value >= num){
                break;
            }
            //否则继续找能够插入有序循环链表的位置
            pre = cur;
            cur = cur.next;
        }
        //找到之后
        pre.next = node;
        node.next = cur;
        //返回整个循环链表中的最小值节点作为头节点
        return head.value < num ? head : node;
    }

    //将数组转换成链表
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

        int[] arr = new int[]{1,2,4,5,6,7,8,9};
        Node head = add(arr);
        int num = 3;
        Node cur = insertNum(head, num);
        while (cur != null){
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
    }
}
