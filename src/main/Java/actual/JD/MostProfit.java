package actual.JD;

import java.util.Scanner;

public class MostProfit {

    public static void main(String[] args) {

        //dp问题最简单的
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < n; k++){
                    arr[i][k] = sc.nextInt();
                }
            }
            int[][] dp = new int[n+1][n+1];
            dp[0][0] = arr[0][0];
            for (int i = 1; i < n; i++){
                dp[0][i] = dp[0][i-1] + arr[0][i];
            }
            for (int k = 1; k < n; k++){
                dp[k][0] = dp[k-1][0] + arr[k][0];
            }
            for (int i = 1; i < n; i++){
                for (int k = 1; k < n; k++){
                    dp[i][k] = Math.max(dp[i-1][k], dp[i][k-1]) + arr[i][k];
                }
            }
            System.out.println(dp[n-1][n-1]);
        }
    }
}
