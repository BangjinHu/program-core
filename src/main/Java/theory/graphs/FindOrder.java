package theory.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {

    public static void main(String[] args) {

    }

    //课程表
    private static boolean canFinish(int[][] prerequesties, int courseNums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNums];
        for (int i = 0; i < courseNums; i++) {
            result.add(new ArrayList<>());
        }
        for (int[] request : prerequesties) {
            inDegree[request[0]]++;
            result.get(request[1]).add(request[0]);
        }

        for (int i = 0; i < courseNums; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int courseNum = queue.poll();
            courseNums--;
            List<Integer> list = result.get(courseNum);
            for (int cur : list) {
                if (--inDegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return courseNums == 0;


    }
}
