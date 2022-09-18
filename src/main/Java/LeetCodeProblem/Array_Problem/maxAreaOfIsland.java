package LeetCodeProblem.Array_Problem;

public class maxAreaOfIsland {

    public static void main(String[] args) {

    }

    public int maxArea(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    max = Math.max(dfs(matrix, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0 || row > matrix.length || row < 0 || col > matrix[0].length || col < 0) {
            return 0;
        }
        matrix[row][col] = 0;
        int count = 1;
        count += dfs(matrix, row - 1, col);
        count += dfs(matrix, row + 1, col);
        count += dfs(matrix, row, col - 1);
        count += dfs(matrix, row, col + 1);
        return count;
    }
}
