package theory.arrays;

public class maxSlidingWindow {

    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口最大值
        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] left = new int[length];
        left[0] = nums[0];

        int[] right = new int[length];
        right[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }

            int j = length - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }

        int[] res = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }
}
