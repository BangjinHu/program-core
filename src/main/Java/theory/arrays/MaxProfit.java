package theory.arrays;

public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int min = arr[0], max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return max;
    }
}
