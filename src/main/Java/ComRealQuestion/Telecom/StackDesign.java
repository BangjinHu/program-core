package ComRealQuestion.Telecom;

import java.util.Scanner;
import java.util.Stack;

public class StackDesign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++){
                String[] strs = sc.nextLine().split(" ");
                String str = strs[0];
                if (str.equals("push")){
                    int num = Integer.parseInt(strs[1]);
                    minStack.push(num);
                }else if (str.equals("pop")){
                    minStack.pop();
                }else if(str.equals("top")){
                    System.out.println(minStack.top());
                }else if(str.equals("getMin")){
                    System.out.println(minStack.min());
                }
            }
        }
    }

    public static class MinStack {
        Stack<Integer> A, B;
        public MinStack(){
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x){
            A.add(x);
            if (B.isEmpty() || B.peek() >= x){
                B.add(x);
            }
        }
        public void pop(){
            if (A.pop().equals(B.peek())){
                B.pop();
            }
        }
        public int top(){
            return A.peek();
        }
        public int min(){
            return B.peek();
        }
    }
}
