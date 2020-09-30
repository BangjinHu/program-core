package LeetCodeProblem.Array_Problem;

public class IsContainK {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        int K = 12;
        System.out.println(isContainK(matrix, K));

    }

    public static boolean isContainK(int[][] matrix, int K){
        int row = 0;
        //0.从右上角开始在行和列上分别遍历 所以空间复杂度是O(N+M)
        int col = matrix[0].length - 1;
        while (row < matrix.length - 1 && col > -1){
            //1.如果在(row,col)位置处的值等于K，则返回true
            if (matrix[row][col] == K){
                return true;
            }else if (matrix[row][col] < K){//2.如果在(row,col)位置处的值小于K，则向下移动
                row++;
            }else {//3.否则向左移动
                col--;
            }
        }
        return false;
    }
}
