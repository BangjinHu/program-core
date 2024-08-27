package theory.arrays;

import java.util.Scanner;

public class RestartFunc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(restart(n));
        }
    }

    public static int restart(int n){
        for (int i = 0; i < n; i++){
            //执行的函数
            System.out.println(i);
        }
        return 0;
    }
}
