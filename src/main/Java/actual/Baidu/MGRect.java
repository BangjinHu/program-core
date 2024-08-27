package actual.Baidu;

import java.util.Scanner;

public class MGRect {

    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            boolean[][] vis = new boolean[n][m];
            for (int i = 0; i < k; i++){
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                vis[x][y] = true;
            }
            double[][] dp = new double[n][m];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (vis[i][j]){
                        dp[i][j] = 0;
                    }else if (i == 0 && j == 0){

                    }else {
                        dp[i][j] = (j - 1 < 0 ? 0 : (i + 1 < n ? dp[i][j-1] * 0.5 : dp[i][j-1])) + (i - 1 < 0 ? 0 : (j + 1 < m ? dp[i-1][j] * 0.5 : dp[i-1][j]));
                    }
                }
            }
            System.out.println(String.format("%.2f", dp[n-1][m-1]));
        }
    }
}
