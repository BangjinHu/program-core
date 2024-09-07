package theory.divide_and_conquer;

public class MergeKLists {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[matrix.length];
        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            for (int j = 0; j < matrix[i].length; j++) {
                curr.next = new ListNode(matrix[i][j]);
                curr = curr.next;
            }
            lists[idx++] = dummy.next;
        }

        ListNode head = mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    static class ListNode {
        private final int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
