package actual.Didi;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int index = findPeakElement(nums);
        System.out.println("current peak index is: " + index + " and value is: " + nums[index]);
    }

    private static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
