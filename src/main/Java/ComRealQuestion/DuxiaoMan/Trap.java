package ComRealQuestion.DuxiaoMan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Trap {

    private static char[][] matrix = new char[110][110];
    private static int n;
    private static int k;
    private static int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited = new boolean[110][110];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++){
            String str = sc.next();
            for (int j = 1; j <= n; j++){
                matrix[i][j] = str.charAt(j - 1);
            }
        }
        int val = bfs();
        if (val == -1){
            System.out.println("No solution");
        }else {
            System.out.println(val);
        }
    }

    private static int bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 1, 0));
        visited[1][1] = true;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.x == n && cur.y == n){
                return cur.time;
            }
            for (int i = 0; i < 4; i++){
                int tmpX = cur.x + direction[i][0];
                int tmpY = cur.y + direction[i][1];
                if(tmpX >= 1 && tmpX <= n && tmpY >= 1 && tmpY <= n && matrix[tmpX][tmpY] != '1' && !visited[tmpX][tmpY]){
                    if(matrix[tmpX][tmpY] == '0'){
                        queue.add(new Node(tmpX, tmpY, cur.time + 1));
                        visited[tmpX][tmpY] = true;
                    } else if(matrix[tmpX][tmpY] == '#'){
                        queue.add(new Node(tmpX, tmpY, cur.time + k + 1));
                        visited[tmpX][tmpY] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static class Node implements Comparable {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
            return this.time - ((Node)o).time;
        }
    }
}
