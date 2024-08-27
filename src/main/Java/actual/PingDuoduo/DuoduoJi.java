package actual.PingDuoduo;

import java.util.Scanner;

public class DuoduoJi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[][] chars = new String[n][m];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < m; k++){
                    chars[i][k] = sc.next();
                }
            }



        }
    }
}
