package theory.arrays;

public class SearchRotateTarget {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int idx = searchRotate(nums, target);
        System.out.println("current target idx: " + idx);
    }

    private static int searchRotate(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < arr[right]) {
                if (arr[mid] <= target && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return left;
    }
}
