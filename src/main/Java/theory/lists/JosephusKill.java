package theory.lists;

public class JosephusKill {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node josephusKillOne(Node head, int m){
        //为空的情况或者自环情况或者报数小于1情况
        if (head == null || head.next == head || m < 1){
            return head;
        }

        Node cur = head;
        //循环链表没有遍历结束
        while (cur.next != head){
            cur = cur.next;
        }

        //找出报数到m的人
        int count = 0;
        //还有环存在，两个元素以上
        while (head != cur){
            if (++count == m){
                cur.next = head.next;
            }else {
                cur = cur.next;
            }

            head = cur.next;
        }
        return head;
    }

    public static Node josephusKillTwo(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }

        Node cur = head.next;
        int temp = 1;
        //链表头节点与尾节点没有连接起来会报空指针异常错误
        while (cur != head){
            temp++;
            cur = cur.next;
            if (cur.next == null){
                cur.next = head;
            }
        }

        temp = getLive(temp, m);
        while (--temp != 0){
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public static int getLive(int i, int m){
        if (i == 1){
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static void main(String[] args) {
        Node cur = new Node(1);
        cur.next = new Node(2);
        cur.next.next = new Node(3);
        cur.next.next.next = new Node(4);
        cur.next.next.next.next = new Node(5);
//        while (cur != null){
//            System.out.println(cur.value + " ");
//            cur = cur.next;
//        }

//        Node last = josephusKillOne(cur, 3);
        //如果头节点与尾节点没有连起来会发生空指针异常
        Node last = josephusKillTwo(cur, 3);
        while (last != null){
            System.out.println(last.value + " ");
            last = last.next;
        }
    }
}
