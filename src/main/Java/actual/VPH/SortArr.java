package actual.VPH;


import java.util.Random;
import java.util.Scanner;

public class SortArr {

    static Random random = new Random();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(findKthNum(arr, k));
        }
    }

    public static int findKthNum(int[] nums, int k){
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSort(int[] arr, int left, int right, int index){
        int x = randomP(arr, left, right);
        if (x == index){
            return arr[x];
        }else {
            return x < index ? quickSort(arr, x + 1, right, index) : quickSort(arr, left, x - 1, index);
        }
    }

    private static int randomP(int[] arr, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(arr, i, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {

        int x = arr[right], i = left - 1;
        for (int k = left; k < right; k++){
            if (arr[k] <= x){
                swap(arr, ++i, k);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int right) {
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
    }
}
