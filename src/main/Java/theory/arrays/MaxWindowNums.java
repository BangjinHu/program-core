package theory.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxWindowNums {

    public static void main(String[] args) {
        
    }

    private static List<Integer> maxWindowNums(int[] nums) {

        int left = 0, right = 1;
        List<Integer> ansList = new ArrayList<>();
        int maxNum = Integer.MIN_VALUE;
        for (; right < nums.length; right++) {
            if (right - left + 1 < 6) {
                maxNum = Math.max(maxNum, nums[right]);
                right++;
            } else {
                ansList.add(Math.max(maxNum, nums[right]));
                maxNum = Integer.MIN_VALUE;
                left++;
            }
        }
        return ansList;
    }
}
