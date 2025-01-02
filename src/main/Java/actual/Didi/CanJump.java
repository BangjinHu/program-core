package actual.Didi;

public class CanJump {

    public static void main(String[] args) {

    }

    private static boolean canJump(int[] nums) {
        if (nums[0] >= nums.length - 1) {
            return true;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] == 0) {
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (nums[j] + j >= i) {
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
