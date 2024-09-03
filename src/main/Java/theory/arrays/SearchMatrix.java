package theory.arrays;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println("matrix is exist target num ? " + searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = 0, cols = matrix[0].length - 1;
        // 从右上角开始遍历
        while (rows <= matrix.length && cols >= 0) {
            if (matrix[rows][cols] == target) {
                return true;
            } else if (matrix[rows][cols] < target) {
                ++rows;
            } else {
                --cols;
            }
        }
        return false;
    }
}
