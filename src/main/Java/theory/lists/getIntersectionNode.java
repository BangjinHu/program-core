package theory.lists;

public class getIntersectionNode {

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        // A+B=B+A 如果有交点则会提前相遇，否则在最后相遇都为null
        ListNode pA = head1;
        ListNode pB = head2;
        while (pA != pB) {
            pA = pA == null ? head2 : pA.next;
            pB = pB == null ? head1 : pB.next;
        }
        return pA;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
