package theory.bfs;

import java.util.*;

public class MinDNAStep {

    public static void main(String[] args) {

    }

    private static int minDNAStep(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);

        Queue<String> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();

        char[] directions = new char[]{'A', 'C', 'G', 'T'};

        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return step;
                }
                char[] chars = curr.toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    for (char d : directions) {
                        char t = chars[k];
                        chars[k] = d;
                        String replace = String.valueOf(chars);
                        if (!visitedSet.contains(replace) && bankSet.contains(replace)) {
                            queue.add(replace);
                            visitedSet.add(replace);
                        }
                        chars[k] = t;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
