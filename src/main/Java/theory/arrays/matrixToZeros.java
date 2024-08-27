package theory.arrays;

public class matrixToZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setMatrixToZero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixToZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) { // 0列有0
                isCol = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {// 0行、0列都设置为0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;// 0行设置为0
            }
        }
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;// 0列设置为0
            }
        }
    }
}
