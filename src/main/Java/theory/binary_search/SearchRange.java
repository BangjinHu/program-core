package theory.binary_search;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(nums, target);
        System.out.println(range[0] + " " + range[1]);
        
    }

    private static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int idx = binarySearch(nums, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int left = idx, right = idx;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }

        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
