package actual.Didi;

public class Reverse {

    public static void main(String[] args) {
        int num = 1234;
        int res = reverseInteger(num);
        System.out.println("current num converted result is: " + res);
    }

    private static int reverseInteger(int number) {

        String str = String.valueOf(number);
        boolean sign = str.charAt(0) == '-';
        long res = 0L;
        while (number != 0) {
            res = res * 10 + number % 10;
            number /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return sign ? (int) -res : (int) res;
    }
}
