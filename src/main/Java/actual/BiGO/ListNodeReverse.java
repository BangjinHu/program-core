package actual.BiGO;

public class ListNodeReverse {

    public static void main(String[] args) {


    }

    public ListNode nodeConvert(ListNode head, int k){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur.next;
        while (cur != null && cur.next != null){
            int count = k;
            while (count > 0){
                cur.next = pre;
                pre = cur;
                cur = next;
                cur = cur.next;
                count--;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
