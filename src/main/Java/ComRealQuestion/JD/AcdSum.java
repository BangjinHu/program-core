package ComRealQuestion.JD;

import java.util.Scanner;

public class AcdSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            calcNum(n);
        }
    }

    private static void calcNum(int n) {
        int sum = 0, kind = n - 2;
        for (int i = 2; i < n; i++){
            sum += calcDNum(n, i);//求1-n-1之间的进制位之和
        }
        int ans = calcD2Num(sum, kind);
        System.out.println(sum / ans + "/" + kind / ans);
    }

    private static int calcDNum(int n, int m) {
        while (n % m != 0){
            int y = n % m;
            n = m;
            m = y;
        }
        return m;
    }

    private static int calcD2Num(int n, int x) {
        int ans = 0;
        while (n != 0){
            ans += n % x;
            n /= x;
        }
        return ans;
    }
}
