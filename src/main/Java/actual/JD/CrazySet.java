package actual.JD;

import java.util.Scanner;

public class CrazySet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int i;
            for (i = 0; n > 0; i++){
                n -= i;
            }
            System.out.println(i - 1);
        }
    }
}