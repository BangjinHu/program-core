package ComRealQuestion.Baidu;

import java.util.Scanner;

public class DoublePrimeNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int k = sc.nextInt();
            int i = 13, count = 0;
            while (true){
                if(isPrimeNum(i) && isPrimeNum(reverse(i)) && i != reverse(i)){
                    count++;
                }
                if(count == k){
                    System.out.println(i);
                    break;
                }
                i += 2;//不可能是个偶数
            }
        }
    }

    public static boolean isPrimeNum(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int reverse(int n){
        int ans = 0;
        while(n > 0){
            ans *= 10;
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}