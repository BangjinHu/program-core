package theory.arrays;

public class KArrMerge {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        int[] res = mergeKNums(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] mergeKNums(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new int[0];
        }
        int rows = nums.length, cols = nums[0].length;
        int[] res = new int[rows * cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            int left = 0, right = nums[i].length - 1;
            int index = merge(nums[i], left, right);
            res[idx++] = nums[i][index];
        }
        return res;
    }


    private static int merge(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left, (int) Math.random() * (right - left + 1));
        }
        int p = nums[left];
        int low = left;
        while (low < right) {
            if (nums[low] < p) {
                swap(nums, low, left);
                low++;
            }
        }
        swap(nums, low, left);
        return low;
    }

    private static void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
