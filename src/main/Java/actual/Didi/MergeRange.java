package actual.Didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeRange {

    public static void main(String[] args) {

    }

    private static int[][] mergeRange(int[][] origins) {
        if (origins == null || origins.length <= 1) {
            return origins;
        }
        Arrays.sort(origins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = 0;
        List<int[]> ansList = new ArrayList<>();
        while (start < origins.length) {
            int left = origins[start][0];
            int right = origins[start][1];
            while (start < origins.length - 1 && right >= origins[start + 1][0]) {
                right = Math.max(right, origins[start + 1][1]);
                start++;
            }
            ansList.add(new int[]{left, right});
            start++;
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
