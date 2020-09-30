package ComRealQuestion.JD;

import java.util.Scanner;

public class GWProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while ((t--) > 0){
                int n = sc.nextInt();
                int m = sc.nextInt();
                String[][] grid = new String[n][m];
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m; k++) {
                        grid[i][k] = sc.next();
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m; k++) {
                        System.out.println(grid[i][k]);
                    }
                }

                int[][] pos = new int[n][m];
                if (grid == null || grid.length == 0) {
                    System.out.println("NO");
                }
                int nr = grid.length;
                int nc = grid[0].length;
                int sr0 = 0, sc0 = 0, er0 = 0, ec0 = 0;
                //确定起始和终止位置
                for (int r = 0; r < nr; ++r) {
                    for (int c = 0; c < nc; ++c) {
                        if (grid[r][c].equals("S")) {
                            sr0 = r;
                            sc0 = c;
                        } else if (grid[r][c].equals("E")) {
                            er0 = r;
                            ec0 = c;
                        }
                    }
                }

                System.out.println(helper(sr0, sc0, er0, ec0, grid, n, m, pos));
            }
        }
    }

    public static boolean helper(int x1, int y1, int x2, int y2, String[][] chars, int n, int m, int[][] pos){

        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;
        boolean tmp = false;
        if (x1 == x2 && y1 == y2){
            return true;
        }
        pos[x1][y1] = 1;
        if (x1 == n-1){
            right = 0;
        }
        if (x1 == 0){
            left = 0;
        }
        if (y1 == m - 1){
            up = 0;
        }
        if (y1 == 0){
            down = 0;
        }
        if (right == 1){
            if (pos[x1 + 1][y1] != 1 && chars[x1+1][y1] != "#"){
                tmp = tmp || helper(x1+1, y1, x2, y2, chars, n, m, pos);
            }
        }
        if (left == 1){
            if (pos[x1 - 1][y1] != 1 && chars[x1-1][y1] != "#"){
                tmp = tmp || helper(x1-1, y1, x2, y2, chars, n, m, pos);
            }
        }
        if (up == 1){
            if (pos[x1][y1 + 1] != 1 && chars[x1][y1 + 1] != "#"){
                tmp = tmp || helper(x1, y1 + 1, x2, y2, chars, n, m, pos);
            }
        }
        if (down == 1){
            if (pos[x1][y1-1] != 1 && chars[x1][y1-1] != "#"){
                tmp = tmp || helper(x1, y1-1, x2, y2, chars, n, m, pos);
            }
        }
        return tmp;
    }
}
