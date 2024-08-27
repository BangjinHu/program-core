package theory.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixMinPathValue {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(matrixMinPathValue(matrix));
    }

    public static int matrixMinPathValue(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] != 1 || matrix[matrix.length-1][matrix[0].length-1] != 1){
            return 0;
        }

        int result = 0;
        int[][] map = new int[matrix.length][matrix[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();

        rQ.add(0);
        cQ.add(0);

        int r = 0;
        int c = 0;

        while (!rQ.isEmpty()){
            r = rQ.poll();
            c = cQ.poll();

            if (r == matrix.length-1 && c == matrix[0].length-1){
                return map[r][c];
            }

            walkTo(map[r][c], r-1, c, matrix, map, rQ, cQ);
            walkTo(map[r][c], r+1, c, matrix, map, rQ, cQ);
            walkTo(map[r][c], r, c-1, matrix, map, rQ, cQ);
            walkTo(map[r][c], r, c+1, matrix, map, rQ, cQ);
        }
        return result;
    }

    public static void walkTo(int pre, int toR, int toC, int[][] matrix, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ){
        if (toR < 0 || toR == matrix.length || toC < 0 || toC == matrix[0].length || matrix[toR][toC] != 1 || map[toR][toC] != 0){
            return;
        }

        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);

    }
}
