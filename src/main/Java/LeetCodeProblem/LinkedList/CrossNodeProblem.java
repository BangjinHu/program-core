package LeetCodeProblem.LinkedList;

public class CrossNodeProblem {

    public static void main(String[] args) {
        int[] arrOne = new int[]{1,2,3,4,5};
        int[] arrTwo = new int[]{1,2,3,4,5,2};
        Node headOne = add(arrOne);
        Node headTwo = add(arrTwo);

//        Node cur = headOne;
//        while (cur != null){
//            System.out.println(cur.value + " ");
//            cur = cur.next;
//        }
        System.out.println(loopNode(headTwo));
//        System.out.println(crossNodeProblem(add(arrOne), add(arrTwo)));
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node add(int[] arr){
        if (arr == null || arr.length < 1){
            return null;
        }
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

    public static Node crossNodeProblem(Node headOne, Node headTwo){
        if (headOne == null || headTwo == null){
            return null;
        }

        Node loopOne = loopNode(headOne);
        Node loopTwo = loopNode(headTwo);

        //两无环链表相交情况
        if (loopOne == null && loopTwo == null){
            return noLoop(headOne, headTwo);
        }

        //两有环链表相交情况
        if (loopOne != null && loopTwo != null){
            return bothLoop(headOne, loopOne, headTwo, loopTwo);
        }
        return null;
    }

    public static Node loopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node nOne = head.next;//慢指针
        Node nTwo = head.next.next;//快指针
        //循环
        while (nOne != nTwo){
            if (nTwo.next == null || nTwo.next.next == null){
                return null;
            }
            nTwo = nTwo.next.next;
            nOne = nOne.next;
        }

        //在有环链表中两者相遇，则快指针回到头结点，按步长为1开始走，慢指针照旧
        nTwo = head;
        while (nOne != nTwo){
            nTwo = nTwo.next;
            nOne = nOne.next;
        }

        //相遇，返回其中任何一个都可以，这是有环链表的入口结点
        return nOne;
    }

    //1. 两个链表都是无环的情况
    public static Node noLoop(Node headOne, Node headTwo){
        if (headOne == null || headTwo == null){
            return null;
        }

        Node curOne = headOne;
        Node curTwo = headTwo;
        int n = 0;
        while (curOne.next != null){
            n++;
            curOne = curOne.next;
        }

        while (curTwo.next != null){
            n--;
            curTwo = curTwo.next;
        }

        //遍历两链表结束都没相遇，则两者不相交
        if (curOne != curTwo){
            return null;
        }

        curOne = n > 0 ? headOne : headTwo;
        curTwo = curOne == headOne ? headTwo : headOne;
        n = Math.abs(n);
        //开始找两无环链表的交点
        //让长度长的先走
        while (n != 0){
            n--;
            curOne = curOne.next;
        }
        //然后两者一起走，当两个节点相等时则是第一个交点
        while (curOne != curTwo){
            curOne = curOne.next;
            curTwo = curTwo.next;
        }
        return curOne;
    }

    //2. 两个链表都是有环的情况
    public static Node bothLoop(Node headOne, Node loopOne, Node headTwo, Node loopTwo){
        Node curOne = null;
        Node curTwo = null;
        if (loopOne == loopTwo){
            curOne = headOne;
            curTwo = headTwo;
            int n = 0;
            while (curOne.next != null){
                n++;
                curOne = curOne.next;
            }

            while (curTwo.next != null){
                n--;
                curTwo = curTwo.next;
            }
            //和无环链表相交情况类似
            curOne = n > 0 ? headOne : headTwo;
            curTwo = curOne == headOne ? headTwo : headOne;
            n = Math.abs(n);
            //链表较长的链表先将长出来的部分走完
            while (n != 0){
                n--;
                curOne = curOne.next;
            }
            //然后两链表再一起走
            while (curOne != curTwo){
                curOne = curOne.next;
                curTwo = curTwo.next;
            }
            return curOne;
        }else {
            //表示在环中能够找到loop2这一节点
            curOne = loopOne.next;
            while (curOne != loopOne){
                //如果能够找到则相交，否则不相交
                if (curOne == loopTwo){
                    return loopOne;
                }
                curOne = curOne.next;
            }
            return null;
        }
    }
}