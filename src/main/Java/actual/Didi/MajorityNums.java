package actual.Didi;

public class MajorityNums {

    public static void main(String[] args) {

    }

    private static int majorityNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
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
