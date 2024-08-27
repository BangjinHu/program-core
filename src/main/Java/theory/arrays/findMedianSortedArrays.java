package theory.arrays;

public class findMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 3, 5, 6, 7};
        int[] nums2 = new int[]{2, 4, 8, 9, 10};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, idx = 0;
        int len = m + n;
        Integer pre = null, cur = null;
        while (idx < (len >> 1) + 1) {
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
            idx++;
        }
        if ((len & 1) == 0) {
            return 0.5 * (cur + pre);
        }
        return cur;
    }
}
