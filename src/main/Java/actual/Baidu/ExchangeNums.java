package actual.Baidu;

import java.util.Scanner;

public class ExchangeNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int k = sc.nextInt();
            int count = 0;
            if (minSwapNum(str1, str2) == k){
                count++;
            }
            System.out.println(count);
        }
    }

    public static int minSwapNum(String str1, String str2){
        int len = str1.length(), m = 0, n = 0;
        for (int i = 0; i < len; i++){
            if (str1.charAt(i) == str2.charAt(i)){
                continue;
            }else if (str1.charAt(i) == 120){
                m++;
            }else {
                n++;
            }
        }
        return ((m + n) & 1) == 1 ? -1 : (m + 1) / 2 + (n + 1) / 2;
    }
}
