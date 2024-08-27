package theory.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class getNearLess {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,3,4,3,5,3,2,2};
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(getNearLess(arr)[i]));
        }
    }

    //数组中有重复值出现利用单调栈解决问题
    public static int[][] getNearLess(int[] arr){
        int[][] result = new int[arr.length][2];
        //1.可能会有重复值出现的情况
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){

            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> popIs = stack.pop();
                //2.去重复值最后出现的下标
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                for (Integer popi : popIs){
                    result[popi][0] = leftIndex;
                    result[popi][1] = i;
                }
            }

            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(Integer.valueOf(i));
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()){
            List<Integer> popIs = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
            for (Integer popi : popIs){
                result[popi][0] = leftIndex;
                result[popi][1] = -1;
            }
        }
        return result;
    }
}
