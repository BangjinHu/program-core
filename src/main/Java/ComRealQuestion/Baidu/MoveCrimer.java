package ComRealQuestion.Baidu;

import java.util.Scanner;

public class MoveCrimer {

    //转移罪犯
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int t = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            int count = 0;
            int tmp = 0;
            for (int i = 0; i < c; i++){
                tmp += arr[i];
            }
            if (tmp <= t){
                count++;
            }
            for (int i = c; i < arr.length; i++){
                tmp += arr[i] - arr[i-c];
                if (tmp <= t){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
