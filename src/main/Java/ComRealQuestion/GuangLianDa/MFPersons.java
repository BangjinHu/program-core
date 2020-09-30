package ComRealQuestion.GuangLianDa;

import java.util.Scanner;

/*public class MFPersons {

    static long[] arr = new long[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

            for (int i = 0; i < 4; i++){
                arr[i] = sc.nextLong();
            }
            long left = 0;
            long right = 0;
            for (int i = 0; i < 4; i++){
                right += arr[i];
            }
            while (left < right){
                long mid = left + (right - left) / 2;
                if (isRight(mid)){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            System.out.println(4 * (left - 1));
//            System.out.println(0);
        }

    }

    private static boolean isRight(long mid) {
        long p = 0, q = 0;
        for (int i = 0; i < 4; i++){
            if (arr[i] - mid >= 0){
                p += arr[i] - mid;
            }else {
                q += arr[i] - mid;
            }
        }
        return p + 2 * q >= 0;
    }
}*/

public class MFPersons {
    public static long f(long a,long b,long c,long d){
        long sum = a + b + c + d;
        long avl = sum / 4;
        for (long x = avl; x >= 0; x--) {
            long left = sum - 4 * x;
            long right = 0;
            if (x - a > 0) right += x - a;
            if (x - b > 0) right += x - b;
            if (x - c > 0) right += x - c;
            if (x - d > 0) right += x - d;
            if (left >= right) {
                return 4*x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        long a = Long.parseLong(s1[0]);
        long b = Long.parseLong(s1[1]);
        long c = Long.parseLong(s1[2]);
        long d = Long.parseLong(s1[3]);
        System.out.println(f(a,b,c,d));
    }
}