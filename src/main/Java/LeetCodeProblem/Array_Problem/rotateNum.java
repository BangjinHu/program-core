package LeetCodeProblem.Array_Problem;

public class rotateNum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotateNums(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotateNums(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
//        int[] res = new int[nums.length];
//        int idx = 0;
//        for (int i = nums.length - k - 1; i < nums.length - 1; i++) {
//            res[idx++] = nums[i];
//        }
//        for (int i = 0; i < nums.length - k - 1; i++) {
//            res[idx++] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = res[i];
//        }

        int[] nNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nNums[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nNums.length; i++) {
            nums[i] = nNums[i];
        }
    }
}
