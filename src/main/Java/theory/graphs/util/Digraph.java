package theory.graphs.util;

import java.util.HashSet;
import java.util.Set;

public class Digraph {

    private final int vertexsNum;
    private final int edgesNum;
    private int[][] arc;

    public Digraph(int vertexsNum, int[][] arc) {
        this.vertexsNum = vertexsNum;
        this.edgesNum = arc.length;
        arc = new int[vertexsNum][vertexsNum];
        for (int i = 0; i < vertexsNum; i++) {
            for (int j = 0; j < vertexsNum; j++) {
                arc[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < arc.length; i++) {
            int tail = arc[i][0];
            int head = arc[i][1];
            arc[tail][head] = 1;
        }
    }

    public static void main(String[] args) {
        int[][] arc = {
                {0, 3},
                {1, 0},
                {1, 2},
                {2, 0},
                {2, 1}
        };
        Digraph wd = new Digraph(4, arc);
        for (int i : wd.adj(1)) {
            System.out.println(i);
        }
    }

    //用于测试，返回一个顶点的邻接点
    public Iterable<Integer> adj(int vertex) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < vertexsNum; i++) {
            if (arc[vertex][i] != Integer.MAX_VALUE)
                set.add(i);
        }
        return set;
    }
}
