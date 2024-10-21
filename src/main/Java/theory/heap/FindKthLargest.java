package theory.heap;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("current nums kth largest number is : " + findKthLargest(nums, k));
    }

    private static int findKthLargest(int[] arr, int k) {
        int length = arr.length;
        int left = 0, right = length - 1;
        int target = length - k;
        while (true) {
            int index = partition(arr, left, right);
            if (index == target) {
                return arr[index];
            } else if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left, left + (int) (Math.random() * (right - left + 1)));
        }
        int p = arr[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index, left);
        return index;
    }

    private static void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int cur = nums[left];
        nums[left] = nums[right];
        nums[right] = cur;
    }
}
