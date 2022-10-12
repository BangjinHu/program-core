package LeetCodeProblem.Array_Problem;

public class zeroOneNum {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 1, 1};
        int[] nums = new int[]{1};
        System.out.println(zeroOneNum(nums));
    }

    public static int zeroOneNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0] == 1 ? 1 : 0;
        }
        int left = 0, right = 1;
        int max = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                right++;
                left = right - 1;
            } else if (nums[left] == 1) {
                right++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
