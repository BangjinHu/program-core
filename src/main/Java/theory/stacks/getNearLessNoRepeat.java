package theory.stacks;

import java.util.Arrays;
import java.util.Stack;

public class getNearLessNoRepeat {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,5,6,2,7};
        for (int i = 0; i < arr.length; i++){
            //打印二维数组需要利用一维数组操作，Arrays.toString()方法只能适用于一维数组
            System.out.println(Arrays.toString(getNearLessNoRepeat(arr)[i]));
        }
    }

    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            //1.当栈不为空且栈顶元素比arr[i]大，如果将arr[i]压入栈就不满足单调栈的原则
            //ps：这里的单调栈是严格按照单调递减执行
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                result[popIndex][0] = leftLessIndex;
                result[popIndex][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            result[popIndex][0] = leftLessIndex;
            result[popIndex][1] = -1;
        }

        return result;
    }
}
