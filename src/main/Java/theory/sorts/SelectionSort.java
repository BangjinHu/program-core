package theory.sorts;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 0, 3, 6, 4, 7};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void selectionSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++){
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++){
                min_idx = arr[j] < arr[min_idx] ? j : min_idx;//find min index
            }
            swap(arr, i, min_idx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
