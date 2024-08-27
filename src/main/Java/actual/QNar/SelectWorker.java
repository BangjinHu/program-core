package actual.QNar;

import java.util.Scanner;

public class SelectWorker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int upSum = 1, downSum = 1;
            for (int i = m; i > m - n; i--){
                upSum *= i;
            }
            for (int i = 1; i <= n; i++){
                downSum *= i;
            }
            System.out.println(upSum/downSum);
        }
    }
}
