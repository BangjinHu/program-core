package actual.QNar;

import java.util.Scanner;

public class SortUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] chars1 = new String[n];
            String[] chars2 = new String[n];
            for(int i = 0; i < n; i++){
                chars1[i] = sc.next();
            }
            for(int i = 0; i < n; i++){
                chars2[i] = sc.next();
            }
            int length = 0;
            int[][] dp = new int[chars1.length][chars2.length];
            for (int i = 0; i < chars1.length; i++){
                for (int k = 0; k < chars2.length; k++){
                    if (chars1[i].equals(chars2[k])){
                        if (i > 0 && k > 0){
                            dp[i][k] = dp[i-1][k-1] + 1;
                        }else {
                            dp[i][k] = 1;
                        }
                        if (dp[i][k] > length){
                            length = dp[i][k];
                        }
                    }else {
                        dp[i][k] = 0;
                    }
                }
            }
            System.out.println(length);
        }
    }
}