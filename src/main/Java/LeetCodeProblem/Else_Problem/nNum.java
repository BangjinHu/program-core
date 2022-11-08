package LeetCodeProblem.Else_Problem;

import java.math.BigInteger;

public class nNum {

    public static void main(String[] args) {
        int num = 30;
        long i = nNum(num);
        System.out.println(i);


    }

    public static long nNum(int num) {
        if (num < 2) {
            return num;
        }
        long ans = 1;
        for (int i = num; i >= 1; i--) {
            ans *= i;
        }
        int lNum = num;
        while (num >= 1) {
            if (num * num < lNum) {
                ans *= num * num;
                num /= 2;
            } else if (num * num > lNum) {
                ans *= num;
            }
        }
        for (int i = num / 2; i >= 1; i--) {
            ans *= i;
        }


//        if (ans >= Integer.MAX_VALUE || ans <= Integer.MIN_VALUE) {
//            return
//        }
        return ans;
    }
}
