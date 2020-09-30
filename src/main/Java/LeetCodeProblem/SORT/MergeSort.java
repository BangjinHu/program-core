package LeetCodeProblem.SORT;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 1, 2, 8, 7};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left > right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid - 1);
        mergeSort(arr, mid + 1, right);
        mergeSort(arr, left, mid, right);
    }

    private static void mergeSort(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        //这里的p1表示一个指向左侧位置的指针
        int p1 = l;
        //这里的p2表示一个指向mid+1位置的指针
        int p2 = m + 1;
        //然后这里的while表示两个数组arr1与arr2中两者的较小者填进辅助数组中
        while (p1 <= m && p2 <= r) {
            //这里的help[]是一个辅助数组
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //这里表示p1没有越界，那么p2一定越界，所以将p1剩下的所有拷贝至辅助数组中去
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        //这里p2没有越界，那么就表示P1一定越界，所以将p2剩下的数据全都拷贝到辅助数组中去
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //然后将辅助数组替换为原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
