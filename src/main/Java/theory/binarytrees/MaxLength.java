package theory.binarytrees;

import java.util.HashMap;

public class MaxLength {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxLength(Node head, int sum){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    public static int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap){
        if (head == null){
            return maxLen;
        }

        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)){
            sumMap.put(curSum, level);
        }

        if (sumMap.containsKey(curSum - sum)){
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }

        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
        if (level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        

    }
}
