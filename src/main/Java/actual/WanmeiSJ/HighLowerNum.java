package actual.WanmeiSJ;

import java.util.Scanner;

public class HighLowerNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arrA = new int[120];
            int[] arrB = new int[120];
            int indexA = 0;
            for (int i = 0; i < n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int k = 0; k < y; k++){
                    arrA[indexA++] = x;
                }
            }

            int indexB = 0;
            for (int i = 0; i < m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int k = 0; k < y; k++){
                    arrB[indexB++] = x;
                }
            }

            for (int i = 0; i < arrA.length; i++){
                System.out.print(arrA[i]);
            }
            System.out.println();
            for (int i = 0; i < arrB.length; i++){
                System.out.print(arrB[i]);
            }

            if(arrA == null || arrB == null){
                System.out.println(0);
            }
            int ans = 0;
            for (int i = 0; i < indexA; i++){
                for (int k = 0; k < indexB; k++){
                    if (arrA[i] > arrB[k]){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
