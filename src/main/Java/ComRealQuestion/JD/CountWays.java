package ComRealQuestion.JD;

import java.util.Scanner;

public class CountWays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(countWays(n));
        }
    }

    public static int countWays(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if(n > 2){
            for(int i = 3; i < n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }
        }
        return dp[n-1];
    }
}
