package LeetCodeProblem.Array_Problem;

public class MaxSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,3,5,-2,6,-1};
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[] arr){
        int cur = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++){
            cur += arr[i];
            if (cur < 0){
                cur = 0;
            }else{
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}
