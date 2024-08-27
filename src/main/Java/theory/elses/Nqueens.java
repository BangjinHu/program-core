package theory.elses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {

    public static void main(String[] args) {

    }

    public List<List<String>> nQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<String>> ansList = new ArrayList<>();
        char[][] chars = new char[n][n];
        Arrays.fill(chars, '.');
        dfs(chars, 0, n, ansList);
        return ansList;
    }

    private void dfs(char[][] chars, int row, int n, List<List<String>> ansList) {
        if (row == n) {
            List<String> charList = new ArrayList<>();
            for (char[] path : chars) {
                charList.add(String.valueOf(path));
            }
            ansList.add(charList);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 同一行、列、对角线不能有冲突
            if (!isValid(chars, row, i)) {
                continue;
            }
            // 回溯
            chars[row][i] = 'Q';
            dfs(chars, row + 1, n, ansList);
            chars[row][i] = '.';
        }
    }

    private boolean isValid(char[][] chars, int row, int col) {

        // 左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        // 右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < chars[0].length; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        // 同一列
        for (int i = row - 1; i >= 0; i--) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
