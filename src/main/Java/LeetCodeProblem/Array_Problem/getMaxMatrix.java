package LeetCodeProblem.Array_Problem;

public class getMaxMatrix {

    public static void main(String[] args) {

    }

    public int[] getMaxMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        // 保存最大子矩阵的左上角和右下角的行列坐标
        int[] ans = new int[4];
        int N = matrix.length;
        int M = matrix[0].length;

        // 记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int[] nums = new int[M];
        int sum = 0;

        // 记录最大值
        int maxSum = Integer.MIN_VALUE;

        int upRow = 0;
        // 暂时记录左上角，相当于begin
        int upCol = 0;

        // 以i为上边，从上而下扫描
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[j] = 0;
            }
            for (int j = i; j < N; j++) {
                sum = 0;
                for (int k = 0; k < M; k++) {
                    nums[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += nums[k];
                    } else {
                        sum = nums[k];
                        upRow = i;
                        upCol = k;
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        ans[0] = upRow;
                        ans[1] = upCol;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }
}
