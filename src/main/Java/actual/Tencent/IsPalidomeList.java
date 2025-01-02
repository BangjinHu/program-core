package actual.Tencent;

public class IsPalidomeList {

    public static void main(String[] args) {


    }

    // 回文链表
    private static boolean isPalidomeList(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
