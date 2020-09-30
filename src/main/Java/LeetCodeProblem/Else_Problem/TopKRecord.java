package LeetCodeProblem.Else_Problem;

import java.util.HashMap;

public class TopKRecord {
    public class Node{
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    private Node[] heap;//小根堆
    private int index;
    private HashMap<String, Node> strNodeMap;
    private HashMap<Node, Integer> nodeIndexMap;

    public TopKRecord(int size){
        heap = new Node[size];
        index = 0;
        strNodeMap = new HashMap<>();
        nodeIndexMap = new HashMap<>();
    }

    public void add(String str){
        Node curNode = null;
        int preIndex = -1;
        if (!strNodeMap.containsKey(str)){
            //新加入的str如果不在map中
            curNode = new Node(str, 1);
            strNodeMap.put(str, curNode);
            nodeIndexMap.put(curNode, -1);
        }else {
            curNode = strNodeMap.get(str);
            curNode.times++;
            preIndex = nodeIndexMap.get(curNode);
        }

        if (preIndex == -1){
            if (index == heap.length){
                if (heap[0].times < curNode.times){
                    nodeIndexMap.put(heap[0], -1);
                    nodeIndexMap.put(curNode, 0);
                    heap[0] = curNode;
                    heapify(0, index);
                }
            }else {
                nodeIndexMap.put(curNode, index);
                heap[index] = curNode;
                heapInsert(index++);
            }
        }else {
            heapify(preIndex, index);
        }
    }

    public void printTopK(){
        System.out.println("Top:");
        for (int i = 0; i != heap.length; i++){
            if (heap[i] == null){
                break;
            }

            System.out.println("str:" + heap[i].str);
            System.out.println("times:" + heap[i].times);
        }
    }

    public void heapInsert(int index){
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

    public void heapify(int index, int heapSize){
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
