package theory.arrays;

public class MaxSquare {

    public static void main(String[] args) {

    }

    private int maxSquare(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        if (rows == 0 || cols == 0) return 0;
        if (rows == 1 || cols == 1) return matrix[rows - 1][cols - 1];
        int max = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
