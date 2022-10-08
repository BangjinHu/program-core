package LeetCodeProblem.Array_Problem;

public class moveZeroIdx {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,0,2,0,5,4,0,6,7};
        int[] arr = moveZeroIdx(nums);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] moveZeroIdx(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] arr = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[idx++] = nums[i];
            }
        }
        while (idx < nums.length) {
            arr[idx++] = 0;
        }
        return arr;
    }
}
