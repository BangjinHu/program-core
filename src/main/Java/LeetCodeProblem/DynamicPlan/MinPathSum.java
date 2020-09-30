package LeetCodeProblem.DynamicPlan;

public class MinPathSum {

    /**
     * 方法1
     * @param matrix
     * @return
     */
    public int minPathSumOne(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++){
            //第1列
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for (int j = 1; j < col; j++){
            //第1行
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        //最终的最短路径和
        return dp[row-1][col-1];
    }

    /**
     * 方法2
     * @param matrix
     * @return
     */
    public int minPathSumTwo(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        int more = Math.max(matrix.length, matrix[0].length);
        int less = Math.min(matrix.length, matrix[0].length);
        boolean rowmore = more == matrix.length;
        int[] arr = new int[less];
        arr[0] = matrix[0][0];
        for (int i = 1; i < less; i++){
            arr[i] = arr[i-1] + (rowmore ? matrix[0][i] : matrix[i][0]);
        }

        for (int i = 1; i < more; i++){
            arr[0] = arr[0] + (rowmore ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < less; j++){
                arr[j] = Math.min(arr[j-1], arr[j]) + (rowmore ? matrix[i][j] : matrix[j][i]);
            }
        }
        return arr[less-1];
    }
}
