package actual.Tencent;

public class ReverseKGroup {

    public static void main(String[] args) {

    }

    // k个一组翻转链表
    private static ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表长度
        int len = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head, next;
        while (head != null) {
            head = head.next;
            len++;
        }
        head = dummyHead.next;
        for (int i = 0; i < len / k; i++) {
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
