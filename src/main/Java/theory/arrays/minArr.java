package theory.arrays;

public class minArr {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(minArr(nums));
    }

    public static int minArr(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
