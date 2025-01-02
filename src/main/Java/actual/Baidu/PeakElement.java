package actual.Baidu;

public class PeakElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int val = findPeakElement(nums);
        System.out.println("current max value is: " + val);
    }

    public static int findPeakElement(int[] nums) {

        //1.迭代二分查找
        int left = 0;
        int right = nums.length - 1;
        //开始二分查找
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
