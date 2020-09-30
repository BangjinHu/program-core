package LeetCodeProblem.IEEE;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {

        int[] init = new int[]{5,10};
        int[][] intervals = new int[][]{{3,7},{6,12},{2,11}};
        int[] cost = new int[]{2,5,6};
        merge(intervals, init, cost);

    }

    public static int merge(int[][] intervals, int[] init, int[] cost) {

        List<int[]> result = new ArrayList<>();
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int i = 0;
        int result_cost = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            //数组囊括的情况
            if (left < init[0] && right > init[1]){
                return cost[i];
            }
            //两个区间有重叠的处理
            if (left < init[0] || right > init[1]) {
                while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                    i++;
                    //拿到比较出来的两个值中最大的作为right
                    right = Math.max(right, intervals[i][1]);
                }
                //将新生成的区间放入数组加入到返回结果数组
                result.add(new int[]{left, right});
                if (result.get(0)[0] < init[0] && result.get(1)[1] > init[1]){
                    result_cost = cost[i] + cost[i+1];
                }
                //继续while循环下一个区间
                i++;
            }
        }
        //返回最终的结果数组
        return result_cost;
    }
}
