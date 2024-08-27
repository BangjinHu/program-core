package theory.ieees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo8 {

    public static void main(String[] args) {

        int row, i;
        Scanner in = new Scanner(System.in);
        row = in.nextInt();
        int[] a = new int[row];
        for (i = 0; i < row; i++){
            a[i] = in.nextInt();
        }
        int maxfac = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int[] tmp = new int[256];

        //输出一组数的最大公约数
        maxfac = Gcd(a[0], a[1]);
        map.put(maxfac, maxfac);
        for (i = 2; i < row; i++){
            tmp[i] = Gcd(a[i-1],a[i]);
            map.put(tmp[i], tmp[i]);
        }
        for (i = 0; i < row; i++){
            for (int j = 0; j < row; j++){
                if (Gcd(a[i], a[j]) != map.get(tmp[i])){
                    count++;
                }else {
                    continue;
                }
            }
        }
    }

    public static int Gcd(int a, int b){
        int temp;
        if (a < b){
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
