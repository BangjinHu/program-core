package LeetCodeProblem.Array_Problem;

public class MNum {

    //求解某数组的众数
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 3, 3, 4, 3, 1, 1, 5, 4, 5, 3, 2, 1, 8};
        System.out.println(mNum(arr));

    }

    /*public static int majorNum(int[] arr){
        return majorEle(arr, 0, arr.length - 1);
    }

    private static int majorEle(int[] arr, int left, int right) {
        if (left == right){
            return arr[left];
        }
        int mid = left + (right - left) >> 1;
        int l = majorEle(arr, left, mid);
        int r = majorEle(arr, mid + 1, right);
        if (left == right){
            return left;
        }
        int left_count = countInRange(arr, l, left, right);
        int right_count = countInRange(arr, r, left, right);
        return left_count > right_count ? l : r;
    }

    private static int countInRange(int[] arr, int num, int left, int right) {

        int count = 0;
        for (int i = left; i <= right; i++){
            if (arr[i] == num){
                count++;
            }
        }
        return count;
    }*/

    public static int mNum(int[] nums){
        //投票法
        int cnum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++){
            if (cnum == nums[i]){
                count++;
            }else if (--count == 0){
                cnum = nums[++i];
                count = 1;
            }
        }
        return cnum;
    }
}
