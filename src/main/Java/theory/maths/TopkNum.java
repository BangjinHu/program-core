package theory.maths;

public class TopkNum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("current top k num is: " + topKNum(nums, k));
    }

    private static int topKNum(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left, left + (int) Math.random() * (right - left + 1));
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
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
