package LeetCodeProblem.SORT;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 1, 2, 8, 7};
        quick_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quick_sort(int[] arr, int left, int right){
        if (null == arr || arr.length < 2){
            return;
        }
        if (left < right){
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] partition = partition(arr, left, right);
            quick_sort(arr, left, partition[0] - 1);
            quick_sort(arr, partition[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr, ++less, left++);
            }else if (arr[left] > arr[right]){
                swap(arr, --more, left);
            }else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        /*arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];*/
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
