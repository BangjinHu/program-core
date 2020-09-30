package LeetCodeProblem.Else_Problem;

import java.util.HashSet;

public class IsRectangleCover {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println("能够完美拼出矩形：" + isRectangleCover(matrix));

    }

    public static boolean isRectangleCover(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        //初始化最大矩形的四个顶点
        int mostLeft = Integer.MAX_VALUE;
        int mostRight = Integer.MIN_VALUE;
        int mostDown = Integer.MAX_VALUE;
        int mostUp = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect : matrix){
            //大矩形的四个顶点
            mostLeft = Math.min(rect[0], mostLeft);
            mostDown = Math.min(rect[1], mostDown);
            mostRight = Math.max(rect[2], mostRight);
            mostUp = Math.max(rect[3], mostUp);

            //所有的小矩形的面积相加
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            //左下角顶点
            String leftDown = rect[0] + "_" + rect[1];
            //左上角顶点
            String leftUp = rect[0] + "_" + rect[3];
            //右下角顶点
            String rightDown = rect[2] + "_" + rect[1];
            //右上角顶点
            String rightUp = rect[2] + "_" + rect[3];

            //更新四个顶点的值，因为每个小矩形的顶点出现的次数是偶数次才会组成大的矩形
            if (!set.add(leftDown)) set.remove(leftDown);
            if (!set.add(rightDown)) set.remove(rightDown);
            if (!set.add(leftUp)) set.remove(leftUp);
            if (!set.add(rightUp)) set.remove(rightUp);
        }

        //如果最终更新的四个顶点值不包括之前已经求出的矩形四个顶点的最大值
        if (!set.contains(mostLeft + "_" + mostDown) || !set.contains(mostLeft + "_" + mostUp) || !set.contains(mostRight + "_" + mostDown) || !set.contains(mostRight + "_" + mostUp) || set.size() != 4){
            return false;
        }

        return area == (mostUp - mostDown) * (mostRight - mostLeft);
    }
}
