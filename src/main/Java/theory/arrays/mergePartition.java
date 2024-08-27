package theory.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergePartition {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        List<int[]> ansList = new ArrayList<>();
        // 升序排列数组
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int start = 0;
        while (start < arr.length) {
            int left = arr[start][0];
            int right = arr[start][1];
            while (start < arr.length - 1 && right >= arr[start + 1][0]) {
                right = Math.max(right, arr[start + 1][1]);
                start++;
            }
            ansList.add(new int[]{left, right});
            start++;
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }
}
