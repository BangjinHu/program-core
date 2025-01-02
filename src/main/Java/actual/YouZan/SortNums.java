package actual.YouZan;

public class SortNums {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 5, 4};
        sortNums(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    private static void sortNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        sort(nums, left, right);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            sort(nums, left, index - 1);
            sort(nums, index + 1, right);
        }
    }


    private static int partition(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left, left + (int) (Math.random() * (right - left + 1)));
        }
        int p = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < p) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index, left);
        return index;
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
