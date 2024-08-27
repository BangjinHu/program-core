package theory.bits;

public class BitMaxNum {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;

        System.out.println(bitMaxNumOne(a, b));

        System.out.println(bitMaxNumTwo(a, b));

    }

    public static int flip(int n){
        //2.n为0返回1，n为1返回0
        return n^1;
    }

    public static int sign(int n){
        //1.确定整数n的符号位 正数和零返回1，负数返回0
        return flip((n>>31) & 1);
    }

    public static int bitMaxNumOne(int a, int b){
        int c = a - b;
        //返回符号位
        int scA = sign(c);

        //返回在符号位基础上的计算值
        int scB = flip(scA);

        //返回最后的结果
        return a*scA + b*scB;
    }

    public static int bitMaxNumTwo(int a, int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }


}
