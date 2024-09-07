package theory.graphs;

public class Islands {

    public static void main(String[] args) {
//        String[][] matrix = new String[][]{
//                {"1", "1", "1", "1", "0"},
//                {"1", "1", "0", "1", "0"},
//                {"1", "1", "0", "0", "0"},
//                {"0", "0", "0", "0", "0"}
//        };

        String[][] matrix = new String[][]{
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };


        System.out.println(islandsNums(matrix));
    }

    private static int islandsNums(String[][] matrix) {
        int nums = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ("1".equals(matrix[i][j])) {
                    ++nums;
                    dfs(matrix, i, j);
                }
            }
        }
        return nums;
    }

    private static void dfs(String[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || "0".equals(matrix[i][j])) {
            return;
        }
        matrix[i][j] = "0";
        dfs(matrix, i - 1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }
}
