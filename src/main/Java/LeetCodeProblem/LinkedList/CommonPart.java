package LeetCodeProblem.LinkedList;

public class CommonPart {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void commonPart(Node headOne, Node headTwo){
        while (headOne != null && headTwo != null){
            if (headOne.value < headTwo.value){
                headOne = headOne.next;
            }else if (headTwo.value < headOne.value){
                headTwo = headTwo.next;
            }else {
                System.out.println(headOne.value + " ");
                headOne = headOne.next;
                headTwo = headTwo.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node headOne = new Node(3);
        headOne.next = new Node(5);
        headOne.next.next = new Node(4);
        headOne.next.next.next = new Node(6);
        headOne.next.next.next.next = new Node(1);

        Node headTwo = new Node(2);
        headTwo.next = new Node(3);
        headTwo.next.next = new Node(4);
        headTwo.next.next.next = new Node(5);
        headTwo.next.next.next.next = new Node(6);

        commonPart(headOne, headTwo);

        int[] arr = new int[]{3,5,3,6,2};
        Node head = arrToLinkedList(arr);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }

        int[] arrOne = linkedListToArr(headOne);
        for (int i = 0; i < arrOne.length; i++){
            System.out.println(arrOne[i]);
        }

    }

    //将数组转换为链表
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

    //将链表转换成数组
    public static int[] linkedListToArr(Node head){
        int size = linkedListSize(head);
        int[] arr = new int[size];
        int index = 0;
        while (head != null){
            arr[index] = head.value;
            head = head.next;
            index++;
        }
        return arr;
    }

    public static int linkedListSize(Node head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}
