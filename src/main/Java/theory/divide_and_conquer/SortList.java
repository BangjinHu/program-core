package theory.divide_and_conquer;

public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(3);


        ListNode node = sortList(head);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断掉
        pre.next = null;
        // 分治
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummyHead.next;
    }

    static class ListNode {
        private final int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
