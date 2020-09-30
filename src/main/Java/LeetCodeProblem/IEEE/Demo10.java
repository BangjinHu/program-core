package LeetCodeProblem.IEEE;

import java.util.Scanner;

public class Demo10 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        //in 激活的蜂巢
        int[][] arr_cell = new int[N][M];
        for (int i = 0; i < Math.max(M, N); i++){
            for (int j = 0; j < Math.max(M, N); j++){
                arr_cell[i][j] = in.nextInt();
            }

        }

        //in 蜂王的访问
        int O = in.nextInt();
        String[][] arr_sec = new String[O][3];
        for (int m = 0; m < O; m++){
            for (int n = 0; n < 3; n++){
                arr_sec[m][n] = in.next();
            }
        }

        int result = 0;
        for (int x = 0; x < O; x++){
            if (arr_sec[x].equals("a")){
                //激活蜂巢
                arr_cell[Integer.parseInt(arr_sec[x][1])][Integer.parseInt(arr_sec[x][2])] = 1;
            }else if (arr_sec[x].equals("k")){
                //获取与该cell相连的值
                if (arr_cell[Integer.parseInt(arr_sec[x][1])][Integer.parseInt(arr_sec[x][2])] == 0){//未激活
                    result = 0;
                }else {
                    // 遍历相邻的六边形的周长
                    // 判断相邻激活否
                    int count = result_meth(arr_cell);

                    int pos_row = Integer.parseInt(arr_sec[x][1]);
                    int pos_col = Integer.parseInt(arr_sec[x][2]);
                    if (arr_cell[pos_row - 1][pos_col] == 1
                            && arr_cell[pos_row][pos_col - 1] == 1
                            && arr_cell[pos_row + 1][pos_col] == 1
                            && arr_cell[pos_row][pos_col+1] == 1
                            && pos_col + 1 < M
                            && pos_row < N){
                        result = count * 3;
                        System.out.println(result);
                    }else if (arr_cell[pos_row - 1][pos_col] == 0
                            && arr_cell[pos_row][pos_col - 1] == 1
                            && arr_cell[pos_row + 1][pos_col] == 1
                            && arr_cell[pos_row][pos_col+1] == 1
                            && pos_col + 1 < M
                            && pos_row < N){
                        result = count * 3;
                        System.out.println(result);
                    }else if (arr_cell[pos_row - 1][pos_col] == 0
                            && arr_cell[pos_row][pos_col - 1] == 0
                            && arr_cell[pos_row + 1][pos_col] == 1
                            && arr_cell[pos_row][pos_col+1] == 1
                            && pos_col + 1 < M
                            && pos_row < N){
                        result = count * 3;
                    }else if (arr_cell[pos_row - 1][pos_col] == 0
                            && arr_cell[pos_row][pos_col - 1] == 0
                            && arr_cell[pos_row + 1][pos_col] == 0
                            && arr_cell[pos_row][pos_col+1] == 1
                            && pos_col + 1 < M
                            && pos_row < N){
                        result = count * 3;
                    }
                }
            }
        }
    }

    //DFS
    private static int result_meth(int[][] arr_cell){
         if(arr_cell == null || arr_cell.length == 0){
             return 0;
         }
         int nr = arr_cell.length;
         int nc = arr_cell[0].length;
         int count = 0;

         for(int r = 0; r < nr; ++r){
             for(int c = 0; c < nc; ++c){
                 if(arr_cell[r][c] == '1'){
                     ++count;
                     dfs(arr_cell, r, c);
                 }
             }
         }
         //返回相连的六边形的数量
        return count;
    }

    private static void dfs(int[][] arr_cell, int r, int c){
        int nr = arr_cell.length;
        int nc = arr_cell[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || arr_cell[r][c] == '0') {
            return;
        }
        arr_cell[r][c] = '0';
        dfs(arr_cell, r-1, c);
        dfs(arr_cell, r+1, c);
        dfs(arr_cell, r, c-1);
        dfs(arr_cell, r, c+1);
    }



}
