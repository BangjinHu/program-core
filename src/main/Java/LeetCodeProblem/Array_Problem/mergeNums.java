package LeetCodeProblem.Array_Problem;

public class mergeNums {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 5, 6, 8};
        int[] nums2 = new int[]{3, 7, 9, 12};
        mergeNums(nums1, 5, nums2, 4);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
            System.out.print(" ");
        }
    }

    // 合并两个有序数组
    public static void mergeNums(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        while (n != 0) {
            if (m == 0 || nums1[m - 1] <= nums2[n - 1]) {
                nums1[length--] = nums2[--n];
            } else {
                nums1[length--] = nums1[--m];
            }
        }
    }
}
