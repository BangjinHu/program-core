package actual.vmware;

public class ReverseListNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = reverseListNode(head);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
