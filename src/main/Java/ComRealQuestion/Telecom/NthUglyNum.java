package ComRealQuestion.Telecom;

import java.util.Scanner;

public class NthUglyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int i2 = 0, i3 = 0, i5 = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++){
                int num2 = dp[i2] * 2;
                int num3 = dp[i3] * 3;
                int num5 = dp[i5] * 5;
                dp[i] = Math.min(Math.min(num2, num3), num5);
                if (dp[i] == num2){
                    i2++;
                }
                if (dp[i] == num3){
                    i3++;
                }
                if (dp[i] == num5){
                    i5++;
                }
            }
            System.out.println(dp[n-1]);
        }
    }
}

