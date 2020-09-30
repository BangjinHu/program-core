package LeetCodeProblem.Array_Problem;

public class MaxGap {
    public static void main(String[] args) {

        int[] nums = new int[]{9,3,1,0};
        System.out.println(maxGap(nums));
    }

    public static int maxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //拿到nums数组中的最小值和最大值
        for (int i = 0; i < len; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //如果最小值和最大值相同
        if (min == max){
            return 0;
        }

        //
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];

        int bid = 0;
        for (int i = 0; i < len; i++){
            bid = bucket(nums[i], len, min, max);//桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }

        int result = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++){
            if (hasNum[i]){
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return result;
    }

    //使用long类型是防止相乘时溢出
    public static int bucket(long num, long len, long min, long max){
        return (int) ((num - min) * len / (max - min));
    }
}
