package theory.stacks;

import java.util.Stack;
//设计两个递归函数
public class ObtainAndRemoveLastElement {

    //移除并返回当前栈顶元素，当栈为空时从新压入移除的元素
    public static int obtainAndRemoveLastElementOne(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = obtainAndRemoveLastElementOne(stack);
            stack.push(result);
            return last;
        }
    }

    public static void obtainAndRemoveLastElementTwo(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int i = obtainAndRemoveLastElementOne(stack);
        obtainAndRemoveLastElementTwo(stack);
        stack.push(i);
    }
}
