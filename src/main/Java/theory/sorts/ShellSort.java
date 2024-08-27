package theory.sorts;



public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 6, 8, 7, 4, 1};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print (arr[i] + " ");
        }
    }

    public static void shellSort(int[] arr){
        /*int len = arr.length;
        for (int h = len / 2; h > 0; h = h / 2){
            for (int i = h; i < len; i++){
                int tmp = arr[i];
                for (int j = i - h; j >= 0; j -= h){
                    if (tmp < arr[j]){
                        arr[j+h] = arr[j];
                    }else {
                        break;
                    }
                    arr[j+h] = tmp;
                }
            }
        }*/

        int size = arr.length;
        int h = 1;
        while(h < size/3){
            h = 3*h + 1;
        }

        while(h > 0) {
            //插入排序，间隔h
            for(int i=h; i<size; i++) {
                for(int j=i; j>=h && arr[j] < arr[j-h]; j = j-h) {
                    swap(arr, j, j-h);
                }
            }
            h = h/3;//子序列长度可以变换
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
