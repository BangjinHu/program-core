package LeetCodeProblem.BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

public class OrderRecur {

    private static LinkedList<Node> linkedList;
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //递归实现
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }

        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }

        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    //非递归实现
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecurOne(Node head){
        System.out.println("pre-order:");
        if (head != null){
            Stack<Node> stackOne = new Stack<>();
            Stack<Node> stackTwo = new Stack<>();
            stackOne.push(head);
            if (!stackOne.isEmpty()){
                head = stackOne.pop();
                stackTwo.push(head);
                if (head.left != null){
                    stackOne.push(head.left);
                }

                if (head.right != null){
                    stackOne.push(head.right);
                }
            }

            while (!stackTwo.isEmpty()){
                System.out.print(stackTwo.pop().value + " ");

            }
            System.out.println();
        }
    }

    //head表示最近一次弹出并打印的节点
    public static void posOrderUnRecurTwo(Node head){
        System.out.println("pos-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            //c表示栈顶元素
            Node c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right){
                    stack.push(c.left);
                }else if (c.right != null && head != c.right){
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    head = c;
                }
            }
        }
        System.out.println();
    }

    //由数组创建二叉树
    public static void create(int[] arr){
        linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++){
            linkedList.add(new Node(arr[i]));
        }

        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++){
            linkedList.get(parentIndex).left = linkedList.get(parentIndex * 2 + 1);
            linkedList.get(parentIndex).right = linkedList.get(parentIndex * 2 + 2);
        }

        int lastParentIndex = arr.length / 2 - 1;
        linkedList.get(lastParentIndex).left = linkedList.get(lastParentIndex * 2 + 1);
        if (arr.length % 2 == 1){
            linkedList.get(lastParentIndex).right = linkedList.get(lastParentIndex * 2 + 2);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        create(arr);
        Node head = linkedList.get(0);
        preOrderRecur(head);
//        inOrderRecur(head);
//        posOrderRecur(head);
    }
}
