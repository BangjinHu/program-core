package actual.Didi;

public class MergeKLists {

    public static void main(String[] args) {

    }

    private static ListNode mergeKLists(ListNode[] lists) {
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
        ListNode head = null;
        if (node1.val <= node2.val) {
            head = node1;
            head.next = mergeTwoLists(node1.next, node2);
        } else {
            head = node2;
            head.next = mergeTwoLists(node1, node2.next);
        }
        return head;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
