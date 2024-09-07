package theory.binary_search;

public class FindMedianSortedArrays {

    public static void main(String[] args) {

    }

    private static int findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int length = m + n;
        int pre = 0, cur = 0, idx = 0, i = 0, j = 0;
        while (idx < n / 2 + 1) {
            pre = cur;
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i >= m && j < n) {
                cur = nums2[j++];
            } else {
                cur = nums1[i++];
            }
        }
        if (n % 2 == 0) {
            return cur;
        }
        return (pre + cur) / 2;
    }
}
