package actual.Didi;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    private static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        quickSort(nums, left, right);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left, left + (int) (Math.random() * (right - left + 1)));
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] - 1);
            quickSort(nums, p[1] + 1, right);
        }
    }

    private static int[] partition(int[] nums, int left, int right) {
        int less = left - 1, more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, --more, left);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
