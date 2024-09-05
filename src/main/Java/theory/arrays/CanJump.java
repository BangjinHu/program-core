package theory.arrays;

public class CanJump {

    public static void main(String[] args) {
        //        int[] nums = new int[]{2, 3, 1, 1, 4};
        //[3,2,1,0,4]
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean result = canJump(nums);
        System.out.println("current nums can finish? " + result);
    }

    private static boolean canJump(int[] nums) {
        if (nums[0] >= nums.length) {
            return true;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] == 0) {
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (j + nums[j] > i) {
                        i = j;
                        break;
                    }
                }
                if (j < 0) {
                    return false;
                }
            } else {
                i--;
            }
        }
        return true;
    }
}
