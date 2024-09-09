package theory.arrays;

public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minSubArrayLen = minSubArrayLen(target, nums);
        System.out.println(minSubArrayLen);
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}