package actual.Baidu;

import java.util.Scanner;

public class GussNum {

    //猜数，2*x < y这时候是错误的，直接输出0；x<y时，ab根据x来变化；y<x时，ab根据y来变化，a最大为y，b起始0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long x = sc.nextLong();
            long y = sc.nextLong();
            if (x * 2 < y){
                System.out.println(0);
                return;
            }
            if (x < y){
                System.out.println((x - (y - x) + 1) / 2);
            }
            if (y <= x){
                System.out.println(y / 2);
            }
        }
    }
}
