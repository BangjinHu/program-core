package theory.listnodes;

public class reverseKGroup {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head, next;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        head = dummyHead.next;
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
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
