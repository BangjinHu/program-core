package theory.arrays;

public class minNum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(minNum(nums));
    }

    public static int minNum(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] == nums[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
