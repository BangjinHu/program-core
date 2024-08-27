package theory.Array_Problem;

public class rotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        int tr = 0, dr = matrix.length - 1;
        int tc = 0, dc = matrix[0].length - 1;
        while (tr < dr) {
            rotateEdge(matrix, tr++, tc++, dr--, dc--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        int tm = dr - tr;
        int swp = 0;
        for (int i = 0; i != tm; i++) {
            swp = matrix[tr][tc + i];
            matrix[tr][tc + i] = matrix[dr - i][tc];
            matrix[dr - i][tc] = matrix[dr][dc - i];
            matrix[dr][dc - i] = matrix[tr + i][dc];
            matrix[tr + i][dc] = swp;
        }
    }

}
