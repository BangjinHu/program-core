package theory.arrays;

public class RotateMatrix1 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int sr = 0, sc = 0;
        int er = matrix.length, ec = matrix[0].length;
        while (sr < er) {
            rotate(matrix, sr++, er--, sc++, ec--);
        }
    }

    public static void rotate(int[][] matrix, int sr, int er, int sc, int ec) {
        int rows = er - sr;
        int swpNum = 0;
        for (int i = 0; i < rows; i++) {
            swpNum = matrix[sr][sc + i];
            matrix[sr][sc + i] = matrix[sr + i][sc];
            matrix[sr + i][sc] = matrix[er][ec - i];
            matrix[er][ec - i] = swpNum;
        }
    }
}
