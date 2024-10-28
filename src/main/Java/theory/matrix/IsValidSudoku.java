package theory.matrix;

import java.util.HashMap;

public class IsValidSudoku {

    public static void main(String[] args) {

        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        boolean isValid = isValidSudoku(board);
        System.out.println("current board is valid sudoku? " + isValid);
    }

    private static boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Integer>[] rowsMap = new HashMap[9];
        HashMap<Integer, Integer>[] colsMap = new HashMap[9];
        HashMap<Integer, Integer>[] boxsMap = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rowsMap[i] = new HashMap<>();
            colsMap[i] = new HashMap<>();
            boxsMap[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c;
                    int box_index = (i / 3) * 3 + j / 3;
                    rowsMap[i].put(n, rowsMap[i].getOrDefault(n, 0) + 1);
                    colsMap[j].put(n, colsMap[j].getOrDefault(n, 0) + 1);
                    boxsMap[box_index].put(n, boxsMap[box_index].getOrDefault(n, 0) + 1);

                    if (rowsMap[i].get(n) > 1 || colsMap[j].get(n) > 1 || boxsMap[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
