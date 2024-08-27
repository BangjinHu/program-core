package actual.JD;

import java.util.Scanner;

public class QueueKing {
    //海岛问题
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
                int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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
                grid[sr0][sc0] = "#";
                boolean ans = dfs(sr0, sc0, er0, ec0, grid, dir);
                if (ans==true){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static boolean dfs(int sr, int sc, int er, int ec, String[][] grid, int[][] dir){
        if (sr == er && sc == ec){
            return true;
        }
        int i;
        for (i = 0; i < 4; i++){
            int ti = sr + dir[i][0];
            int tj = sc + dir[i][1];
            if (check(ti, tj, er, ec) == false){
                continue;
            }
            if (grid[ti][tj] != "#"){
                grid[ti][tj] = "#";
                boolean flag = dfs(ti, tj, er, ec, grid, dir);
                if (flag == true){
                    return true;
                }
                grid[ti][tj] = ".";
            }
        }
        return false;
    }

    public static boolean check(int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}
