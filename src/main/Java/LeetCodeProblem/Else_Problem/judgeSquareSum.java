package LeetCodeProblem.Else_Problem;

public class judgeSquareSum {

    public static void main(String[] args) {
        int num = 2147483600;
        System.out.println(isValid(num));
        System.out.println(num);
        System.out.println((int)Math.sqrt(num));
    }

    public static boolean isValid(int num) {
        int pA = 0, pB = (int)Math.sqrt(num);
        while(pA <= pB) {
            long sum = pA * pA + pB * pB;
            if(sum > num) {
                pB -= 1;
            } else if(sum < num) {
                pA += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
