package LeetCodeProblem.Else_Problem;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

//堆，是一种经过排序的完全二叉树，借助类PriorityQueue可实现大根堆和小根堆
//默认排序是自然排序，队头元素是最小元素，所以用作小根堆
//大根堆需要借助comparator比较器来实现
public class TopKSum {

    public class Node{
        public int indexOne;
        public int indexTwo;
        public int value;

        public Node(int indexOne, int indexTwo, int sum) {
            this.indexOne = indexOne;
            this.indexTwo = indexTwo;
            this.value = sum;
        }
    }

    //借助比较器来实现
    public class MaxHeapComp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }

    public int[] topKSum(int[] arrOne, int[] arrTwo, int topK){
        if (arrOne == null || arrTwo == null || topK < 1){
            return null;
        }

        topK = Math.min(topK, arrOne.length * arrTwo.length);
        int[] result = new int[topK];
        int resultIndex = 0;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MaxHeapComp());
        HashSet<String> postionSet = new HashSet<>();

        int iOne = arrOne.length - 1;
        int iTwo = arrTwo.length - 1;
        maxHeap.add(new Node(iOne, iTwo, arrOne[iOne] + arrTwo[iTwo]));

        postionSet.add(String.valueOf(iOne + "_" + iTwo));

        while (resultIndex != topK){
            Node curNode = maxHeap.poll();
            result[resultIndex++] = curNode.value;
            iOne = curNode.indexOne;
            iTwo = curNode.indexTwo;

            if (!postionSet.contains(String.valueOf((iOne-1) + "_" + (iTwo)))){
                postionSet.add(String.valueOf((iOne-1) + "_" + (iTwo)));
                maxHeap.add(new Node(iOne-1, iTwo, arrOne[iOne-1] + arrTwo[iTwo]));
            }

            if (!postionSet.contains(String.valueOf(iOne + "_" + (iTwo-1)))){
                postionSet.add(String.valueOf(iOne + "_" + (iTwo-1)));
                maxHeap.add(new Node(iOne, iTwo-1, arrOne[iOne] + arrTwo[iTwo-1]));
            }
        }
        return result;
    }
}
