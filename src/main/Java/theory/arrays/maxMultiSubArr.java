package theory.arrays;

public class maxMultiSubArr {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, -2, 1};
        System.out.println(maxSubArr(nums));
    }

    public static int maxSubArr(int[] nums) {
        int max = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int mNum = curMax;
                curMax = curMin;
                curMin = mNum;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
