package theory.stacks;

import java.util.Stack;

public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    //push向pop导入数据
    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        pushToPop();
        return stackPop.peek();
    }
}
