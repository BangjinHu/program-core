package theory.arrays;

public class binarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 1, 7, 9};
        int target = 7;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
