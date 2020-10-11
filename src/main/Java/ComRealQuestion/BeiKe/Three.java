package ComRealQuestion.BeiKe;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] kinds = new int[m][k];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < k; j++){
                kinds[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[n];//第i块板上的颜料种类数
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                dp[i] = dp[i-1] + m - kinds[i][j];
            }
        }
        System.out.println(dp[n-1]);
    }
}
