package theory.stacks;

import java.util.Stack;

public class SortStackByStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[]{5,1,4,2,3,6};
        for (int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }

        sortStackByStack(stack);

        System.out.println(stack);
    }

    public static void sortStackByStack(Stack<Integer> stack){

        Stack<Integer> stackHelp = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!stackHelp.isEmpty() && stackHelp.peek() < cur){
                stack.push(stackHelp.pop());
            }

            stackHelp.push(cur);
        }

        while (!stackHelp.isEmpty()){
            stack.push(stackHelp.pop());
        }

    }
}
