package theory.maths;

public class MaxPoints {

    public static void main(String[] args) {

    }

    private static int maxPoints(int[][] points) {

        // 斜率相等即认为是重叠
        int length = points.length, ans = 1;
        for (int i = 0; i < length; ++i) {
            int[] x = points[i];
            for (int j = i + 1; j < length; ++j) {
                int[] y = points[j];
                int cnt = 2;
                for (int k = j + 1; k < length; ++k) {
                    int[] p = points[k];
                    int result1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int result2 = (y[0] - x[0]) * (p[1] - y[1]);
                    if (result1 == result2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
