package theory.lists;

public class sortListNode {

    public static void main(String[] args) {

    }

    public ListNode sortListNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 归并排序
//        return mergeSortListNode(head);

        // 快排
        return quickSortListNode(head);
    }

    public ListNode quickSortListNode(ListNode head) {
        return new ListNode(-1);
    }

    public ListNode mergeSortListNode(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = slow;
        }
        pre.next = null;
        ListNode left = mergeSortListNode(head);
        ListNode right = mergeSortListNode(slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {

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
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
