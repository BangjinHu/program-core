package theory.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinishCourses {

    public static void main(String[] args) {
//        int numCourses = 9;
//        int[][] prerequisites = new int[][]{{1, 0}, {2, 1}, {3, 1}, {5, 2}, {6, 3}, {7, 5}, {6, 5}, {8, 7}, {7, 6}};

        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println("current course can finish? " + canFinish(numCourses, prerequisites));
        System.out.println("===============================");
        int[] result = canFinish2(numCourses, prerequisites);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " -> ");
        }
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> outDegreeList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            outDegreeList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;//入度
            outDegreeList.get(pre[1]).add(pre[0]);//出度
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : outDegreeList.get(pre)) {
                if (--inDegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    private static int[] canFinish2(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> outDegreeList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            outDegreeList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;//入度
            outDegreeList.get(pre[1]).add(pre[0]);//出度
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] visited = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            visited[count++] = pre;
            numCourses--;
            for (int cur : outDegreeList.get(pre)) {
                if (cur == pre) {
                    if (--inDegree[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
        }
        return count == numCourses ? visited : new int[0];
    }
}
