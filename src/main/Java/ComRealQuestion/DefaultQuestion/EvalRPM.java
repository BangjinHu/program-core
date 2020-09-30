package ComRealQuestion.DefaultQuestion;

import java.util.Scanner;
import java.util.Stack;

public class EvalRPM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            System.out.println(evalRPM(strs));
        }
    }

    public static int evalRPM(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            try {
                int num = Integer.parseInt(tokens[i]);//不是数字的话会抛出异常进入catch块处理
                stack.push(num);
            }catch (Exception e){//异常出来
                int b = stack.pop();
                int a = stack.pop();
                stack.add(eval(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }

    private static int eval(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
