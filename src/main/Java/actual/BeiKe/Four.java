package actual.BeiKe;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] downs = new int[2 * n];
        int[] ups = new int[2 * n];
        for(int i = 0; i < 2 * n; i++){
            downs[i] = sc.nextInt();
        }
        for(int i = 0; i < 2 * n; i++){
            ups[i] = sc.nextInt();
        }
        int length = 2 * n;
        int ans = 1;
        while(length > 0){
            int index = n -1, start = 1;
            for(int i = index; i >= 0; i--){
                ans += downs[i] - ups[i];
                length--;
            }
            for(int i = index + 1; i < 2 * n; i++){
                ans += downs[i] - ups[i];
                length--;
            }
        }
        System.out.println(ans);
    }
}
