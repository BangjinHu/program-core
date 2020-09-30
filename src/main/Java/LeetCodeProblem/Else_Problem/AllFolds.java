package LeetCodeProblem.Else_Problem;

public class AllFolds {
    public static void main(String[] args) {
        int N = 3;
        System.out.println("对折" + N +"次之后的折痕是：");
        allFolds(N);
    }

    public static void allFolds(int N){
        process(1, N, true);
    }

    public static void process(int i, int N, boolean down){
        if (i > N){
            return;
        }

        process(i+1, N, true);
        System.out.print(down ? " down" : " up");
        process(i+1, N, false);
    }
}
