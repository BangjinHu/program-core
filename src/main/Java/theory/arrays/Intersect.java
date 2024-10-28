package theory.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersect {

    public static void main(String[] args) {

    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ansList.add(nums1[i]);
                i++;
                j++;
            }
        }
        return ansList.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}
