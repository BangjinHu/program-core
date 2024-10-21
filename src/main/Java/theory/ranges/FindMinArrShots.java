package theory.ranges;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrShots {

    public static void main(String[] args) {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = findMinArrShots(points);
        System.out.println("current ranges min shots is : " + res);
    }

    private static int findMinArrShots(int[][] arr) {
        int ans = 1;
        if (arr.length == 1) {
            return ans;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int left = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (left < arr[i][0]) {
                ans++;
                left = arr[i][1];
            } else {
                left = Math.min(left, arr[i][1]);
            }
        }
        return ans;
    }
}
