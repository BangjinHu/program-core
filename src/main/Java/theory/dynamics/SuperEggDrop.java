package theory.dynamics;

import java.util.Arrays;
import java.util.Scanner;

public class SuperEggDrop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int K = sc.nextInt();
            System.out.println(superEggDrop(K, N));
        }
    }

    public static int superEggDrop(int K, int N){

        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++){
            Arrays.fill(dp[i], i);
        }
        for (int i = 0; i <= K; i++){
            dp[0][i] = 0;
        }
        dp[1][0] = 0;
        for (int i = 1; i <= K; i++){
            dp[1][i] = 1;
        }
        for (int i = 0; i <= N; i++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        //普通情况
        for (int i = 2; i <= N; i++){
            for (int m = 2; m <= K; m++){
                for (int n = 1; n <= i; n++){
                    dp[i][m] = Math.min(dp[i][m], Math.max(dp[n-1][m-1], dp[i-n][m]) + 1);
                }
            }
        }
        return dp[N][K];
    }
}
