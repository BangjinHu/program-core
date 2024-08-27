package theory.arrays;

public class moutainNums {

    public static void main(String[] args) {

    }

    /**
     * 山脉数组中找target值的最小下标值
     * @param nums
     * @return
     */
    public int moutainNums(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            // 1,2,3,2,1 3
            int mid = low + (high - low) / 2;
            if (nums[mid] < target && nums[mid] < nums[high]) {
                low = mid + 1;
            } else if (nums[mid] > target && nums[mid] > nums[high]) {
                high = mid - 1;
            } else {
                if (mid == 0) {

                }
                return mid;
            }
        }
        return -1;
    }
}
