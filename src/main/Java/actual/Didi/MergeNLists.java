package actual.Didi;

public class MergeNLists {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{head1, head2, head3};
        ListNode node = mergeNLists(listNodes);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static ListNode mergeNLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    private static ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode head = null;
//        while (node1 != null && node2 != null) {
//            if (node1.val <= node2.val) {
//                head = node1;
//                head.next = mergeTwoLists(node1.next, node2);
//            } else {
//                head = node2;
//                head.next = mergeTwoLists(node1, node2.next);
//            }
//        }
//        if (node1 != null) {
//            head.next = node1;
//        }
//        if (node2 != null) {
//            head.next = node2;
//        }

        if (node1.val <= node2.val) {
            head = node1;
            head.next = mergeTwoLists(node1.next, node2);
        } else {
            head = node2;
            head.next = mergeTwoLists(node1, node2.next);
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
