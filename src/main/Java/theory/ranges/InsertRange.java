package theory.ranges;

import java.util.ArrayList;
import java.util.List;

public class InsertRange {

    public static void main(String[] args) {

    }

    private static int[][] insertRange(int[][] originRange, int[] insertRange) {

        List<int[]> res = new ArrayList<>();
        int len = originRange.length;
        int start = 0;
        while (start < len && originRange[start][0] < insertRange[0]) {
            res.add(originRange[start]);
            start++;
        }

        while (start < len && originRange[start][0] <= insertRange[1]) {
            insertRange[0] = Math.min(originRange[start][0], insertRange[0]);
            insertRange[1] = Math.max(originRange[start][1], insertRange[1]);
            start++;
        }

        res.add(insertRange);

        while (start < len && originRange[start][0] > insertRange[1]) {
            res.add(originRange[start]);
            start++;
        }

        return res.toArray(new int[0][]);
    }
}
