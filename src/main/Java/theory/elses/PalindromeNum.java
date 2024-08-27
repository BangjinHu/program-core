package theory.elses;

public class PalindromeNum {

    public static void main(String[] args) {
        int n = 123456;
        System.out.println("32位数" + n + "是否是回文数：" + palindromeNum(n));
    }

    public static boolean palindromeNum(int n){
        //1.当n是32位最小数时不是回文数，直接返回false
        if (n == Integer.MIN_VALUE){
            return false;
        }

        //2.然后将数变成它对绝对值
        n = Math.abs(n);
        int help = 1;
        //n的位数不小于两位
        while (n / help >= 10){
            help *= 10;
        }

        while (n != 0){
            //n的第一位和最后一位不等，则直接判断不是回文数，返回false
            if (n / help != n % 10){
                return false;
            }
            //第一位和最后一位是回文数之后，然后去掉第一位和最后一位
            n = (n % help) / 10;
            //help值也和新的num位数一样
            help /= 100;
        }
        return true;
    }
}
