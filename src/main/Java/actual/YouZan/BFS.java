package actual.YouZan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static final int[] directionX = new int[]{0, 1, 0, -1};
    public static final int[] directionY = new int[]{1, 0, -1, 0};
    public static final int[] horseMoveX = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    public static final int[] horseMoveY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(findBFS(board));
    }

    private static int findBFS(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0, true));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.x == m - 1 && curr.y == n - 1) {
                return curr.steps;
            }
            if (curr.type) {
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + directionX[i];
                    int ny = curr.y + directionY[i];
                    if (isInBounds(nx, ny, m, n) && board[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new State(nx, ny, curr.steps + 1, true));
                    }
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    int nx = curr.x + horseMoveX[i];
                    int ny = curr.y + horseMoveY[i];
                    if (isInBounds(nx, ny, m, n) && board[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new State(nx, ny, curr.steps + 1, false));
                    }
                }
            }

            if (!visited[curr.x][curr.y] && board[curr.x][curr.y] != 'X') {
                visited[curr.x][curr.y] = true;
                queue.offer(new State(curr.x, curr.y, curr.steps + 1, !curr.type));
            }
        }
        return -1;
    }

    private static boolean isInBounds(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class State {
        int x, y;
        int steps;
        boolean type;

        public State(int x, int y, int steps, boolean type) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.type = type;
        }
    }
}
