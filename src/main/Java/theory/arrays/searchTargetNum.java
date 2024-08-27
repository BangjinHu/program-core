package theory.arrays;

public class searchTargetNum {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchTargetNum(nums, target));
    }

    public static int searchTargetNum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = 0;
        while (left < nums.length && nums[left++] == target) {
            ans++;
        }
        return ans;
    }
}
