package actual.Tencent;

public class FindMedianSortedArrays {

    public static void main(String[] args) {

    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int cur = -1, pre = -1, i = 0, j = 0, index = 0;
        while (index < len / 2 + 1) {
            pre = cur;
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i > m && j < n) {
                cur = nums2[j++];
            } else if (i < m) {
                cur = nums1[i++];
            }
            index++;
        }
        double ans = 0.0;
        if ((len & 1) == 0) {
            ans = (pre + cur) / 2;
        } else {
            ans = cur;
        }
        return ans;
    }
}
