package LeetCodeProblem.SORT;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 0, 3, 6, 4, 7};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        //异或操作
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
