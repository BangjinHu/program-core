package theory.listnodes;

public class ReOrderListNode {

    public static void main(String[] args) {

    }

    private ListNode reOrderNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        ListNode revNode = reverseNode(node);

        ListNode cur = head;
        while (cur != null && revNode != null) {
            ListNode postNode = revNode;
            revNode = revNode.next;
            ListNode preNext = cur.next;
            postNode.next = preNext.next;
            cur.next = preNext;
            cur = preNext;
        }
        return revNode;

    }

    private ListNode reverseNode(ListNode node) {
        ListNode prev = null, cur = node, next = cur;
        while (next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
