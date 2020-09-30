package ComRealQuestion.JD;

import java.util.Scanner;

public class LuckNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++){
                if (calc2Num(i) == calc10Num(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static int calc2Num(int m) {
        int sum = 0;
        while (m > 0){
            sum += m & 1;
            m >>= 1;
        }
        return sum;
    }

    private static int calc10Num(int n) {
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
