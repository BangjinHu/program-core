package actual.DuxiaoMan;

import java.util.Scanner;

public class ISLands {

    //海岛问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < m; k++){
                    grid[i][k] = sc.nextInt();
                }
            }

             if(grid == null || grid.length == 0){
                 System.out.println(0);
             }
             int nr = grid.length;
             int nc = grid[0].length;
             int num_islands = 0;
             for(int r = 0; r < nr; ++r){
                 for(int c = 0; c < nc; ++c){
                     if(grid[r][c] == 1){
                         ++num_islands;
                         DFS(grid, r, c);
                     }
                 }
             }
            System.out.println(num_islands);
        }
    }

    public static void DFS(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return;
        }
        //直到在该支路下遍历完所有的点，没有可以继续遍历的时候返回
        grid[r][c] = 0;
        DFS(grid, r-1, c);
        DFS(grid, r+1, c);
        DFS(grid, r, c-1);
        DFS(grid, r, c+1);
    }

    /*public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 1;
        int num = 0;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }
*/
    /*public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max (dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }
    static int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        return count;
    }*/


}
