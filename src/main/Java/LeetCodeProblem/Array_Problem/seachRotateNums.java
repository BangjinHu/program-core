package LeetCodeProblem.Array_Problem;

public class seachRotateNums {

    public static void main(String[] args) {

    }

    public int searchRotateNums(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
