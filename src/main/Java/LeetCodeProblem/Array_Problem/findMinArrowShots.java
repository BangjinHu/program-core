package LeetCodeProblem.Array_Problem;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {

        int ans = 1;
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int left = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (left < points[i][0]) {
                ans++;
                left = points[i][1];
            } else {
                left = Math.min(points[i][1], left);
            }
        }
        return ans;
    }
}
