package theory.bfs;

import java.util.*;

public class MinMutation {

    public static void main(String[] args) {
        String start = "AAAAACCC", end = "AACCCCCC";
        String[] bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println("current start convert to end needs steps? -> " + minMutation(start, end, bank));
    }

    private static int minMutation(String start, String end, String[] bank) {

        Set<String> dupSet = new HashSet<String>();
        Collections.addAll(dupSet, bank);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();

        queue.add(start);
        visited.add(start);

        int step = 0;
        char[] directions = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return step;
                }
                for (char c : directions) {
                    char[] chars = curr.toCharArray();
                    for (int k = 0; k < chars.length; k++) {
                        char old = chars[k];
                        chars[k] = c;
                        String tmp = String.valueOf(chars);
                        if (dupSet.contains(tmp) && !visited.contains(tmp)) {
                            queue.add(tmp);
                            visited.add(tmp);
                        }
                        chars[k] = old;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
