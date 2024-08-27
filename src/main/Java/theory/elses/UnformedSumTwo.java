package theory.elses;

public class UnformedSumTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5};
        System.out.println(unformedSumTwo(arr));
    }

    public static int unformedSumTwo(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        //首先收集整个数组的和与数组中的最小值
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }

        //然后创建dp数组，用动态规划求解，是累加和
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++){
            for (int j = sum; j >= arr[i]; j--){
                //表示j这个累加和能够被arr的子集相加得到
                dp[j] = dp[j-arr[i]] ? true : dp[j];
            }
        }

        for (int i = min; i != dp.length; i++){
            //如果i这个累加和不能由arr的子集得到，则返回累加和
            if (!dp[i]){
                return i;
            }
        }
        return sum+1;
    }


}
