package actual.Tencent;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        int index = findKthLargest(nums, k);
        System.out.println("current nums kth largest num is: " + index);
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, target = nums.length - k;
        while (true) {
            int idx = partition(nums, left, right);
            if (idx == target) {
                return nums[target];
            } else if (idx < target) {
                left = idx + 1;
            } else if (idx > target) {
                right = idx - 1;
            }
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
                index++;
                swap(nums, index, i);
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
        nums[right] = nums[left];
        nums[left] = t;
    }
}
