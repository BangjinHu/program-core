//package LeetCodeProblem.IEEE;
//
//import java.util.LinkedList;
//
//public class Demo5 {
//
//    private static LinkedList<TreeNode> linkedList;
//
//    public class TreeNode {
//        public TreeNode left;
//        public TreeNode right;
//        public int val;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public void createBinaryTree(int[] arr) {
//        linkedList = new LinkedList<>();
//        for (int i = 0; i < arr.length; i++){
//            linkedList.add(new TreeNode(i));
//        }
//        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++){
//            linkedList.get(parentIndex).left = linkedList.get(parentIndex * 2 + 1);
//            linkedList.get(parentIndex).right = linkedList.get(parentIndex * 2 + 2);
//        }
//        int lastParentIndex = arr.length / 2 - 1;
//        linkedList.get(lastParentIndex).left = linkedList.get(lastParentIndex * 2 + 1);
//        if (arr.length % 2 == 1){
//            linkedList.get(lastParentIndex).right = linkedList.get(lastParentIndex * 2 + 2);
//        }
//    }
//
////    public int treeSum(TreeNode head, int[][] weight){
////
////        if (head == null){
////            return 0;
////        }
////        int maxDistance = getMaxDistance(weight);
////        return maxDistance;
////
////    }
//
////    private int getMaxDistance(int[][] weight) {
////        for (int i = 0; i < weight.length; i++){
////
////
////
////
////        }
////        return Math.max(weight)
////    }
//
//    public static void main(String[] args) {
//
//        int[] arr = new int[]{1,2,3,4,5};
//        Demo5 demo5 = new Demo5();
//        demo5.createBinaryTree(arr);
//        TreeNode head = linkedList.get(0);
//        System.out.println(head.val);
//        int[][] weight = new int[][]{{1}, {2}, {3}, {4}};
//        System.out.println(demo5.treeSum(head,weight));
//
//    }
//}
