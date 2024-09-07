package theory.listnodes.util;

public class BuildListNode {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, 2, 3};
        ListNode head = createListNode(nums);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static ListNode createListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    static class ListNode {
        private final int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
