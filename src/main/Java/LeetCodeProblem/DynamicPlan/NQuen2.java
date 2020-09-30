package LeetCodeProblem.DynamicPlan;

public class NQuen2 {

    public static void main(String[] args) {

        int n = 8;
        System.out.println("the kinds of nums : " + nQuen(n));
    }

    public static int nQuen(int n){
        if (n < 1 || n > 32){
            return 0;
        }

        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        return process(upperLim, 0, 0, 0);
    }

    public static int process(int upperLim,
                              int colLim,
                              int leftDiaLim,
                              int rightDiaLim){
        if (colLim == upperLim){
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process(upperLim,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
