package LeetCodeProblem.SORT;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 1, 2, 8, 7};
//        heapify(arr, arr.length, 0);
        //构建大根堆
        heap_sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void heap_sort(int[] arr){
        build_heap(arr);
        for (int i = arr.length - 1; i >= 0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void build_heap(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        int last_node = arr.length - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0; i--){
            heapify(arr, arr.length, i);
        }
    }

    public static void heapify(int[] arr, int n, int index){
        if (index >= n){
            return;
        }
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < n && arr[left] > arr[max]){
            max = left;
        }
        if (right < n && arr[right] > arr[max]){
            max = right;
        }
        if (max != index){
            swap(arr, max, index);
            heapify(arr, n, max);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
