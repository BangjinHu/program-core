package theory.arrays;

public class numIdx {

    public static void main(String[] args) {

    }

    public int numIdx(int[] nums, int target) {

        // 有序数组/返回重复元素最后下标
        int low = 0, high = nums.length - 1;
        int idx = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            idx = mid;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] == target && nums[idx] == nums[idx + 1]) {
                idx += 1;
            } else {
                low = mid + 1;
            }
            if (idx != 0) {
                return idx;
            }
        }
        return low;
    }
}
