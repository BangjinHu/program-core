package theory.lists;

public class deleteDuplicates2 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead.next;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
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
