package theory.stacks;

import java.util.Stack;

public class MinNumStackTwo {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinNumStackTwo() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum < this.getMin()){
            this.stackMin.push(newNum);
        }else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return this.stackMin.peek();
    }

}
