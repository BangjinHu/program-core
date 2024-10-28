package theory.backtraces;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationK {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> ansList = combK(n, k);
        for (List<Integer> list : ansList) {
            list.stream().forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static List<List<Integer>> combK(int n, int k) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (n < k) {
            return ansList;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        dfs(n, k, 1, queue, ansList);
        return ansList;
    }

    private static void dfs(int n, int k, int start, Deque<Integer> queue, List<List<Integer>> ansList) {
        if (queue.size() == k) {
            ansList.add(new ArrayList<>(queue));
            return;
        }
        for (int i = start; i <= n - (k - queue.size()) + 1; i++) {
            queue.addLast(i);
            dfs(n, k, i + 1, queue, ansList);
            queue.removeLast();
        }
    }

}
