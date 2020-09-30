package LeetCodeProblem.SORT;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 0, 3, 6, 4, 7};
//        insertSort1(arr);
//        insertSort2(arr);
//        insertSort3(arr);
        insertSort4(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertSort1(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = i; j >= 1 && arr[j] < arr[j-1]; j--){
                swap(arr, j, j-1);
            }
        }
    }

    public static void insertSort2(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int idx = 0;
            for (int j = i; j >= 1; j--){
                if (tmp < arr[j-1]){
                    arr[j] = arr[j-1];
                }else {
                    idx = j;
                    break;
                }
            }
            arr[idx] = tmp;
        }
    }

    public static void insertSort3(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int num = binaryFind(arr, arr[i], 0, i-1);
            int tmp = arr[i];
            for (int j = i; j > num; j--){
                arr[j] = arr[j-1];
            }
            arr[num] = tmp;
        }
    }

    public static void insertSort4(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
                swap(arr, j, j+1);
            }
        }
    }

    private static int binaryFind(int[] arr, int tmp, int down, int up) {
        if (up < down || up > arr.length || down < 0){
            throw new IllegalArgumentException("arrayboundindex is error");
        }
        if (tmp < arr[down]){
            return down;
        }
        if (tmp > arr[up]){
            return up + 1;
        }

        int mid = (up - down) / 2 + down;
        if (tmp == arr[mid]){
            return mid + 1;
        }else if (tmp < arr[mid]){
            up = mid - 1;
        }else if (tmp > arr[mid]){
            down = mid + 1;
        }
        return binaryFind(arr, tmp, down, up);
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
