package actual.Baidu;

public class MaxProfit {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3, 2, 5, 9, 2, 3};
        int maxProfit = maxProfit(nums);
        System.out.println("current max value is: " + maxProfit);
    }

    private static int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = nums[0], max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return max;
    }
}
