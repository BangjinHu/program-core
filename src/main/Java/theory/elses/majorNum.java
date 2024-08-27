package theory.elses;

public class majorNum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorNum(nums));
    }

    public static int majorNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}
