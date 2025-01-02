package actual.vmware;

import java.util.HashSet;
import java.util.Set;

public class MaxLength {

    public static void main(String[] args) {
        //[100, 4, 200, 5, 3, 2]
        int[] nums = new int[]{100, 4, 200, 5, 3, 2};
        int maxLength = maxLength(nums);
        System.out.println("current array's max length is : " + maxLength);
    }

    private static int maxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> dpNums = new HashSet<>();
        for (int num : nums) {
            dpNums.add(num);
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (!dpNums.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (dpNums.contains(curNum + 1)) {
                    curLen += 1;
                    curNum += 1;
                }
                max = Math.max(curLen, max);
            }
        }
        return max;
    }
}
