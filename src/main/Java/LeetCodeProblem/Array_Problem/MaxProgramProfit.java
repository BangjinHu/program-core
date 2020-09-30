package LeetCodeProblem.Array_Problem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProgramProfit {

    public class Program {
        public int cost;//项目花费
        public int profit;//项目利润

        public Program(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    //定义小根堆如何比较大小
    public class CostMinHeapComp implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.cost - o2.cost;
        }
    }

    //定义大根堆如何比较大小
    public class ProfitMaxHeapComp implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }

    public int maxProgramProfit(int W, int K, int[] costs, int[] profits){
        //无效参数
        if (W < 1 || K < 0 || costs == null || profits == null || costs.length != profits.length){
            return W;
        }

        //项目花费小根堆，花费最少的项目在堆顶
        PriorityQueue<Program> costMinHeap = new PriorityQueue<>(new CostMinHeapComp());
        //项目利润大根堆，利润最大的项目在堆顶
        PriorityQueue<Program> profitMaxHeap = new PriorityQueue<>(new ProfitMaxHeapComp());

        //所有项目都进项目花费最少的小根堆
        for (int i = 0; i < costs.length; i++){
            costMinHeap.add(new Program(costs[i], profits[i]));
        }

        //依次做K个项目
        for (int i = 1; i <= K; i++){
            //当前资金为W，在项目花费小根堆所有花费小于或等于W的项目弹出
            while (!costMinHeap.isEmpty() && costMinHeap.peek().cost <= W){
                //可以考虑将所有花费小与W的项目放进利润大根堆里
                profitMaxHeap.add(costMinHeap.poll());
            }
            //如果此时的大根堆为空，说明没有项目被解锁，所以返回W
            if (profitMaxHeap.isEmpty()){
                return W;
            }

            //如果不为空，则从项目最大利润开始做
            W += profitMaxHeap.peek().profit;
        }
        return W;
    }
}
