package theory.arrays;

public class minLenSubArr {

    public static void main(String[] args) {

    }

    public int minSubArrLen(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0, minLen = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLen = minLen == 0 ? i - idx + 1 : Math.min(minLen, i - idx + 1);
                sum -= nums[idx++];
            }
        }
        return minLen;
    }
}
