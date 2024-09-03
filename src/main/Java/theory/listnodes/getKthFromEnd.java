package theory.listnodes;

public class getKthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 双指针
        ListNode slow = head, fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
