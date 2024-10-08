package theory.graphs.util;

import java.util.HashSet;
import java.util.Set;

public class AdjListDigraph {
    private final VertexNode[] vertexs;
    private final int vertexsNum;
    private final int edgesNum;
    public AdjListDigraph(int[][] data, int vertexsNum) {
        this.vertexsNum = vertexsNum;
        this.edgesNum = data.length;
        vertexs = new VertexNode[vertexsNum];
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new VertexNode();
            vertexs[i].id = i;
        }

        for (int i = 0; i < data.length; i++) {
            int index = data[i][1];
            EdgeNode next = vertexs[data[i][0]].headNode;
            EdgeNode eNode = new EdgeNode(index, next);
            vertexs[data[i][0]].headNode = eNode; //头插法
        }

    }

    public static void main(String[] args) {
        int[][] data = {
                {0, 3},
                {1, 0},
                {1, 2},
                {2, 0},
                {2, 1},
        };
        AdjListDigraph ald = new AdjListDigraph(data, 4);
        for (int i : ald.adj(1)) {
            System.out.println(i);
        }
    }

    //用于测试，返回一个顶点的邻接点
    public Iterable<Integer> adj(int index) {
        Set<Integer> set = new HashSet<>();
        EdgeNode current = vertexs[index].headNode;
        while (current != null) {
            VertexNode node = vertexs[current.index];
            set.add(node.id);
            current = current.next;
        }
        return set;
    }

    private class EdgeNode {
        int index;
        EdgeNode next;

        EdgeNode(int index, EdgeNode next) {
            this.index = index;
            this.next = next;
        }
    }

    private class VertexNode {
        int id;
        EdgeNode headNode;
    }
}
