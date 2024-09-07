package theory.backtraces;

public class WordExist {

    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int rows;
    private static int cols;
    private static boolean[][] visited;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println("current word could be search? " + wordExist(word, board));
    }

    private static boolean wordExist(String word, char[][] board) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTrace(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTrace(char[][] board, int row, int col, int index, String word) {

        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                // 注意方法顺序，一定要在前面2个方法满足条件的情况下再进行backTrace方法的判断
                if (legal(newRow, newCol) && !visited[newRow][newCol] && backTrace(board, newRow, newCol, index + 1, word)) {
                    return true;
                }
            }
            visited[row][col] = false;
        }
        return false;
    }

    private static boolean legal(int newRow, int newCol) {
        return newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
    }
}
