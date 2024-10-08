package actual.PingDuoduo;

import java.util.Scanner;

public class BuildRoad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int max = 0x3f3f3f3f;
            int[][] dp = new int[n+1][m+1];
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= m; j++){
                    if (i == j){
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = max;
                    for (int k = 1; k < i; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i-k][j]);
                    }
                    for (int k = 1; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j-k]);
                    }
                    for (int left = 1; left <= Math.min(i, j); left++){
                        for (int k = 1; k <= left; k++){
                            if (left - k <= 0 || j - left <= 0
                                    || i - left + k <= 0 || j - left - k <= 0){
                                continue;
                            }
                            dp[i][j] = Math.min(dp[i][j],
                                    dp[left-k][j-left]
                                            + dp[i-left+k][j-left-k] + dp[i-left][left+k] + 2);
                        }
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
