package actual.Didi;

public class MergeTwoNums {

    public static void main(String[] args) {

    }

    private static void merge(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
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
