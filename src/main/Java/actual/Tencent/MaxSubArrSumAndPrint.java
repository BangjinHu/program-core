package actual.Tencent;

public class MaxSubArrSumAndPrint {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        RNode result = findMaxSubarraySum(array);
        System.out.println("max sub array sum is: " + result.maxSum);
        System.out.print("sub array is: [");
        for (int i = result.start; i <= result.end; i++) {
            System.out.print(array[i] + (i == result.end ? "" : ", "));
        }
        System.out.println("]");
    }

    public static RNode findMaxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array can't be null.");
        }
        int maxSum = nums[0], maxCur = nums[0];
        int start = 0, end = 0;
        int curStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (maxCur + nums[i] > nums[i]) {// 当前位置是正数
                maxCur += nums[i];
            } else {// 当前位置是负数
                maxCur = nums[i];
                curStart = i; // 更新临时起始位置
            }
            if (maxCur > maxSum) {// 更新最大和
                maxSum = maxCur;
                start = curStart; // 更新最大子数组的起始位置
                end = i; // 更新最大子数组的结束位置
            }
        }
        return new RNode(maxSum, start, end);
    }

    static class RNode {
        int maxSum;
        int start;
        int end;

        RNode(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

    }
}
