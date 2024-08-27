package theory.bits;

public class BitNum {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        System.out.println("a+b=" + bitNumAdd(a, b));
        System.out.println("a-b=" + bitNumSub(a, b));
        System.out.println("a*b=" + bitNumMulti(a,b));
        System.out.println("a/b=" + bitNumDiv(a, b));

    }

    public static int bitNumAdd(int a, int b){
        int sum = a;
        while (b != 0){
            //1.完全不考虑进位的相加值情况
            sum = a ^ b;

            //2.只考虑进位相加的情况
            b = (a & b) << 1;
            a = sum;
        }

        return sum;
    }

    public static int bitNumSub(int a, int b){
        //两数相减等于一个数加上减数的补码
        return bitNumAdd(a, negNum(b));
    }

    public static int negNum(int n){
        //取得n的补码 n数取反加1
        return bitNumAdd(~n, 1);
    }

    //位运算实现乘法运算 被乘数加上乘数倍的被乘数就可以
    //注意：这里的符号问题
    //a*b=a*2^0*b0 + ... + a*2^31*b31(这样一来，符号问题解决)
    public static int bitNumMulti(int a, int b){
        int result = 0;
        while (b != 0){
            if ((b & 1) != 0){
                result = bitNumAdd(result, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return result;
    }

    //根据除法运算我们可以联想到减法运算，被除数不断减除数直到被除数小于除数为止
    //减法所进行的次数就是商，此时的被除数就是余数
    public static int bitNumDiv(int a, int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int result = 0;

        //开始先计算绝对值的情况
        for (int i = 31; i > -1; i = bitNumSub(i, 1)){
            //被除数右移i次之后大于除数
            if ((x>>i) >= y){
                //结果就等于i的值(商)
                result |= (1 << i);
                //然后剩余的被除数减去y左移i步长，这是为了提高效率，不用步长为1的进行计算
                x = bitNumSub(x, y << i);
            }
        }
        //得到最终的结果，如果a b两个数中有负数则返回结果的相反数
        return isNeg(a) ^ isNeg(b) ? negNum(result) : result;
    }

    public static boolean isNeg(int n){
        return n < 0;
    }
}
