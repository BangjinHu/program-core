package actual.Didi;

public class FindUnsortedSubarray {

    public static void main(String[] args) {

    }

    private static int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = nums[0], high = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                high = i;
            } else {
                max = Math.max(max, nums[i]);
            }
        }

        int min = nums[nums.length - 1], low = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) {
                low = i;
            } else {
                min = Math.min(min, nums[i]);
            }
        }

        return high > low ? high - low + 1 : 0;
    }
}
