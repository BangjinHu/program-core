package ComRealQuestion.Baidu;

import java.util.Scanner;

public class ScanGrid {

    //裁剪网格
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            /*int[][] grid = new int[n][2];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < 2; k++){
                    grid[i][k] = sc.nextInt();
                }
            }*/
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
            int side = Math.max((maxX - minX), (maxY - minY));
            System.out.println(side * side);
        }
    }
}
