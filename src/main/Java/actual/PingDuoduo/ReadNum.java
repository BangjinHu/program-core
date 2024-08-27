package actual.PingDuoduo;

import java.util.Scanner;

public class ReadNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] strs = {"4444444",
                    "2322224",
                    "4622226",
                    "4424244",
                    "2344722",
                    "2625244",
                    "4225444",
                    "6622222",
                    "4444444",
                    "4445224"};
            int t = sc.nextInt();
            for (int i = 0; i < t; i++){
                int n = sc.nextInt();
                boolean[][] arr = new boolean[n][n];
                int[] sumOne = new int[n];
                for (int k = 0; k < n; k++){
                    int tmp = 0;
                    for (int left = 0; left < n; left++){
                        int tmp2 = sc.nextInt();
                        if (tmp2 == 1){
                            arr[k][left] = true;
                            tmp++;
                        }else {
                            arr[k][left] = false;
                        }
                    }
                    sumOne[k] = tmp;
                }
                int d = n / 10;
                StringBuilder sb = new StringBuilder();
                for (int k = d; k < n - 2 * d; k += d){
                    sb.append(sumOne[k] / d);
                }
                for (int m = 0; m < 10; m++){
                    if (isEqual(sb.toString(), strs[m])){
                        if (m == 0 || m == 8){
                            if (arr[n / 2 - 1][n / 2] == true){
                                System.out.println(8);
                                break;
                            }else {
                                System.out.println(0);
                                break;
                            }
                        }else {
                            System.out.println(m);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isEqual(String s, String str) {
        for (int i = 0; i < s.length() - 1; i++){
            if ((s.charAt(i+1) - s.charAt(i))
                    != (str.charAt(i+1) - str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
