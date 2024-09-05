package theory.arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ans = productExceptSelf(nums);
        System.out.println("product except self: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    private static int[] productExceptSelf(int[] arr) {
        int left = 1, right = 1;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = left;
            left *= arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= arr[i];
        }
        return ans;
    }
}
