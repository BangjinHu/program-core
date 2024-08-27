package actual.PingDuoduo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxAbilitys {

    //迷宫问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int K = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] us = new int[n-1];
            int[] vs = new int[n-1];
            for (int i = 0; i < n - 1; i++){
                us[i] = sc.nextInt();
                vs[i] = sc.nextInt();
            }
            Map<Integer, Integer> uvMap = new HashMap<>();
            for (int i = 0; i < n - 1; i++){
                uvMap.put(us[i], vs[i]);
            }
            int[][] dp = new int[k+1][n+1];
            dp[0][0] = arr[0];
            ArrayList<Integer> uvList = new ArrayList<>();
            for (int m = 1; m < k; m++){
                for (int i = 1; i < n; i++){
                    if (uvMap.get(arr[i]) != null){
                        uvList.add(arr[i]);
                        uvList.add(uvMap.get(arr[i]));
                    }
                    if (!uvList.contains(arr[i])){
                        dp[m][i] = Math.max(dp[m][i-1], dp[m][i-1] + arr[i]);
                    }
                }
            }
            System.out.println(dp[k-1][n-1]);
        }
    }
}
