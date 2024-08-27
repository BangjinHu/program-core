package actual.Baidu;

import java.util.Arrays;
import java.util.Scanner;

public class WFlowers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            long[][] rcols = new long[n][2];
            for (int i = 0; i < n; i++){
                String[] ps = sc.nextLine().split(" ");
                long x = Integer.parseInt(ps[0]);
                long y = Integer.parseInt(ps[1]);
                rcols[i][0] = ((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
                rcols[i][1] = ((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
            }
            Arrays.sort(rcols, (a, b) -> b[0] > a[0] ? 1 : -1);
            long ans = Long.MAX_VALUE, dTwo = 0;
            for (int i = 0; i < n; i++){
                ans = Math.min(ans, rcols[i][0] + dTwo);
                dTwo = Math.max(dTwo, rcols[i][1]);
            }
            System.out.println(Math.min(ans, dTwo));
        }
    }
}
