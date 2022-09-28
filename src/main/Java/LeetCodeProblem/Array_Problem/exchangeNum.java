package LeetCodeProblem.Array_Problem;

public class exchangeNum {

    public static void main(String[] args) {

    }

    public int[] exchageNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int low = 0, high = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[high--] = nums[i];
            } else {
                res[low++] = nums[i];
            }
        }
        return res;
    }
}
