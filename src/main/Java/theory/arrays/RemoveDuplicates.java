package theory.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 7, 7, 8, 9, 9, 9, 9, 9, 10};
        int result = removeDuplicates(nums);

        System.out.println(1 % 7);
        System.out.println(result);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
    }

    private static int removeDuplicates(int[] arr) {
        int i = 0;
        for (Integer num : arr) {
            if (i < 2 || num > arr[i - 2]) {
                arr[i++] = num;
            }
        }
        return i;
    }
}
