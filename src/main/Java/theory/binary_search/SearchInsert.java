package theory.binary_search;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;

//        int[] nums = new int[]{1, 3, 5, 6};
//        int target = 7;

//        int[] nums = new int[]{1, 3, 5, 6};
//        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    private static int searchInsert(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
