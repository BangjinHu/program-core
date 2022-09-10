package LeetCodeProblem.ListNode;

public class reOrderList {

    public static void main(String[] args) {

    }

    public void reOrderList(ListNode head) {

        // 1、快慢指针找出中点
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        node = reverse(node);
        ListNode cur = head;
        while (cur != null && node != null) {
            ListNode cur2 = node;
            node = node.next;
            ListNode next = cur.next;
            cur.next = cur2;
            cur2.next = next;
            cur = next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = cur;
        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
