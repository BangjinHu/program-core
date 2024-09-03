package theory.listnodes;

public class deleteDuplicates {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 单指针
//        ListNode cur = head;
//        while (cur != null && cur.next != null) {
//            if (cur.val == cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return head;

        // 双指针
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
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
