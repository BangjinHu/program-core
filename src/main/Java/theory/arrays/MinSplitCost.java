package theory.arrays;

import java.util.PriorityQueue;

public class MinSplitCost {
    public static void main(String[] args) {

    }

    public int minSplitCost(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        //优先级队列就是堆结构，默认是小根堆结构
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            minHeap.add(arr[i]);
        }
        int result = 0;
        while (minHeap.size() != 1){
            int sum = minHeap.poll() + minHeap.poll();
            result += sum;
            minHeap.add(sum);
        }
        return result;
    }
}
