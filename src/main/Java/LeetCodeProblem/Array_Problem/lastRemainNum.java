package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;

public class lastRemainNum {

    public static void main(String[] args) {

    }

    public int lastRemainNum(int n, int m) {
        // 最后一个删除的数字
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
