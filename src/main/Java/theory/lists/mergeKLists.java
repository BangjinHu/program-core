package theory.lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt((ListNode o) -> o.val));
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
