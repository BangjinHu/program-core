package theory.arrays;

import java.util.Scanner;

public class NextPermutation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            nextPermutation(arr);
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }

    }

    //下一个排列：表示的是在当前数组的排序中，排在当前最小的数组的下一个数组
    public static void nextPermutation(int[] nums) {
        /*if(nums.length <= 1){
            return;
        }
        int length = nums.length - 1;
        while(length - 1 > 0 && nums[length - 1] >= nums[length]){
            --length;
        }
        if(length == 0){
            for(int i = 0; i < nums.length / 2; i++){
                swap(nums[i], nums[nums.length - 1 - i]);
            }
            return;
        }
        int right = nums.length - 1;
        while(right >= length){
            if(nums[right] > nums[length - 1]) break;
            --right;
        }
        swap(nums[right], nums[length - 1]);
        int count = (nums.length - length) / 2;
        int i = 0;
        while(count > 0){
            swap(nums[length + i], nums[nums.length - 1 - i]);
            ++i;
            --count;
        }
        return;*/

        int i = nums.length - 2;
        //从后往前查第一个顺序对a[i] < a[i+1]
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            //较小数a[i]
            //较大数a[j]
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

        int idx = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}
