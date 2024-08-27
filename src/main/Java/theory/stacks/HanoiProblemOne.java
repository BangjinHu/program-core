package theory.stacks;

import java.util.Stack;

public class HanoiProblemOne {

    public static void main(String[] args) {
        int num = 3;
        String left = "left";
        String right = "right";
        String mid = "mid";

//        System.out.println(hanoiProblem(num, left, mid, right));
        System.out.println(hanoiProblemTwo(num, left, mid, right));
    }

    //递归方法
    public static int hanoiProblem(int num, String left, String mid, String right){
        if (num < 1){
            return 0;
        }
        return hanoiProblemProcess(num, left, mid, right, left, right);
    }

    public static int hanoiProblemProcess(int num, String left, String mid, String right, String from, String to){
        if (num == 1){
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("move left from " + from + " to " + to);
                return 1;
            }else {
                System.out.println("move left from " + from + " to " + mid);
                System.out.println("move left from " + from + " to " + to);
                return 2;
            }
        }

        //起点或终点是mid
        if (from.equals(mid) || to.equals(mid)){
            //起点或终点是不是left
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int partOne = hanoiProblemProcess(num - 1, left, mid, right, from, another);
            int partTwo = 1;
            System.out.println("move " + num + " from " + from + " to " + to);
            int partThree = hanoiProblemProcess(num - 1, left, mid, right, another, to);
            return partOne + partTwo + partThree;
        }else {
            int partOne = hanoiProblemProcess(num - 1, left, mid, right, from, to);
            int partTwo = 1;
            System.out.println("move " + num + " from " + from + " to " + mid);
            int partThree = hanoiProblemProcess(num - 1, left, mid, right, to, from);
            int partFour = 1;
            System.out.println("move " + num + " from " + mid + " to " + to);
            int partFive = hanoiProblemProcess(num - 1, left, mid, right, from, to);
            return partOne + partTwo + partThree + partFour + partFive;
        }
    }

    public enum Action{
        No, LToM, MToL, MToR, RToM
    }

    public static int hanoiProblemTwo(int num, String left, String mid, String right){
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();

        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--){
            lS.push(i);
        }

        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1){
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to){
        //两个原则
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            System.out.println("move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}
