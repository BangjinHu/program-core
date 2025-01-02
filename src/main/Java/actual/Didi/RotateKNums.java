package actual.Didi;

public class RotateKNums {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateKNums(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void rotateKNums(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
