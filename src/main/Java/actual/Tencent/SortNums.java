package actual.Tencent;

public class SortNums {

    public static void main(String[] args) {

    }

    private void sortNums(int[] nums) {
        quickSort(nums);
    }

    private void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left, left + (int) (Math.random() * (right - left + 1)));
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] - 1);
            quickSort(nums, p[1] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, left, --more);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

}
