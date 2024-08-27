package theory.arrays;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates {

    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ansList = new ArrayList<>();
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            if (nums[Math.abs(nums[i]) - 1] < 0) {
//                ansList.add(Math.abs(nums[i]));
//            } else {
//                nums[Math.abs(nums[i]) - 1] *= -1;
//            }
//        }

        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                ansList.add(num);
            }
        }
        return ansList;
    }

}
