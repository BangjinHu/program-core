package theory.hashs;

import java.util.HashSet;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueSet.contains(nums[i])) {
                return true;
            }
            uniqueSet.add(nums[i]);
            if (uniqueSet.size() > k) {
                uniqueSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
