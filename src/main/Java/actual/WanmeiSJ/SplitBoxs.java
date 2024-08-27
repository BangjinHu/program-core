package actual.WanmeiSJ;

import java.util.Scanner;

public class SplitBoxs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(splitMethod(m, n));
        }
    }

    private static int splitMethod(int m, int n){
        if (n == 1 || m == 0){
            return 1;
        }
        if (n > m){
            return splitMethod(m, m);
        }
        return splitMethod(m, n - 1) + splitMethod(m - n, n);
    }
}
