package LeetCodeProblem.Else_Problem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianHolder {

    public class MinHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public class MaxHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianHolder() {
        maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
    }

    public void addNumber(int num){
        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        modifyTwoHeap();
    }

    public Integer getMedian(){
        if (maxHeap.isEmpty()){
            return null;
        }

        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    private void modifyTwoHeap(){
        if (maxHeap.size() == minHeap.size() + 2){
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() == maxHeap.size() + 2){
            maxHeap.add(minHeap.poll());
        }
    }
}
