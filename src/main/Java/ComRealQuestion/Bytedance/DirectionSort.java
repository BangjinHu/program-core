package ComRealQuestion.Bytedance;

import java.util.Scanner;

public class DirectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(sortDirection(n, m));
        }
    }

    private static long sortDirection(long n, long m) {
        long ans = 1;
        while (m != 0){
            long count = getCountOfPre(ans, n);
            if (count >= m){
                m--;
                if (m == 0){
                    break;
                }
                ans *= 10;
            }else {
                m -= count;
                ans++;
            }
        }
        return ans;
    }

    private static long getCountOfPre(long pre, long n) {
        long count = 1;
        long p = 10;
        for (; pre * p <= n; p *= 10){
            if (pre * p - 1 + p < n){
                count += p;
            }else {
                count += n - pre * p + 1;
            }
        }
        return count;
    }
}
