package actual.Didi;

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                pre.next = node1;
                pre = pre.next;
                node1 = node1.next;
            } else {
                pre.next = node2;
                pre = pre.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            pre.next = node1;
        }
        if (node2 != null) {
            pre.next = node2;
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
