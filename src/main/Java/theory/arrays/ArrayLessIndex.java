package theory.arrays;

public class ArrayLessIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,5,3,4,6,8};
        System.out.println(arrayLessIndex(arr));
    }

    //任意返回一个数组中局部最小位置
    public static int arrayLessIndex(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        //局部最小在开头位置
        if (arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        //局部最小在最后位置
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        //局部最小在中间位置
        int left = 1;
        int right = arr.length - 2;

        int mid = 0;
        while (left < right){
            //二分查找
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
