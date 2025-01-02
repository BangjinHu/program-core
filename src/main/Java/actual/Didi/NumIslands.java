package actual.Didi;

public class NumIslands {

    public static void main(String[] args) {

    }

    private static int numsIslands(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] matrix, int row, int col) {
        int rows = matrix.length, cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        matrix[row][col] = '0';
        dfs(matrix, row - 1, col);
        dfs(matrix, row + 1, col);
        dfs(matrix, row, col - 1);
        dfs(matrix, row, col + 1);
    }
}
