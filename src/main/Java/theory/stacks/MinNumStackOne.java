package theory.stacks;
//获取最小值功能栈
import java.util.Stack;

public class MinNumStackOne {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinNumStackOne() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("栈为空");
        }

        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return this.stackMin.peek();
    }

}
