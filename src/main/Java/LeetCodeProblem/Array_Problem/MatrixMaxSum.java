package LeetCodeProblem.Array_Problem;

public class MatrixMaxSum {
    public static void main(String[] args) {

    }

    public int matrixMaxSum(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] sum = null;
        //1.首先遍历整个矩阵
        for (int i = 0; i != matrix.length; i++){
            sum = new int[matrix[0].length];
            for (int j = i; j != matrix[0].length; j++){
                cur = 0;
                for (int k = 0; k != sum.length; k++){
                    //3.子矩阵元素之和
                    sum[k] += matrix[j][k];
                    //5.第一行更新，然后在第一行基础上第二行更新，依次类推
                    cur += sum[k];
                    //2.更新max的值
                    max = Math.max(max, cur);
                    //4.如果当前元素值小于0则不更新当前元素值cur
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
