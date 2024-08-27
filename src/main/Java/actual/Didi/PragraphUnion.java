package actual.Didi;

import java.util.Scanner;

public class PragraphUnion {

    static int[] pre = new int[1010];
    static int[] size = new int[1010];

    public static void init(){
        for (int i = 1; i < 1000; i++){
            pre[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int x){
        return x == pre[x] ? x : (pre[x] = find(pre[x]));
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y){
            pre[x] = y;
            size[y] += size[x];
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) != 0){
            init();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int val = sc.nextInt();
                if (val <= k){
                    union(x, y);
                }
                if (size[find(1)] != n){
                    System.out.println("No");
                }else {
                    System.out.println("Yes");
                }
            }
        }
    }
}
