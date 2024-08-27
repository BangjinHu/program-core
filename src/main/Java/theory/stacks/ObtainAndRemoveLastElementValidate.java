package theory.stacks;

import java.util.Stack;

public class ObtainAndRemoveLastElementValidate {
    public static void main(String[] args) {
        ObtainAndRemoveLastElement o = new ObtainAndRemoveLastElement();
        int[] arr = new int[]{1,2,3,4,5};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }
        o.obtainAndRemoveLastElementTwo(stack);
        System.out.println(stack);
    }
}
