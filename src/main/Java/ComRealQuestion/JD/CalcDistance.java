package ComRealQuestion.JD;

import java.util.Scanner;

public class CalcDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt(), y = sc.nextInt(),
                    m = sc.nextInt(), n = sc.nextInt();
            System.out.println(calcDistance(x, y, m, n));
        }
    }

    public static int calcDistance(int A, int B, int C, int D) {
        return (int)(calcDis(A) + calcDis(B) + calcDis(C) + calcDis(D));
    }

    private static double calcDis(double n){
        if(n == 0){
            return 0;
        }
        return n + n / 2 + calcDis(n / 2);
    }
}
