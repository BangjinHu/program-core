package LeetCodeProblem.Array_Problem;

public class uniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        int n = uniquePathsWithObstacles(matrix);
        System.out.println(n);
    }

    public static int uniquePathsWithObstacles(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(matrix[i][j] == 1){
//                    dp[i][j] = 0;
//                }else{
//                    if (i == 0 && j == 0) {
//                        dp[i][j] = 0;
//                    } else if (i == 0) {
//                        dp[i][j] = dp[i][j-1];
//                    } else if (j == 0) {
//                        dp[i][j] = dp[i-1][j];
//                    } else {
//                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                    }
//                }
//            }
//        }
//        //最后返回左下方终止点位置的路径数
//        return dp[m][n];

        int[] dp = new int[m];

        dp[0] = matrix[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }
}
