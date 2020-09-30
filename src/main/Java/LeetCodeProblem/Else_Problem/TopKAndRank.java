package LeetCodeProblem.Else_Problem;

import java.util.HashMap;
import java.util.Map;

public class TopKAndRank {

    public class Node{
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public void topKAndRank(String[] arr, int topK){
        if (arr == null || topK < 1){
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        //生成哈希表
        for (int i = 0; i != arr.length; i++){
            String cur = arr[i];
            if (!map.containsKey(cur)){
                map.put(cur, 1);
            }else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        Node[] heap = new Node[topK];

        int index = 0;
        //遍历哈希表，决定每条信息是否进堆
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int times = entry.getValue();
            Node node = new Node(str, times);
            if (index != topK){
                heap[index] = node;
                heapInsert(heap, index++);
            }else {
                if (heap[0].times < node.times){
                    heap[0] = node;
                    heapify(heap, 0, topK);
                }
            }
        }

        //将小根堆的所有元素按照词频从小到大排序
        for (int i = index - 1; i != 0; i--){
            swap(heap, 0, i);
            heapify(heap, 0, i);
        }

        //严格按照排名打印k条记录
        for (int i = 0; i != heap.length; i++){
            if (heap[i] == null){
                break;
            }else {
                System.out.println("No." + (i+1) + ":");
                System.out.println(heap[i].str + ", times：");
                System.out.println(heap[i].times);
            }
        }
    }

    public void heapInsert(Node[] heap, int index){
        while (index != 0){
            int parent = (index - 1) / 2;
            if (heap[index].times < heap[parent].times){
                swap(heap, parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    public void heapify(Node[] heap, int index, int heapSize){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < right){
            if (heap[left].times < heap[index].times){
                smallest = left;
            }

            if (right < heapSize && heap[right].times < heap[smallest].times){
                smallest = right;
            }

            if (smallest != index){
                swap(heap, smallest, index);
            }else {
                break;
            }

            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public void swap(Node[] heap, int indexOne, int indexTwo){
        Node temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }
}
