package LeetCodeProblem.ListNode;

public class addTwoListNode {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(6);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(2);

        ListNode node = addTwoListNode(head1, head2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode addTwoListNode(ListNode head1, ListNode head2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int m = head1 == null ? 0 : head1.val;
            int n = head2 == null ? 0 : head2.val;
            int sum = m + n + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
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
