package LeetCodeProblem.Array_Problem;

public class MaxProgramProfitValidate {
    public static void main(String[] args) {
        MaxProgramProfit maxProgramProfit = new MaxProgramProfit();
        int W = 3;
        int K = 2;
        int[] costs = new int[]{5,4,1,2};
        int[] profits = new int[]{3,5,3,2};
        System.out.println("收益最大是：" + maxProgramProfit.maxProgramProfit(W, K, costs, profits));
    }
}
