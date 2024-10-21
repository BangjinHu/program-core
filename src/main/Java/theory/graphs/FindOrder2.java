package theory.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder2 {

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] res = findOrder2(prerequisites, numCourses);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    //课程表
    //int numCourses, int[][] prerequisites
    private static int[] findOrder2(int[][] prerequisites, int numCourses) {
        if (numCourses == 0) {
            return new int[0];
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result.add(new ArrayList<>());
        }
        for (int[] request : prerequisites) {
            inDegree[request[0]]++;
            result.get(request[1]).add(request[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int zeroInDegree = queue.poll();
            res[count++] = zeroInDegree;
            numCourses--;
            List<Integer> list = result.get(zeroInDegree);
            for (int cur : list) {
                if (--inDegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        if (count != res.length) {
            return new int[0];
        }
        return res;


    }
}
